package org.richcodes.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class UserFileDataAccessService  implements UserDao{
    @Override
    public List<User> getUsers() {
//        File file = new File("src/org/richcodes/users.csv");
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(
                "users.csv")).getPath());
        List<User> users = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String[] parts = scanner.nextLine().split(", ");
                UUID id = UUID.fromString(parts[0]);
                String name = parts[1];
                users.add(new User(id, name));
            }

        }catch (IOException e){
            throw  new RuntimeException(e);
        }

        return users;
    }

    public int countLine(){
        File file = new File("src/org/richcodes/users.csv");
        int lineCount = 0;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                scanner.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return  lineCount;
    }

    public User getUserById(UUID id){
        for (User user : getUsers()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        System.out.println("cannot find user");
        return null;
    }

    public User getUserByName(String name){
        for (var user : getUsers()){
            if(user.getName().equalsIgnoreCase(name)){
                System.out.println("found user: " + name);
                return user;
            }
        }
        System.out.println("user not found");
        return null;

    }

    @Override
    public Optional<User> getUserByUsername(String name) {
      for(var user: this.getUsers()){
          if(user.getName().equalsIgnoreCase(name)){
              return Optional.of(user);
          }
          return  Optional.empty();
      }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
