package com.webappautomation.Locators;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ElementLocator
{
    private static final String locatorFile = System.getProperty("user.dir") + "/src/main/resources/Locators/ElementMap.xml";

    public static ElementIdentifier getElement(String name)
    {
        try
        {
            File file = new File(locatorFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            Node elementNode = doc.getElementsByTagName("Element")
                    .item(0)
                    .getParentNode()
                    .getChildNodes()
                    .item(0);

            for (int i = 0; i < elementNode.getChildNodes().getLength(); i++){
                Node node = elementNode.getChildNodes().item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE && node.getAttributes().getNamedItem("name") != null){
                    if (node.getAttributes().getNamedItem("name").getNodeValue().equals(name)){
                        String by = node.getChildNodes().item(1).getTextContent();
                        String value = node.getChildNodes().item(3).getTextContent();

                        ElementIdentifier identifier = new ElementIdentifier();
                        identifier.setBy(by);
                        identifier.setValue(value);
                        return identifier;
                    }
                }
            }
            throw new RuntimeException("Element with name '" + name + "' not found in XML.");
        } catch (Exception e){
            throw new RuntimeException("Failed to load locator: " + e.getMessage(), e);
        }
    }
}
