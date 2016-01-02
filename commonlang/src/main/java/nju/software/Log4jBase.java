package nju.software;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Xie on 2015/12/30.
 */
public class Log4jBase {

    private static Logger logger = LogManager.getLogger(Log4jBase.class);

    public static void main(String[] args) {

        System.out.println("start");
        if (logger.isInfoEnabled()) {
            logger.info("info");
        }

        logger.warn("warn");
        logger.error("error");
    }
}
