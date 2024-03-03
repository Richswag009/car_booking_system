package org.richcodes.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getUsers();

    Optional<User> getUserByUsername(String name);
}