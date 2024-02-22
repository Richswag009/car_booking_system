package org.richcodes.User;

import java.util.UUID;

public class UserDao {

    private  static  User[] users;
    private static  int nextAvailableSlot = 0;
    static {
        users= new User[5];
    }

    public  void addUser(User user){
        if(nextAvailableSlot + 1 >=5){
            throw new IllegalArgumentException("cannot add car");
        }
        users[nextAvailableSlot] = user;
        ++nextAvailableSlot;
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

}
