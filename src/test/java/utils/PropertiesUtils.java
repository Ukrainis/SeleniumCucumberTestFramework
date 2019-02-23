package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static String getPropertyValueByKey(String key){
        Properties properties = new Properties();
        String value = null;
        try(InputStream stream = new FileInputStream("config.properties")){
            properties.load(stream);
            return properties.getProperty(key);
        } catch (IOException ioe){
            System.out.println("File config.properties is not found.");
        }
        return value;
    }
}
