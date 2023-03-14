package lesson3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/test/resources/my.properties");
        prop.load(configFile);
        apiKey =  prop.getProperty("apiKey");
        baseUrl= prop.getProperty("url");
    }
    @AfterEach
    public void cleanUpEach(){

    }
    @AfterAll
    public static void cleanUp(){

    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}