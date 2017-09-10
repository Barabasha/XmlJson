import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

class DirectoryReader {

    DirectoryReader() throws IOException, SAXException, ParserConfigurationException {
    }

    ArrayList<String> directoryReader(Configuration conf) throws IOException {
        File dir = new File(conf.getDirectory());
        File[] files = dir.listFiles();
        String line_in_file;
        ArrayList<String> fileString = new ArrayList<>();
        if (files != null) {
            for (File unit : files) {
                String path = unit.getAbsolutePath();
                if (Objects.equals(conf.getExtension(), path.substring(path.length() - 3, path.length()))) {
                    BufferedReader br = new BufferedReader(new FileReader(unit.getAbsolutePath()));
                    while ((line_in_file = br.readLine()) != null) {
                        fileString.add(line_in_file);
                    }
                }
            }
        }
        return fileString;
    }
}


