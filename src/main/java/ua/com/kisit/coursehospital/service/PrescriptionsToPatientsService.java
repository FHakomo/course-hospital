package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.PrescriptionsToPatients;
import ua.com.kisit.coursehospital.repository.PrescriptionsToPatientsRepository;

import java.util.List;

@Service
public class PrescriptionsToPatientsService {

    private final PrescriptionsToPatientsRepository prescriptionsToPatientsRepository;

    public PrescriptionsToPatientsService(PrescriptionsToPatientsRepository prescriptionsToPatientsRepository) {
        this.prescriptionsToPatientsRepository = prescriptionsToPatientsRepository;
    }
    public List<PrescriptionsToPatients> GetAllPrescriptionsToPatients() {
        return prescriptionsToPatientsRepository.findAll();
    }
    public PrescriptionsToPatients GetPrescriptionsToPatientsById(int id) {
        return prescriptionsToPatientsRepository.findById(id).orElse(null);
    }
    public List<PrescriptionsToPatients> GetAllPrescriptionsToPatientsByPatientId(int patient_id) {
        return prescriptionsToPatientsRepository.findByPatientId(patient_id);
    }
    public PrescriptionsToPatients addPrescriptionsToPatients(PrescriptionsToPatients prescriptionsToPatients) {
        return prescriptionsToPatientsRepository.save(prescriptionsToPatients);
    }
    public PrescriptionsToPatients updatePrescriptionsToPatients(PrescriptionsToPatients prescriptionsToPatients) {
        return prescriptionsToPatientsRepository.save(prescriptionsToPatients);
    }
    public void deletePrescriptionsToPatients(PrescriptionsToPatients prescriptionsToPatients) {
        prescriptionsToPatientsRepository.delete(prescriptionsToPatients);
    }
    public void deletePrescriptionsToPatientsById(int id) {
        prescriptionsToPatientsRepository.deleteById(id);
    }
    public void deleteAllPrescriptionsToPatients() {
        prescriptionsToPatientsRepository.deleteAll();
    }
}
