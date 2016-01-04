package nju.software;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.Map;

/**
 * Created by Xie on 2016/1/1.
 */
public class Log4jMakerExample {
    private Logger logger = LogManager.getLogger(Log4jMakerExample.class.getName());
    private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
    private static final Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE");
    private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY");

    public static void main(String[] args) {
        new Log4jMakerExample().doQuery("hello");
    }

    public void  doQuery(String table) {
        logger.entry("hello");

        logger.debug(QUERY_MARKER, "SELECT * FROM {}", table);

        logger.exit();
    }

    public void doUpdate(String table, Map<String, String> params) {
        logger.entry("hello");

        if (logger.isDebugEnabled()) {
            logger.debug(UPDATE_MARKER, "UPDATE {} SET {}", table, formatCols(params));

            logger.exit();
        }
    }

    private String formatCols(Map<String, String> cols) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : cols.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
}
