//package com.example.UntitledTestSuite.helpers;
//
//import com.example.AppManager;
//import com.example.UntitledTestSuite.models.Post;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//public class PostHelper extends BaseHelper {
//
//    public PostHelper(AppManager appManager) {
//        super(appManager);
//    }
//
//    public void createPostEntity(Post post) {
//        driver.findElement(By.id("textPost")).click();
//        driver.findElement(By.id("textPost")).clear();
//        driver.findElement(By.id("textPost")).sendKeys(post.getTextPost());
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//    }
//
//    public void updatePostEntity(Post post) {
//        List<WebElement> posts = driver.findElements(By.cssSelector("div.tweet__item"));
//        WebElement sitePost = posts.get(posts.size() - 1);
//        sitePost.findElement(By.id("body")).click();
//        sitePost.findElement(By.id("body")).clear();
//        sitePost.findElement(By.id("body")).sendKeys(post.getTextPost());
//        sitePost.findElement(By.className("send__tweet-btn")).click();
//    }
//
//    public Post getLastCreatePost() {
//        List<WebElement> posts = driver.findElements(By.cssSelector("div.tweet__item"));
//        String textPost = posts.get(posts.size() - 1).findElement(By.id(
//                "body"
//                )
//        ).getAttribute("placeholder");
//        String filename = posts.get(posts.size() - 1).findElement(By.className(
//                "tweet__aliase-author"
//                )
//        ).getText();
//
//        return new Post(textPost, filename);
//    }
//}