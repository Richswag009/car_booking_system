package org.richcodes.User;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserFakerDataAccessService implements UserDao{
//    File file = new File(getClass().getClassLoader().getResource('users.csv').getPath());


    @Override
    public List<User> getUsers() {
        List<User> users= new ArrayList<>();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String id = faker.idNumber().ssnValid();
        String ids = faker.idNumber().ssnValid();
        users.add(new User(name,ids));
        return users;

    }

    @Override
    public Optional<User> getUserByUsername(String name) {
        return Optional.empty();
    }
}
