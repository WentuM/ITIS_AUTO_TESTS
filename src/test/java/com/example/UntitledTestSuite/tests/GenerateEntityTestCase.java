package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.models.ListOfTestPost;
import com.example.UntitledTestSuite.models.Post;
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

public class GenerateEntityTestCase extends TestBase {

  protected static List<Post> readFile() throws Exception {
    File file = new File("test.xml");
    JAXBContext jaxbContext = JAXBContext.newInstance(ListOfTestPost.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    ListOfTestPost testsData = (ListOfTestPost) jaxbUnmarshaller.unmarshal(file);
    return testsData.getTestPostList();
  }

  @ParameterizedTest
  @MethodSource("readFile")
  public void generateEntityTestCase(Post post) throws Exception {
    appManager.getNavigationHelper().getPostGenerateEntityPage();
    appManager.getTestHelper().generatePost(post);

    Post createPost = appManager.getTestHelper().getCreatedCommentData();

    assertEquals(post.getTextPost(), createPost.getTextPost());
  }
}