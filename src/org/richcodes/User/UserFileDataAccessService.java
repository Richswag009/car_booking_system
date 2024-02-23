package org.richcodes.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService  implements UserDao{
    @Override
    public User[] getUsers() {
        int counts = countLine();
        File file = new File("src/org/richcodes/users.csv");
        User[] users1 = new User[counts];
        int index = 0;
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String[] parts = scanner.nextLine().split(", ");
                UUID id = UUID.fromString(parts[0]);
                String name = parts[1];
                users1[index] = new User(id, name);
                index++;
            }

        }catch (IOException e){
            throw  new RuntimeException(e);
        }

        return users1;
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
    public String toString() {
        return super.toString();
    }
}
