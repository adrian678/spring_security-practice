package ca.mcgill.quora.demo.services;

import ca.mcgill.quora.demo.data.UserRepository;
import ca.mcgill.quora.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("No such user found"));
        User myUser = user.get();

        System.out.println("myUser" + myUser.getUsername() + ", " + myUser.getPassword() + ", " + myUser.isActive() + ", " + myUser.isEnabled()); //TODO remove
        return myUser;
    }

    public List<User> getAllusers(){
        //TODO is it possible to return a list of type UserDetails?
        return userRepository.findAll();
    }

    public User loadUserById(long id){
        Optional<User> user = userRepository.findByUid(id);
        user.orElseThrow(() -> new UsernameNotFoundException("No such user found"));
        return user.get();
    }
    //TODO add in other methods to handle controller + business logic


}
