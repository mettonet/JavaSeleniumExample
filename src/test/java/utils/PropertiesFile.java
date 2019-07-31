package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {

    private static Properties prop = new Properties();
    private static String projectPath = System.getProperty("user.dir");


    public static void getProperties(){
        try {
            InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
            prop.load(input);

            String browser = prop.getProperty("browser");
            System.out.println("Seçilen browser: "+ browser);
            BaseTest.browserName = browser;

            String url = prop.getProperty("testUrl");
            System.out.println("gidilmek istenen url: "+url);
            BaseTest.testUrl = url;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

}
