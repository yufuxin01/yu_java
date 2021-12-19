package yu.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname Main
 * @Date 2021/4/13 1:34
 * @Created by yufx
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        int status = 0;
        if (status == 0) {
            logger.info("status:{}", status);
        } else {
            logger.info("status:{}", status);
        }
        logger.info("end!");
    }
}
