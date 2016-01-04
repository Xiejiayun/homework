package nju.software;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.Logger;

/**
 * Created by Xie on 2015/12/30.
 */
public class Log4jBase {

    //    private static Logger logger = LogManager.getLogger(Log4jBase.class);
    final static Logger logger = (Logger) LogManager.getLogger(Logger.ENTRY_MARKER);
    private static int count = 0;

    public static void main(String[] args) {

        System.out.println("start");
        logger.info(Logger.ENTRY_MARKER, "info");
        if (logger.isInfoEnabled()) {
            logger.info("info");

        }

        logger.warn("warn");
        logger.error("error");
    }
}
