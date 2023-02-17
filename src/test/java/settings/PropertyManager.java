package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static String PropertyFilePath = System.getProperty("user.dir")+"\\Serenity.properties";
    public static String getLoadData (String PropertyKey){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(PropertyFilePath));
        } catch (IOException e) {
            System.out.println("Error en Cargando Config" + e.getMessage());
        }
        return prop.getProperty(PropertyKey);
    }
}
