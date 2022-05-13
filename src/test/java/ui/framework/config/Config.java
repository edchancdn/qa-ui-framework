package ui.framework.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
public class Config {

    private static Logger logger = LogManager.getLogger();
    private static Config instance;
    private Properties properties;
    private final String propertyFileName = "framework.properties";

    private Config(){
        Path path = Paths.get("src", "test", "resources", propertyFileName);
        logger.info("Reading file {} from location {}", propertyFileName, path.toString());
        try (InputStream stream = new FileInputStream(path.toFile())) {
            properties = new Properties();
            properties.load(stream);
        }catch (FileNotFoundException ex) {
            logger.fatal("File {} doesn't exist on in location {}. Please check again", propertyFileName, path.toString());
        }catch (IOException exception){
            logger.fatal("Something went wrong while reading file- msg: {}",exception.getMessage());
        }
    }

    public synchronized static String getProperties(String key) {
        if(key == null || key.isEmpty() || key.isBlank()) {
            logger.error("Keys can't be null or blank");
            throw new IllegalArgumentException("invalid key");
        }
        if(instance == null) {
            instance = new Config();
        }
        logger.info("Retriving value for Key {} ", key);
        String property = instance.properties.getProperty(key);
        if(property==null) {
            logger.error("No value defined in properties file {} for key {} ", instance.propertyFileName ,key);
        }
        logger.debug("Retrieved value: {} for key: {}", key, property);

        return property;
    }
}
