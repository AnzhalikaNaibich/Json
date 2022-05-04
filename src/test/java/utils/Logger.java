package utils;
import org.apache.log4j.LogManager;

public class Logger {
    private static org.apache.log4j.Logger logger = LogManager.getLogger(Logger.class);

    public static void info(String text){
        logger.info(text);
    }
    public static void error(String text){
        logger.error(text);
    }
}
