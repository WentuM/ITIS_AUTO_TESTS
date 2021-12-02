package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.models.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateEntityTestCase extends TestBase {

  public static Post readFile() throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Post.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    return (Post) jaxbUnmarshaller.unmarshal(new File("test.xml"));
  }

  @ParameterizedTest
  @MethodSource("readFile")
  @Test
  public void generateEntityTestCase() throws Exception {
    appManager.getNavigationHelper().getPostGenerateEntityPage();
    Post post = readFile();
    appManager.getTestHelper().generatePost(post);

    Post createPost = appManager.getTestHelper().getCreatedCommentData();

    assertEquals(post.getTextPost(), createPost.getTextPost());
  }
}