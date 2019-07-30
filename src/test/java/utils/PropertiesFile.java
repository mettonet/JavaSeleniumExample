package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

    private static Properties prop = new Properties();
    private static String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) {
        getProperties();
        setProperties();
        getProperties();
    }

    public static void getProperties(){
        try {
            InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println(browser);
            BaseTest.browserName = browser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void setProperties(){
        try{
            OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
            prop.setProperty("result","pass");
            prop.store(output,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
