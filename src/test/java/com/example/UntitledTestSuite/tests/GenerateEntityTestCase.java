package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.helpers.AuthBase;
import com.example.UntitledTestSuite.models.ListOfTestPost;
import com.example.UntitledTestSuite.models.Post;
import com.example.UntitledTestSuite.models.TestPost;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateEntityTestCase extends AuthBase {

    protected static List<Post> readFile() throws Exception {
        File file = new File("test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(ListOfTestPost.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ListOfTestPost testsData = (ListOfTestPost) jaxbUnmarshaller.unmarshal(file);
        return testsData.getTestPostList();
    }

    @ParameterizedTest
    @MethodSource("readFile")
    @Test
    public void generateEntityTestCase() throws Exception {
        appManager.getNavigationHelper().getPostGenerateEntityPage();
        List<Post> post = readFile();
        appManager.getTestHelper().generatePost(post.get(post.size() - 1));

        Post createPost = appManager.getTestHelper().getCreatedCommentData();

        assertEquals(post.get(post.size()-1).getTextPost(), createPost.getTextPost());
    }
}