package com.gisconsultoria.com.apiBox.utils;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author Luis Enrique Morales Soriano
 */
public interface IApBoxReadXmlFile {

    public void readXmlFile(File file)  throws IOException;

    public void decodeXmlFile(File file, String xml) throws Exception;

    public void unmarshallXmlToComprobanteXml(File file, String xml) throws Exception;

}
