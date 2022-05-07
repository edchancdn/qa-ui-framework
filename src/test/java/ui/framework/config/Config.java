package ui.framework.config;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
public class Config {

    private static Config instance;
    private Properties properties;
    private final String propertyFileName =  "framework.properties";

    private Config(){
        Path path = Paths.get("src", "test", "resources", propertyFileName);
        try (InputStream stream = new FileInputStream(path.toFile())) {
            properties = new Properties();
            properties.load(stream);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized static String getProperties(String key) {
        if(instance == null) {
            instance = new Config();
        }
        return instance.properties.getProperty(key);
    }
}
