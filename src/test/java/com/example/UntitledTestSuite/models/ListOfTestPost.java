package com.example.UntitledTestSuite.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "listOfTestPost")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOfTestPost {
    @XmlElement(name = "testPostList")
    private List<Post> testPostList;
}