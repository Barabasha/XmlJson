import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class ToJson {

    void writeToJson(String pathJson, String pathXml) throws ParserConfigurationException, SAXException, IOException {
        JSONObject newObject = new JSONObject();
        DirectoryReader xj = new DirectoryReader();
        Configuration conf = new Configuration();
        conf = conf.create(pathXml);
        ArrayList<String> fileStrings;
        fileStrings = xj.directoryReader(conf);
        ArrayList<String> uppercase = new ArrayList<>();
        ArrayList<String> lowercase = new ArrayList<>();
        for (String elem : fileStrings) {
            char[] chars = elem.toCharArray();
            for (char ch : chars) {
                if (Character.isUpperCase(ch)) {
                    uppercase.add(String.valueOf(ch));
                }
                if (Character.isLowerCase(ch)) {
                    lowercase.add(String.valueOf(ch));
                }
            }
            newObject.put("uppercase", uppercase);
            newObject.put("lowercase", lowercase);
            try {
                FileWriter writer = new FileWriter(pathJson);
                writer.write(newObject.toJSONString());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}



