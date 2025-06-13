package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;
import ua.com.kisit.coursehospital.service.PrescriptionCategoriesService;
import ua.com.kisit.coursehospital.service.PrescriptionsService;

@Controller
public class HomeController {

    private final PrescriptionsService prescriptionsService;
    private final PrescriptionCategoriesService prescriptionCategoriesService;

    public HomeController(PrescriptionsService prescriptionsService, PrescriptionCategoriesService prescriptionCategoriesService) {
        this.prescriptionsService = prescriptionsService;
        this.prescriptionCategoriesService = prescriptionCategoriesService;
    }


//    @GetMapping("/")
//    public String TestController(Model model) {
//
//        List<Prescriptions> prescriptions = prescriptionsService.getAllPrescriptions();
//
//        model.addAttribute("prescriptions", prescriptions);
//        model.addAttribute("message", "Hello World!");
//        return "Hello";
//    }
    @GetMapping({"/","/home"})
    public String HomePage(Model model) {
        model.addAttribute("prescriptionCategories", prescriptionCategoriesService.getAllPrescriptionCategories());
        return "home";
    }
    @PostMapping("/createNewCategory")
    public String createNewCategory(HttpServletRequest request, @RequestParam(name="name") String name, @RequestParam(name="description") String description, @RequestParam(name="image") String image)
    {
        HttpSession session = request.getSession();
        PrescriptionCategories prescriptionCategory = new PrescriptionCategories();
        prescriptionCategory.setName(name);
        prescriptionCategory.setDescription(description);
        prescriptionCategory.setImages(image);
        prescriptionCategoriesService.addPrescriptionCategories(prescriptionCategory);
        return "redirect:/";
    }
}
