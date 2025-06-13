package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.coursehospital.BusinessLogic.PrescriptionList;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.entity.Roles;
import ua.com.kisit.coursehospital.entity.Users;
import ua.com.kisit.coursehospital.service.DoctorsService;
import ua.com.kisit.coursehospital.service.RolesService;
import ua.com.kisit.coursehospital.service.UsersService;

@Controller
public class UserController {

    private final UsersService usersService;
    private final DoctorsService doctorsService;
    private final RolesService rolesService;

    public UserController(UsersService usersService, DoctorsService doctorsService, RolesService rolesService) {
        this.usersService = usersService;
        this.doctorsService = doctorsService;
        this.rolesService = rolesService;
    }

    @GetMapping("/login")
    public String getPageLogin() {

        return "login";
    }
    @GetMapping("/registration")
    public String getPageRegistration(Model model ,@RequestParam(name="err", defaultValue = " ") String err) {
        model.addAttribute("users", new Users());
        model.addAttribute("doctors", new Doctors());
        model.addAttribute("err", err);
        model.addAttribute("roles", rolesService.getAllRoles());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid Users users,
                               BindingResult bindingResult1,
                               @Valid Doctors doctors, BindingResult bindingResult2,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult1.hasErrors()) {
            redirectAttributes.addFlashAttribute("err","");
            return "registration";
        }
        if (bindingResult2.hasErrors()) {
            redirectAttributes.addFlashAttribute("err","");
            return "registration";
        }

        if(usersService.userExistsByUsername(users.getUsername())) {
            redirectAttributes.addFlashAttribute("err", "Даний username вже є в системі");
            return "/registration";
        }

        users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));

        users.setRole(rolesService.getRoleById(1));

        Users newUser = usersService.addUser(users);



        doctors.setUser(newUser);
        doctorsService.addDoctor(doctors);



        return "redirect:/login";
    }
//    @PostMapping("/login")
//    public String authUserInHospital(@RequestParam(name="username") String username, @RequestParam(name="password") String password, HttpServletRequest request) {
//        if(!usersService.userExistsByUsernameAndPassword(username, password)) {
//            return "redirect:/registration";
//        }
//
//        HttpSession session = request.getSession();
//        //session.setAttribute("users", usersService.loadUserByUsername(username));
//
//        PrescriptionList list = (PrescriptionList) session.getAttribute("prescriptionList");
//
//        if(list != null) { return "redirect:/prescribetopatients"; }
//
//
//
//
//        return "redirect:/home";
//    }
    @GetMapping("/403")
    public String getPage403() {
        return "err403";
    }
}
