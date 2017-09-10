import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

class Configuration {
    private String directory;
    private String extension;

    Configuration() {
    }

    String getExtension() {
        return extension;
    }

    String getDirectory() {
        return directory;
    }

    Configuration create(String pathXml) throws ParserConfigurationException, IOException, SAXException {
        Configuration conf = new Configuration();
        File input_file = new File(pathXml);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input_file);
        NodeList nodes = doc.getElementsByTagName("configuration");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            NodeList children = node.getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                Node child = children.item(j);
                if (Objects.equals(child.getNodeName(), "directory")) {
                    conf.directory = child.getTextContent();
                }
                if (Objects.equals(child.getNodeName(), "extension")) {
                    conf.extension = child.getTextContent();
                }
            }
        }
        return conf;
    }
}

