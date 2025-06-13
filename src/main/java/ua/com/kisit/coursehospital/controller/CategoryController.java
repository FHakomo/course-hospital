package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;
import ua.com.kisit.coursehospital.service.PrescriptionCategoriesService;
import ua.com.kisit.coursehospital.service.PrescriptionsService;

@Controller
public class CategoryController {

    private final PrescriptionCategoriesService prescriptionCategoriesService;
    private final PrescriptionsService prescriptionsService;

    public CategoryController(PrescriptionCategoriesService prescriptionCategoriesService,
                              PrescriptionsService prescriptionsService) {
        this.prescriptionCategoriesService = prescriptionCategoriesService;
        this.prescriptionsService = prescriptionsService;
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable(name="id") PrescriptionCategories prescriptionCategory, Model model) {

        model.addAttribute("prescriptionCategory", prescriptionCategory.getName());
        model.addAttribute("prescriptions", prescriptionsService.findAllPrescriptionsByCategory(prescriptionCategory));
        return "category";
    }


}
