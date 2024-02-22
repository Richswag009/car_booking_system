package org.richcodes.User;

import java.util.UUID;

public class UserService {

    private UserArrayDataAccessService userDAO;

    public  UserService(){
        this.userDAO= new UserArrayDataAccessService();
    }

//    public boolean addUser(User user){
//        if(user.getName().isBlank()){
//            throw  new IllegalArgumentException("Name Cannot be null or Empty");
//        }
//        userDAO.addUser(user);
//        System.out.println("successfully added User " + user.getName()
//                + " with id:" + user.getId());
//        return true;
//    }

    public void getUsers(){
        for(var user: userDAO.getAllUsers()){
            System.out.println(user);
        };
    }

    public User findUserByName(String name){
        if (name.isBlank()){
            throw new IllegalArgumentException("name cannott be blank");
        }
        return userDAO.getUserByName(name);
    }   public User findUserById(UUID id){
        if (id ==null){
            throw new IllegalArgumentException("name cannott be blank");
        }
        return userDAO.getUserById(id);
    }


    @Override
    public String toString() {
        return "UserService{" +
                "userDAO=" + userDAO +
                '}';
    }
}
