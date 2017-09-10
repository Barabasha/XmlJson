import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlJson {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ToJson toJson = new ToJson();
        String pathJson = "C:\\test_hillel\\XmlJson\\output.json";
        String pathXml = "C:\\test_hillel\\XmlJson\\conf.xml";
        toJson.writeToJson(pathJson, pathXml);
    }
}
