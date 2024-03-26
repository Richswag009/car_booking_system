package org.richcodes.User;

import org.richcodes.exceptions.UserNotFoundException;

import java.beans.JavaBean;
import java.util.Optional;
import java.util.UUID;

@JavaBean
public class UserService {

    private final UserFileDataAccessService userDAO = new UserFileDataAccessService();
    private final UserArrayDataAccessService userDAO1 = new UserArrayDataAccessService();
//    private final UserFakerDataAccessService userDAO2 = new UserFakerDataAccessService();
    private final UserRepo userRepo = new UserRepo();



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

    public void allUsers(){
        userRepo.getUsers().forEach(System.out::println);
    }

    public Optional<User> findUserByName(String name) {
        Optional<User> userOptional = Optional.ofNullable(userDAO.getUserByName(name));
        userOptional.ifPresentOrElse(
                user -> System.out.println("User found: " + user),
                () -> System.out.println("User not found")
        );
        return userOptional;
    }

    public User findUserByEmail(String email) {
        Optional<User> userOptional = userRepo.getUserByEmail(email);
        return userOptional.orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }

    public User findUserById(UUID id){
        if (id ==null){
            throw new IllegalArgumentException("name cannot be blank");
        }
        return userDAO.getUserById(id);
    }


    public  void addUser(String user, String email){
        if(userRepo.emailExist(email)){
            System.out.println("email is already taken");
            return;
        }
        userRepo.addUser(user,email);
    }

}
