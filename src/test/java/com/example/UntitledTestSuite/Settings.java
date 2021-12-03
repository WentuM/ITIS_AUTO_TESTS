package com.example.UntitledTestSuite;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

public class Settings {
    public static String file = "settings.xml";
    private static final Document document;
    private static String login;
    private static String password;
    private static String baseUrl;

    static {
        String filepath= "src/test/resources/" + file;
        document = getDocument(filepath);
    }

    private static String evaluateXPath(String xpathExpression) {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        try {
            XPathExpression expr = xpath.compile(xpathExpression);

            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

            if (nodes.getLength() > 0) {
                return nodes.item(0).getNodeValue();
            }

        } catch (XPathExpressionException e) {
            throw new IllegalArgumentException(e);
        }

        throw new IllegalArgumentException();
    }

    private static Document getDocument(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(fileName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getLogin() {
        if (login == null) {
            login = evaluateXPath("/settings/login/text()");
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = evaluateXPath("/settings/password/text()");
        }
        return password;
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = evaluateXPath("/settings/baseUrl/text()");
        }
        return baseUrl;
    }
}
