package org.richcodes.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

//public class UserArrayDataAccessService {
public class UserArrayDataAccessService  implements  UserDao{
    private static final User[] users;

    static {

        users = new User[]{
                new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"), "James"),
                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"), "Jamila")
        };
    }




    public  User[] getAllUsers(){
        return users;
    }

public List<User> getUsers() {

    File file = new File("src/org/richcodes/users.csv");
    List<User> user = new ArrayList<>();

    try{
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            String[] parts = scanner.nextLine().split(", ");
            UUID id = UUID.fromString(parts[0]);
            String name = parts[1];
            user.add(new User(id,name));
        }

    }catch (IOException e){
        throw  new RuntimeException(e);
    }

    return user;
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

    @Override
    public Optional<User> getUserByUsername(String name) {
        for(var user: this.getUsers()){
            if(user.getName().equalsIgnoreCase(name)){
                return Optional.of(user);
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
