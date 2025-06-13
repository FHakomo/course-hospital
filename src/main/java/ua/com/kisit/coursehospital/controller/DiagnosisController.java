package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kisit.coursehospital.service.DiagnosisService;
import ua.com.kisit.coursehospital.service.PatientsService;

@Controller
public class DiagnosisController {

    private final DiagnosisService diagnosisService;
    private final PatientsService patientsService;
    public DiagnosisController(DiagnosisService diagnosisService, PatientsService patientsService) {
        this.diagnosisService = diagnosisService;
        this.patientsService = patientsService;
    }
    @GetMapping("/diagnoses")
    public String diagnoses(Model model, HttpServletRequest request) {
        model.addAttribute("diagnoses", diagnosisService.getAllDiagnosis());
        model.addAttribute("patients", patientsService.getAllPatients());
        return "diagnosis";
    }
}
