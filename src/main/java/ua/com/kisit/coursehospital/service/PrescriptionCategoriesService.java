package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;
import ua.com.kisit.coursehospital.repository.PrescriptionCategoriesRepository;

import java.util.List;
@Service
public class PrescriptionCategoriesService {

    private final PrescriptionCategoriesRepository prescriptionCategoriesRepository;
    public PrescriptionCategoriesService(PrescriptionCategoriesRepository prescriptionCategoriesRepository ) {
        this.prescriptionCategoriesRepository = prescriptionCategoriesRepository;
    }
    public List<PrescriptionCategories> getAllPrescriptionCategories() {
        return prescriptionCategoriesRepository.findAll();
    }
    public PrescriptionCategories getPrescriptionCategoriesById(int id) {
        return prescriptionCategoriesRepository.findById(id).orElse(null);
    }
    public PrescriptionCategories addPrescriptionCategories(PrescriptionCategories prescriptionCategories) {
        return prescriptionCategoriesRepository.save(prescriptionCategories);
    }

    public PrescriptionCategories updatePrescriptionCategories(PrescriptionCategories prescriptionCategories) {
        return prescriptionCategoriesRepository.save(prescriptionCategories);
    }
    public void deletePrescriptionCategoriesById(int id) {
        prescriptionCategoriesRepository.deleteById(id);
    }
    public void deletePrescriptionCategories(PrescriptionCategories prescriptionCategories) {
        prescriptionCategoriesRepository.delete(prescriptionCategories);
    }
    public void deleteAllPrescriptionCategories() {
        prescriptionCategoriesRepository.deleteAll();
    }
}
