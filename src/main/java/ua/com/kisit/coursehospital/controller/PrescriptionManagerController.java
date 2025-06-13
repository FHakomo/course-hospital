package ua.com.kisit.coursehospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;
import ua.com.kisit.coursehospital.entity.Prescriptions;
import ua.com.kisit.coursehospital.service.PrescriptionCategoriesService;
import ua.com.kisit.coursehospital.service.PrescriptionsService;
@Controller
public class PrescriptionManagerController {

    private final PrescriptionsService prescriptionsService;
    private final PrescriptionCategoriesService prescriptionCategoriesService;

    public PrescriptionManagerController(PrescriptionsService prescriptionsService, PrescriptionCategoriesService prescriptionCategoriesService) {
        this.prescriptionsService = prescriptionsService;
        this.prescriptionCategoriesService = prescriptionCategoriesService;
    }
    @GetMapping("/prescriptions")
    public String patients(Model model) {
        model.addAttribute("prescriptions", prescriptionsService.getAllPrescriptions());
        model.addAttribute("prescriptionCategories", prescriptionCategoriesService.getAllPrescriptionCategories());
        return "prescription";
    }

    public void savePrescription(Prescriptions prescription) {
        prescriptionsService.addPrescription(prescription);
    }

    @PostMapping("/CreateNewPrescription")
    public String createNewPrescription(@RequestParam(name="name") String name,@RequestParam(name="description") String description,
                                        @RequestParam(name="image") String image, @RequestParam(name="category_id") int category_id) {

        Prescriptions prescription = new Prescriptions();
        prescription.setName(name);
        prescription.setDescription(description);
        prescription.setImage(image);
        prescription.setCategory(prescriptionCategoriesService.getPrescriptionCategoriesById(category_id));

        prescriptionsService.addPrescription(prescription);

        return "/prescription";
    }
    @PostMapping("/UpdatePrescription")
    public String createNewPrescription(@RequestParam(name="id") int id,
                                        @RequestParam(name="name") String name,@RequestParam(name="description") String description,
                                        @RequestParam(name="image") String image, @RequestParam(name="category_id") int category_id) {

        Prescriptions prescription = prescriptionsService.getPrescriptionById(id);
        prescription.setName(name);
        prescription.setDescription(description);
        prescription.setImage(image);
        prescription.setCategory(prescriptionCategoriesService.getPrescriptionCategoriesById(category_id));


        prescriptionsService.updatePrescription(prescription);

        return "redirect:/prescriptions";
    }

    @PostMapping("/DeletePrescription")
    public String deletePrescription(@RequestParam(name="id") int id) {

        prescriptionsService.deletePrescriptionById(id);

        return "redirect:/prescriptions";
    }

}
