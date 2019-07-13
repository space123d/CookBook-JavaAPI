package com.mendixassignment.rest.webservices.restfulwebservices.resources;
 import java.io.IOException;
   import org.w3c.dom.*;
   import org.xml.sax.SAXException;
   import javax.xml.parsers.*;
   import javax.xml.xpath.*;

    public class XPathExample {

        public static void main(String[] args) throws ParserConfigurationException,
                SAXException, IOException, XPathExpressionException {

            DocumentBuilderFactory domFactory = DocumentBuilderFactory
                    .newInstance();
            domFactory.setNamespaceAware(true); 
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse("C://Users//N87613.LAUNCHER//MendixAssignment//CookBook-JavaAPI//restful-web-services//src//main//resources//30_Minute_Chili.xml");

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile("//FORM[@name='F00001']        /*/text()");

            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
            }

            }

             }