package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.models.TestPost;
import com.github.javafaker.Faker;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PostGenerator {
    public static void main(String[] args) {
        Faker faker = new Faker();


        TestPost commentData = TestPost.builder()
                .textPost(faker.book().title())
                .build();

        jaxbObjectToXML(commentData);
    }

    private static void jaxbObjectToXML(TestPost testPost) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TestPost.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();

            jaxbMarshaller.marshal(testPost, sw);

            File file = new File("test.xml");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(sw.toString());
            printWriter.close();

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
