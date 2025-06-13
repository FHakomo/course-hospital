package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.BusinessLogic.PrescriptionList;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Prescriptions;
import ua.com.kisit.coursehospital.service.DoctorsService;
import ua.com.kisit.coursehospital.service.PatientsService;
import ua.com.kisit.coursehospital.service.PrescriptionsService;
import ua.com.kisit.coursehospital.service.StatusesService;

@Controller
public class PatientController {

    private final PatientsService patientsService;
    private final DoctorsService doctorsService;
    private final PrescriptionsService prescriptionsService;
    public PatientController(PatientsService patientsService, DoctorsService doctorsService, PrescriptionsService prescriptionsService, StatusesService statusesService) {
        this.patientsService = patientsService;
        this.doctorsService = doctorsService;
        this.prescriptionsService = prescriptionsService;

    }
    @GetMapping("/patients")
    public String patients(Model model) {
        model.addAttribute("patients", patientsService.getAllPatients());
        //model.addAttribute("doctor", doctorsService.findByPatientsId(patientsService.getAllPatients().get(0).getId()));
        model.addAttribute("prescriptions", prescriptionsService.getAllPrescriptions());
        return "patient";
    }

}
