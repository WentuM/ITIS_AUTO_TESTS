package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.models.Post;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateEntityTestCase extends TestBase {

    @Test
    public void updateEntityTestCase() throws Exception {
        appManager.getNavigationHelper().getHomePage();
        Post post = new Post("new text", "examplE@mail.ru");
        appManager.getTestHelper().editPost(post);

        Post createPost = appManager.getTestHelper().getCreatedCommentData();

        assertEquals(post.getTextPost(), createPost.getTextPost());
    }
}