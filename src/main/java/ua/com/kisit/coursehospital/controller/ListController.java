package ua.com.kisit.coursehospital.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisit.coursehospital.BusinessLogic.ItemList;
import ua.com.kisit.coursehospital.BusinessLogic.PrescriptionList;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Prescriptions;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Controller
public class ListController {
    @GetMapping("/Prescribe")
    public String Prescribe(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        PrescriptionList prescriptionList = (PrescriptionList) session.getAttribute("prescriptionList");

        if (prescriptionList == null) {
            prescriptionList = new PrescriptionList();

        }

        model.addAttribute("prescriptionList", prescriptionList.getList());


        return "prescriptionList";
    }
    @PostMapping("/addToList")
    public String addNewItemToList(@RequestParam(name="patient_id") Patients patient, @RequestParam(name="prescription_id") Prescriptions prescription, HttpServletRequest request) {
        HttpSession session = request.getSession();

        PrescriptionList prescriptionList = (PrescriptionList) session.getAttribute("prescriptionList");
        if (prescriptionList == null) {
            prescriptionList = new PrescriptionList();
        }
        prescriptionList.AddItemToList(prescription, patient, LocalDate.now(), "Поки не задано");

        session.setAttribute("prescriptionList", prescriptionList);
        return "redirect:/Prescribe";
    }
    @PostMapping("/updateItemInList")
    public String updateItemInList(@RequestParam(name="patient_id") Patients patient, @RequestParam(name="prescription_id") Prescriptions prescription,@RequestParam(name="description") String description, @RequestParam(name="date") String date, HttpServletRequest request){
        HttpSession session = request.getSession();

        PrescriptionList prescriptionList = (PrescriptionList) session.getAttribute("prescriptionList");
        if (prescriptionList == null) {
            prescriptionList = new PrescriptionList();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        prescriptionList.updateItemInList(prescription, patient, LocalDate.parse(date, dtf), description);

        session.setAttribute("prescriptionList", prescriptionList);
        return "redirect:/Prescribe";
    }
    @PostMapping("/deleteItemFromList")
    public String deleteItemFromList(@RequestParam(name="patient_id") Patients patient, @RequestParam(name="prescription_id") Prescriptions prescription, HttpServletRequest request) {
        HttpSession session = request.getSession();

        PrescriptionList prescriptionList = (PrescriptionList) session.getAttribute("prescriptionList");
        if (prescriptionList == null) {
            prescriptionList = new PrescriptionList();
        }
        prescriptionList.deleteItemFromList(prescription, patient);
        session.setAttribute("prescriptionList", prescriptionList);
        return "redirect:/Prescribe";
    }
    @PostMapping("/deleteAllItems")
    public String deleteAllItems(HttpServletRequest request) {
        HttpSession session = request.getSession();
        PrescriptionList list = (PrescriptionList) session.getAttribute("prescriptionList");
        if (list == null) {
            list = new PrescriptionList();
        }
        list.deleteAllItemsFromList();
        session.setAttribute("prescriptionList", list);
        return "redirect:/Prescribe";
    }

}
