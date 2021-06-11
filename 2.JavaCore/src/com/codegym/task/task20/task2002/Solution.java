package com.codegym.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Reading and writing to a file: CodeGym

*/
public class Solution {
    public static void main(String[] args) {
        // You can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        try {
            File yourFile = File.createTempFile("c:/test6.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            CodeGym codeGym = new CodeGym();
            // Initialize users field for the codeGym object here
            User user = new User();
            user.setFirstName("Anton");
            user.setLastName("Kudryavtsev");
            //SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
            //Date birthDate = formatter.parse("28 10 1985");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.UNITED_STATES);
            codeGym.users.add(user);
            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);
            // Here check that the codeGym object is equal to the loadedObject object
            while (inputStream.available() > 0) {
                System.out.println(inputStream.read());
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class CodeGym {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            // Implement this method
           for(int i = 0; i < users.size(); i++){
                String firstName = users.get(i).getFirstName();
                String lastName = users.get(i).getLastName();
                String birthDate = users.get(i).getBirthDate().toString();
                String isMale = users.get(i).isMale()? "true":"false";
                String country = users.get(i).getCountry().toString();
                String user = firstName + "~" + lastName + "~" + birthDate + "~" + isMale + "~" + country; //firstName~lastName~birthDate~isMale~country
                outputStream.write(user.getBytes());
                outputStream.write(10); // new line char
            }

        }



        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = reader.readLine()) != null){
                if(line.equals("")) return;
                String[] data = line.split("~");
                User newUser = new User(); //firstName~lastName~birthDate~isMale~country
                newUser.setFirstName(data[0]);
                newUser.setLastName(data[1]);
                SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy", Locale.US);
                Date parsedDate = formatter.parse(data[2]);
                //Date dt = new Date(Long.parseLong(data[2]));
                newUser.setBirthDate(parsedDate);
                newUser.setMale(Boolean.parseBoolean(data[3]));
                switch (data[4]) {
                    case "UNITED_STATES":
                        newUser.setCountry(User.Country.UNITED_STATES);
                        break;
                    case "UNITED_KINGDOM":
                        newUser.setCountry(User.Country.UNITED_KINGDOM);
                        break;
                    default:
                        newUser.setCountry(User.Country.OTHER);
                        break;
                }
                users.add(newUser);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CodeGym codeGym = (CodeGym) o;

            return users != null ? users.equals(codeGym.users) : codeGym.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
