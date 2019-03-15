package com.app.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    private UserRepository userRepository;

    @Autowired
    public UserCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("Ranga", "Admin"));
        userRepository.save(new User("Ravi", "User"));
        userRepository.save(new User("Satish", "Admin"));
        userRepository.save(new User("Raghu", "User"));

        Stream.of(userRepository.findAll()).forEach(user -> {
           log.info(user.toString());
        });
    }

}
