package ca.mcgill.quora.demo.controller;

import ca.mcgill.quora.demo.data.UserRepository;
import ca.mcgill.quora.demo.model.User;
import ca.mcgill.quora.demo.services.UserService;
import ca.mcgill.quora.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;        //TODO have UserService implement a service interface, and have the instance be of the type of the interface

//    @Autowired //TODO learn about UserValidator and whether it is worthwile to implement it
//    UserValidator userValidator;
    Class<UserController> controllerClass = UserController.class;

    @GetMapping(value={"/users/", "/users"})
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @GetMapping(value={"/users/{id}", "/users/{id}/"})
    public User findOne(@PathVariable long id){
       return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN') or #id == authentication.principal.id")
    @PutMapping(value = "/users/{id}")
    public User modifyUser(@PathVariable long id, Principal principal){
        User user = userService.loadUserById(id);
        //TODO perform argument validation + security authorization
        return null;
        //TODO return modified user
    }

////    TODO registration
//    @GetMapping(value = "/users/registration")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("userForm", new User());
//        return "registration";
//    }

//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
//
//        return "redirect:/welcome";
//    }

//    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
//    public User registerUser(@RequestBody UserDto user){  //TODO create a dto specifically for User which only lists public data?
//        return null;    //TODO fill in
//    }
}
