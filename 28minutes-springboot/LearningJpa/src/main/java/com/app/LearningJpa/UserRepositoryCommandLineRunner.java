package com.app.LearningJpa;

import com.app.LearningJpa.entity.User;
import com.app.LearningJpa.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... arg0) throws Exception {
        User user = new User("Jill", "Admin");
        userRepository.save(user);
        logger.info("New User is created: " + user.toString());

        User userWithIdOne = userRepository.findById(1L).orElse(null);
        if (userWithIdOne == null) {
            throw new Exception("User was null");
        }
        logger.info("User is retrieved: " + userWithIdOne);

        List<User> users = userRepository.findAll();
        logger.info("All users: " + users);
    }

}
