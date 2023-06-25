package ru.kata.spring.boot_security.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.Service.UserService;
import ru.kata.spring.boot_security.demo.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/AllUsers")
    public ModelAndView getAllUsers(){
        List<User> users = userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/AllUsers");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }
    @GetMapping(value = "/update/{id}")
    public ModelAndView updatePage(@PathVariable long id) {
        User user = userService.getByIdUser(id);
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/сhangeUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @PatchMapping(value = "/update")
    public String updateUser(@ModelAttribute @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "admin/сhangeUser";

        userService.upDateUser(user);
        return "redirect:/admin/AllUsers";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/admin/AllUsers";
    }
}
