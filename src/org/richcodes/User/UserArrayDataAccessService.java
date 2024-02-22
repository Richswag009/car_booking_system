package org.richcodes.User;

import java.util.UUID;

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

    public User getUserById(UUID id){
        for (var user : users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        System.out.println("user not found");
        return null;
    }

    public User getUserByName(String name){
        for (var user : users){
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

    @Override
    public User[] getUsers() {
        return new User[0];
    }
}
