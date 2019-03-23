package com.robert.bankTr.init;

import com.robert.bankTr.model.Login;
import com.robert.bankTr.model.User;
import com.robert.bankTr.repository.LoginRepository;
import com.robert.bankTr.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Robert", 232d)));
            log.info("Preloading " + repository.save(new User("Mircea", 323d)));
            log.info("Preloading " + repository.save(new User("Adrian", 543d)));


        };
    }

    @Bean
    boolean initDatabase2(LoginRepository logrepository) {
        logrepository.save(new Login("Andrei", "dude"));
        logrepository.save(new Login("", "dude"));
        return true;
    }


}
