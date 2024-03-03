package org.richcodes.User;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String name;
    private UUID id;
    private String ids;


    public User(UUID uuid, String name) {
        this.name = name;
        this.id = uuid;

    }

    public User(String name, String ids) {
        this.name = name;
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
