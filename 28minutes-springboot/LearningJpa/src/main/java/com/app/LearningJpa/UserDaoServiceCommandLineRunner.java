package com.app.LearningJpa;

import com.app.LearningJpa.entity.User;
import com.app.LearningJpa.service.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    private UserDaoService userDaoService;

    @Autowired
    public UserDaoServiceCommandLineRunner(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @Override
    public void run(String... arg0) throws Exception {
        User user = new User("Jack", "Admin");
        userDaoService.insert(user);
        logger.info("New User is created: " + user.toString());
    }

}
