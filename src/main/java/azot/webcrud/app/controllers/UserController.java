package azot.webcrud.app.controllers;

import azot.webcrud.app.models.User;
import azot.webcrud.app.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return "users/index";
    }

    @GetMapping("/showAddingForm")
    public String addUser(Model model) {
        User newUser = new User();
        model.addAttribute("addingUser", newUser);
        return "users/user-add-form";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("addingUser") User newUser) {
        userService.saveUser(newUser);
        return "redirect:/users";
    }


    @GetMapping("/{id}/showFormForEdit")
    public String showFormForEdit(@PathVariable("id") long id, Model model) {
        User userToEdit = userService.getUserById(id);
        model.addAttribute("editUser", userToEdit);
        return "users/user-form";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("editUser") User user, @PathVariable("id") long id) {
        System.out.println(user.getName());
        userService.update(id, user);
        return "redirect:/users";
    }

    @GetMapping("{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}


