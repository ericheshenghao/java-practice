package cn.siques.手写RPC框架.server.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : heshenghao
 * @date : 15:18 2021/4/24
 */
public class Config {
    static Properties properties;


    static {
        try (InputStream is = Config.class.getResourceAsStream("/application.properties")) {
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
