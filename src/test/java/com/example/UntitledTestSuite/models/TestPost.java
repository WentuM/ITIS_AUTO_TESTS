package com.example.UntitledTestSuite.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "testPost")
@XmlRootElement
public class TestPost {
    private String textPost;
}