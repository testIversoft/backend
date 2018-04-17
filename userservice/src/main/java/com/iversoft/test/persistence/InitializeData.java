package com.iversoft.test.persistence;

import com.iversoft.test.persistence.DAO.UserRepository;
import com.iversoft.test.persistence.model.User;
import com.iversoft.test.persistence.model.UserAddresses;
import com.iversoft.test.persistence.model.UserRoles;
import com.iversoft.test.persistence.DAO.UserAddressesRepository;
import com.iversoft.test.persistence.DAO.UserRolesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

@Component
public class InitializeData implements ApplicationRunner {

    @Autowired
    UserRolesRepository userRolesRepository;

    @Autowired
    UserAddressesRepository userAddressesRepository;

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LogManager.getLogger(InitializeData.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("**************************************************");
        logger.info("*                                                *");
        logger.info("*   Application is started. Initializing DB...   *");
        logger.info("*                                                *");
        logger.info("**************************************************");

        createUserRoles();
        createUserAddresses();
        createUsers();
    }

    private void createUserRoles() {
        Stream.of(new UserRoles(1, "Admin"),
                new UserRoles(2, "Publisher"),
                new UserRoles(3, "Public User"))
                .forEachOrdered(element -> userRolesRepository.save(element));
    }

    private void createUserAddresses() {
        Stream.of(new UserAddresses(1, 1, "123 fake street", "Ontario", "Ottawa", "Canada", "123 w4t"),
                new UserAddresses(2, 2, "123 queen street", "Quebec", "Gatineau", "Canada", "123 tdf"),
                new UserAddresses(3, 3, "123 major road", "Ontariofdgdgdfg", "Ottawa", "Canada", "145 w4t"),
                new UserAddresses(4, 4, "123 blue street", "Ontario", "Ottawa", "Canada", "145 lpo"))
                .forEachOrdered(element -> userAddressesRepository.save(element));
    }

    private void createUsers() throws Exception {
        Stream.of(new User(1, 1, "I_Admin", "admin@test.com", strToDate("2017-05-20 12:42:53"), strToDate("2017-05-20 12:42:53")),
                new User(2, 2, "I_Publish", "publisher@test.com", strToDate("2017-05-20 13:05:53"), strToDate("2017-05-22 15:08:53")),
                new User(3, 3, "I_Use", "user@test.com", strToDate("2017-05-21 13:05:53"), strToDate("2017-05-21 13:05:53")),
                new User(4, 3, "I_Use_Too", "user2@test.com", strToDate("2017-05-22 14:05:53"), strToDate("2017-05-22 14:05:53")))
                .forEachOrdered(element -> userRepository.save(element));
    }

    private Date strToDate(String date) throws Exception {
        Date dateObject = null;
        dateObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        return dateObject;
    }
}