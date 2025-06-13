package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;
import ua.com.kisit.coursehospital.entity.Prescriptions;
import ua.com.kisit.coursehospital.repository.PrescriptionsRepository;

import java.util.List;
@Service
public class PrescriptionsService {

    private final PrescriptionsRepository prescriptionsRepository;
    public PrescriptionsService(PrescriptionsRepository prescriptionsRepository) {
        this.prescriptionsRepository = prescriptionsRepository;
    }
    public List<Prescriptions> getAllPrescriptions() {
        return prescriptionsRepository.findAll();
    }
    public Prescriptions getPrescriptionById(int id) {
        return prescriptionsRepository.findById(id).orElse(null);
    }
    public Prescriptions addPrescription(Prescriptions prescription) {
        return prescriptionsRepository.save(prescription);
    }
    public Prescriptions updatePrescription(Prescriptions prescription) {
        return prescriptionsRepository.save(prescription);
    }
    public void deletePrescriptionById(int id) {
        prescriptionsRepository.deleteById(id);
    }
    public void deletePrescription(Prescriptions prescription) {
        prescriptionsRepository.delete(prescription);
    }
    public void deleteAllPrescriptions() {
        prescriptionsRepository.deleteAll();
    }

    public List<Prescriptions> findAllPrescriptionsByCategory(PrescriptionCategories prescriptionCategory) {
        return prescriptionsRepository.findAllPrescriptionsByCategory(prescriptionCategory);
    }

}
