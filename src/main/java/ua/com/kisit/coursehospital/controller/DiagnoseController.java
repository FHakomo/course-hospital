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
import ua.com.kisit.coursehospital.BusinessLogic.Diagnose;
import ua.com.kisit.coursehospital.BusinessLogic.DiagnoseLogic;
import ua.com.kisit.coursehospital.BusinessLogic.ItemList;
import ua.com.kisit.coursehospital.BusinessLogic.PrescriptionList;
import ua.com.kisit.coursehospital.entity.*;
import ua.com.kisit.coursehospital.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class DiagnoseController {
    
    private final DiagnosisService diagnosisService;
    private final DoctorsService doctorsService;
    private final PatientsService patientsService;
    private final PatientDiagnosisService patientDiagnosisService;
    private final StatusesService statusesService;
    private final UsersService usersService;
    
    public DiagnoseController(DiagnosisService diagnosisService, DoctorsService doctorsService,
                              PatientsService patientsService, PatientDiagnosisService patientDiagnosisService, StatusesService statusesService, UsersService usersService) {
        this.diagnosisService = diagnosisService;
        this.doctorsService = doctorsService;
        this.patientsService = patientsService;
        this.patientDiagnosisService = patientDiagnosisService;
        this.statusesService = statusesService;
        this.usersService = usersService;

    }
    @GetMapping("/Diagnose")
    public String diagnose(Model model, HttpServletRequest request) {

        model.addAttribute("diagnoses", diagnosisService.getAllDiagnosis());
        model.addAttribute("doctors", doctorsService.getAllDoctors());
        model.addAttribute("patients", patientsService.getAllPatients());

        HttpSession session = request.getSession();
        DiagnoseLogic diagnoseLogic = (DiagnoseLogic) session.getAttribute("diagnostic");

        if (diagnoseLogic == null) {
            diagnoseLogic = new DiagnoseLogic();

        }




        model.addAttribute("diagnostic", diagnoseLogic);

        return "diagnose";
    }
    @PostMapping("/createDiagnose")
    public String createDiagnose(@RequestParam(name="patient_id") Patients patient, @RequestParam(name="diagnos_id") Diagnosis diagnosis, HttpServletRequest request) {
        HttpSession session = request.getSession();

        DiagnoseLogic diagnoseLogic = (DiagnoseLogic) session.getAttribute("diagnostic");
        if (diagnoseLogic == null) {
            diagnoseLogic = new DiagnoseLogic();
        }
        diagnoseLogic.DiagnosePatient(diagnosis, patient, LocalDate.now());

        session.setAttribute("diagnostic", diagnoseLogic);
        return "redirect:/Diagnose";
    }
    @PostMapping("/updateDiagnose")
    public String updateItemInList(@RequestParam(name="patient_id") Patients patient, @RequestParam(name="diagnos_id") Diagnosis diagnosis, HttpServletRequest request, @RequestParam(name="date") String date){
        HttpSession session = request.getSession();

        DiagnoseLogic diagnoseLogic = (DiagnoseLogic) session.getAttribute("diagnostic");
        if (diagnoseLogic == null) {
            diagnoseLogic = new DiagnoseLogic();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        diagnoseLogic.updateDiagnose(diagnosis, patient, LocalDate.parse(date, dtf));

        session.setAttribute("diagnostic", diagnoseLogic);
        return "redirect:/Diagnose";
    }
    @PostMapping("/diagnosePatient")
    public String getPageDiagnose(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");

        SecurityContext context = SecurityContextHolder.getContext();
        Users user = (Users) context.getAuthentication().getPrincipal();

        Users user1 = usersService.getUserByUsername(user.getUsername());

        DiagnoseLogic diagnoseLogic = (DiagnoseLogic) session.getAttribute("diagnostic");

        Doctors doctor = doctorsService.getDoctorById(user1.getId());





            PatientDiagnosis diagnose = new PatientDiagnosis();
            diagnose.setDoctor(doctor);
            diagnose.setDiagnosis(diagnoseLogic.getDiagnose().getDiagnosis());
            diagnose.setPatient(diagnoseLogic.getDiagnose().getPatient());
            diagnose.setDiagnosisDate(diagnoseLogic.getDiagnose().getDate());

            Patients patient = patientsService.getPatientById(diagnose.getPatient().getId());
            patient.setStatus(statusesService.getStatusesById(2));

            patientDiagnosisService.addPatientDiagnosis(diagnose);




            diagnoseLogic.deleteDiagnose();

            session.setAttribute("diagnostic", diagnoseLogic);

            return "redirect:/done";

    }
}
