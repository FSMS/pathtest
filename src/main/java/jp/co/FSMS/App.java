package jp.co.FSMS;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class App {

    //private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        //logger.info(System.getProperty("hoge", "default"));
        //logger.info(args[0]);
        addClassPath("../../config/" + args[0] + "/");
        Logger logger = LogManager.getLogger();
        logger.info("hige");
    }
    private static void addClassPath(String path){
        URLClassLoader loader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        try {
            URL u = new File(path).toURI().toURL();
            Method m = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{ URL.class });
            m.setAccessible(true);
            m.invoke(loader, new Object[]{u});
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
