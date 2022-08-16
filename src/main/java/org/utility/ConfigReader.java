package org.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties readConfigFile() {
        Properties prop = new Properties();

        FileInputStream fis;
        try {
            fis = new FileInputStream("./Input/config.properties");

            prop.load(fis);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return prop;

    }
}
