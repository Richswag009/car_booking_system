package org.richcodes.User;

import java.beans.JavaBean;
import java.util.Optional;
import java.util.UUID;

@JavaBean
public class UserService {

    private final UserFileDataAccessService userDAO = new UserFileDataAccessService();
    private final UserArrayDataAccessService userDAO1 = new UserArrayDataAccessService();
    private final UserFakerDataAccessService userDAO2 = new UserFakerDataAccessService();



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


//   public User findUserByName(String name){
//        if (userDAO.getUserByName(name) == null){
//            System.out.println("user Not found");
//        }
//        return (userDAO.getUserByName(name));
//    }
    public Optional<User> findUserByName(String name) {
        Optional<User> userOptional = Optional.ofNullable(userDAO.getUserByName(name));
        userOptional.ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("User not found")
        );
        return userOptional;
    }

    public User findUserById(UUID id){
        if (id ==null){
            throw new IllegalArgumentException("name cannot be blank");
        }
        return userDAO.getUserById(id);
    }

    public void getFakerusers(){
       for (var users : userDAO2.getUsers()){
           System.out.println(users);
       }
//                .forEach(System.out.println());
    }

}
