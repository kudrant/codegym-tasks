package com.codegym.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/*
Comments inside XML

*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        StringWriter writer = new StringWriter();
        String result = "";
        String xmlString;
        // Create a Marshaller object that will perform the serialization
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);

            xmlString = writer.toString();

            if (xmlString.indexOf(tagName) > -1)
                result = xmlString.replace("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
            else
                result = xmlString;

        }catch (JAXBException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {

    }
}