package web.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Model.User;
import web.Service.UserService;
import web.Service.UserServiceImp;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/all_users";
    }

    @GetMapping("/new")
    public String showFormAddUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add_user";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user.getFirstName(), user.getLastName(), user.getEmail());
        return "redirect:/user";
    }

    @GetMapping("/show")
    public String showUserById(@RequestParam("id") int id, Model model) {
        User user = userService.showUserById(id);
        if (user == null) {
            return "redirect:/user";
        } else {
            model.addAttribute("user", user);
            return "user/show_user";
        }
    }

    @GetMapping("/show/edit")
    public String editUser(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.showUserById(id));
        return "user/edit_user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.updateUserById(id, user);
        return "redirect:/user";
    }

    @PostMapping("/show/delete")
    public String deleteUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.removeUserById(id);
        return "redirect:/user";
    }
}

