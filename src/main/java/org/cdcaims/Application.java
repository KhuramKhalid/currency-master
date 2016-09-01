package org.cdcaims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PreDestroy;

/**
 * @author khuramkhalid
 * @version 01/09/2016
 */
@SpringBootApplication
public class Application {
    private static Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @PreDestroy
    public static void shutdown() {
        log.info("stopped currency-master");
    }
}