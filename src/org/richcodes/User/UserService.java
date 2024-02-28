package org.richcodes.User;

import java.beans.JavaBean;
import java.util.Optional;
import java.util.UUID;
@JavaBean
public class UserService {

    private final UserFileDataAccessService userDAO = new UserFileDataAccessService();
    private final UserArrayDataAccessService userDAO1 = new UserArrayDataAccessService();


//    public  UserService(UserFileDataAccessService userDAO){
//        this.userDAO =userDAO;
//    }

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
        userDAO.getUsers().forEach(System.out::println);
    }
    public Optional<User> getUsersByName(String name){
       return userDAO.getUserByUsername(name);
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
