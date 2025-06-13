package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.BusinessLogic.ItemList;
import ua.com.kisit.coursehospital.BusinessLogic.PrescriptionList;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.PrescriptionsToPatients;
import ua.com.kisit.coursehospital.entity.Users;
import ua.com.kisit.coursehospital.service.DoctorsService;
import ua.com.kisit.coursehospital.service.PrescriptionsToPatientsService;
import ua.com.kisit.coursehospital.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrescribeController {

    private final PrescriptionsToPatientsService prescriptionsToPatientsService;
    private final DoctorsService doctorsService;
    private final UsersService usersService;

    public PrescribeController(PrescriptionsToPatientsService prescriptionsToPatientsService, DoctorsService doctorsService, UsersService usersService) {
        this.prescriptionsToPatientsService = prescriptionsToPatientsService;
        this.doctorsService = doctorsService;
        this.usersService = usersService;
    }

    @GetMapping("/prescribetopatients")
    public String getPrescription(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        SecurityContext context = SecurityContextHolder.getContext();
        Users user = (Users) context.getAuthentication().getPrincipal();

        PrescriptionList list = (PrescriptionList) session.getAttribute("prescriptionList");
        if (list == null) {
            return "redirect:/patients";
        }
        model.addAttribute("prescriptionList", list.getList());
        model.addAttribute("AllElements", list.getSumItInList());

        Users user1 = usersService.getUserByUsername(user.getUsername());

        model.addAttribute("doctor", doctorsService.getDoctorById(user1.getId()));
        return "prescribe";
    }
    @PostMapping("/prescribe")
    public String getPagePrescribe(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        SecurityContext context = SecurityContextHolder.getContext();
        Users user = (Users) context.getAuthentication().getPrincipal();

        PrescriptionList list = (PrescriptionList) session.getAttribute("prescriptionList");

        Users user1 = usersService.getUserByUsername(user.getUsername());

        Doctors doctor = doctorsService.getDoctorById(user1.getId());

        for (ItemList el: list.getList())
        {

            PrescriptionsToPatients prescriptionsToPatients = new PrescriptionsToPatients();
            prescriptionsToPatients.setDoctor(doctor);
            prescriptionsToPatients.setPatient(el.getPatient());
            prescriptionsToPatients.setPrescription(el.getPrescriptions());
            prescriptionsToPatients.setDatePrescriped(el.getDateOfPrescription());
            prescriptionsToPatients.setResult(el.getDescription());

            prescriptionsToPatientsService.addPrescriptionsToPatients(prescriptionsToPatients);

        }

        list.deleteAllItemsFromList();
        list.setSumItInList(0);
        session.setAttribute("prescriptionList", list.getList());

        return "redirect:/done";

    }
    @GetMapping("/done")
    public String getPageDone(Model model, HttpServletRequest request) {

        return "done";
    }
}
