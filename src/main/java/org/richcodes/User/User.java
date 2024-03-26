package org.richcodes.User;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int ids;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(nullable = true)
    private  UUID uuid;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public User(UUID uuid, String name) {
        this.name = name;
        this.uuid = uuid;
    }

    public UUID getId() {
        return uuid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "ids=" + ids +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ids == user.ids && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(uuid, user.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, name, email, uuid);
    }
}
