package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.models.ListOfTestPost;
import com.example.UntitledTestSuite.models.Post;
import com.github.javafaker.Faker;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class PostGenerator {
    public static void main(String[] args) {
        Faker faker = new Faker();

        List<Post> testPostList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Post testPost = Post.builder()
                    .textPost(faker.book().title())
                    .build();

            testPostList.add(testPost);
        }

        jaxbObjectToXML(new ListOfTestPost(testPostList));
    }

    private static void jaxbObjectToXML(ListOfTestPost testPostList) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListOfTestPost.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();

            jaxbMarshaller.marshal(testPostList, sw);

            File file = new File("test.xml");
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(sw.toString());
            printWriter.close();

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}