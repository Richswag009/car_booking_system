package org.richcodes.User;

import java.util.UUID;

public class UserService {

    private final UserFileDataAccessService userDAO = new UserFileDataAccessService();
    private final UserArrayDataAccessService userDAO1 = new UserArrayDataAccessService();

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
        for(var user: userDAO.getUsers()){
            System.out.println(user);
        };
    }

    public User findUserByName(String name){
        if (name.isBlank()){
            throw new IllegalArgumentException("name cannot be blank");
        }
        return userDAO.getUserByName(name);
    }

    public User findUserById(UUID id){
        if (id ==null){
            throw new IllegalArgumentException("name cannot be blank");
        }
        return userDAO.getUserById(id);
    }

}
