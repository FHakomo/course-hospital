package ua.com.kisit.coursehospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Statuses;
import ua.com.kisit.coursehospital.service.DiagnosisService;
import ua.com.kisit.coursehospital.service.PatientsService;
import ua.com.kisit.coursehospital.service.PrescriptionCategoriesService;
import ua.com.kisit.coursehospital.service.StatusesService;

@Controller
public class ManagerController {

private final PrescriptionCategoriesService prescriptionCategoriesService;
private final DiagnosisService diagnosisService;
private final PatientsService patientsService;
private final StatusesService statusesService;

    public ManagerController( PrescriptionCategoriesService prescriptionCategoriesService, DiagnosisService diagnosisService, PatientsService patientsService, StatusesService statusesService) {
        this.prescriptionCategoriesService = prescriptionCategoriesService;
        this.diagnosisService = diagnosisService;
        this.patientsService = patientsService;
        this.statusesService = statusesService;
    }

    @GetMapping("/manager")
    public String getHomeManager(Model model) {
        model.addAttribute("prescriptionCategories", prescriptionCategoriesService.getAllPrescriptionCategories());
        return "manager";
    }
    @GetMapping("/manager/patients")
    public String patients(Model model) {
        model.addAttribute("patients", patientsService.getAllPatients());
        model.addAttribute("statuses", statusesService.getAllStatuses());
        return "redactpatient";
    }

    @PostMapping("/updatePatient")
    public String updatePatient(@RequestParam(name="id") Patients patient, @RequestParam(name="age")int age, @RequestParam(name="weight")int weight,
                                @RequestParam(name="firstName")String firstName, @RequestParam(name="lastName")String lastName, @RequestParam(name="hist")String history,
                                @RequestParam(name="status_id") Statuses statuses)
    {
        patient.setAge(age);
        patient.setWeight(weight);
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setMedicalHistory(history);
        patient.setStatus(statuses);
        patientsService.updatePatient(patient);
        return "redirect:/manager/patients";

    }
}
