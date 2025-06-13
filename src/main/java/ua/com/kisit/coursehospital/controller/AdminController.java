package ua.com.kisit.coursehospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.entity.Prescriptions;
import ua.com.kisit.coursehospital.entity.Roles;
import ua.com.kisit.coursehospital.entity.Users;
import ua.com.kisit.coursehospital.service.DoctorsService;
import ua.com.kisit.coursehospital.service.RolesService;
import ua.com.kisit.coursehospital.service.UsersService;

@Controller
public class AdminController {

    private final UsersService usersService;
    private final RolesService rolesService;
    private final DoctorsService doctorsService;

    public AdminController(UsersService usersService, RolesService rolesService, DoctorsService doctorsService) {
        this.usersService = usersService;
        this.rolesService = rolesService;
        this.doctorsService = doctorsService;
    }

    @GetMapping("admin/users")
    public String users(Model model) {

        model.addAttribute("allusers", usersService.getAllUsers());
        model.addAttribute("roles", rolesService.getAllRoles());

        return "users";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        return "admin";
    }

    @PostMapping("/updateUser")
    public String getUpdateUser(@RequestParam(name="id") Users user,
                                @RequestParam(name="role_id") Roles role, @RequestParam(name="username") String username) {

        user.setUsername(username);
        user.setRole(role);


        usersService.updateUser(user);

        return "redirect:/admin/users";
    }
    @GetMapping("admin/roles")
    public String getPageRoles(Model model) {
        model.addAttribute("roles", rolesService.getAllRoles());
        return "roles";
    }
    @PostMapping("/updateRole")
    public String getUpdateRole(@RequestParam(name="id") Roles role,
                                @RequestParam(name="name") String name){
        role.setName(name);
        rolesService.updateRole(role);
        return "redirect:/admin/roles";
    }
    @GetMapping("admin/doctors")
    public String getPageDoctors(Model model) {
        model.addAttribute("doctors", doctorsService.getAllDoctors());
        return "doctor";
    }
    @PostMapping("/updateDoctor")
    public String getUpdateDoctor(@RequestParam(name="id")Doctors doctor, @RequestParam(name="age")int age, @RequestParam(name="email")String email,
                                  @RequestParam(name="firstName")String firstName, @RequestParam(name="lastName")String lastName, @RequestParam(name="phone")String phone,
                                  @RequestParam(name="spec")String specialization)
    {
        doctor.setAge(age);
        doctor.setEmail(email);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setPhone(phone);
        doctor.setSpecialization(specialization);
        doctorsService.updateDoctor(doctor);
        return "redirect:/admin/doctors";

    }
}
