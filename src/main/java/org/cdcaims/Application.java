package org.cdcaims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cdcaims.models.CurrencyMaster;
import org.cdcaims.models.StatusMaster;
import org.cdcaims.repos.CurrencyRepository;
import org.cdcaims.repos.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

    @Bean
    public CommandLineRunner demo(CurrencyRepository repository, StatusRepository statusRepository) {
        return (args) -> {

            StatusMaster active = new StatusMaster("A", "Active");
            StatusMaster inactive = new StatusMaster("I", "Inactive");

            /* save statuses */
            statusRepository.save(active);
            statusRepository.save(inactive);

            /* save some default currencies */
            repository.save(new CurrencyMaster("CHF", "Switzerland Franc", active));
            repository.save(new CurrencyMaster("CLP", "Chile Peso", inactive));
            repository.save(new CurrencyMaster("CNY", "China Yuan Renminbi", active));
            repository.save(new CurrencyMaster("COP", "Colombia Peso", inactive));
        };
    }
}