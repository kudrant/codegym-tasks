package com.codegym.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Tracking changes

*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader lineReader1 = new BufferedReader( new FileReader(fileName1));
        BufferedReader lineReader2 = new BufferedReader( new FileReader(fileName2));
        String line1 = lineReader1.readLine();
        String line2 = lineReader2.readLine();
        String line1Next = lineReader1.readLine();
        String line2Next = lineReader2.readLine();
        while(true) {

            if (line1Next == null && line2Next == null) {
                if ( line1 != null ) lines.add( new LineItem(Type.REMOVED, line1) );
                if ( line2 != null ) lines.add( new LineItem(Type.ADDED, line2) );
                break;
            }
            if ( line1.equals(line2) ) {
                lines.add( new LineItem(Type.SAME, line1) );
                line1 = line1Next;
                line2 = line2Next;
                line1Next = lineReader1.readLine();
                line2Next = lineReader2.readLine();
            } else if ( line1.equals(line2Next) ) {
                lines.add( new LineItem(Type.ADDED, line2) );
                line2 = line2Next;
                line2Next = lineReader2.readLine();
            } else if ( line1Next.equals(line2) ) {
                lines.add( new LineItem(Type.REMOVED, line1) );
                line1 = line1Next;
                line1Next = lineReader1.readLine();
            }
        }
        lineReader1.close();
        lineReader2.close();
    }

    public static enum Type {
        ADDED,        // New line added
        REMOVED,      // Line deleted
        SAME          // No change
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
