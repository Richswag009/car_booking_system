package org.richcodes.User;

import java.util.UUID;

public class User {
    private String name;
    private UUID id;


    public User(UUID uuid, String name) {
        this.name = name;
        this.id = uuid;

    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId(UUID id) {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
