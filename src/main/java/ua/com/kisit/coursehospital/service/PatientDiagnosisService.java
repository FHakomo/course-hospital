package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.PatientDiagnosis;
import ua.com.kisit.coursehospital.repository.PatientDiagnosisRepository;

import java.util.List;

@Service
public class PatientDiagnosisService {

    private final PatientDiagnosisRepository patientDiagnosisRepository;

    public PatientDiagnosisService(PatientDiagnosisRepository patientDiagnosisRepository) {
        this.patientDiagnosisRepository = patientDiagnosisRepository;
    }
    public List<PatientDiagnosis> getAllPatientDiagnosis() {
        return patientDiagnosisRepository.findAll();
    }
    public PatientDiagnosis getPatientDiagnosisById(int id) {
        return patientDiagnosisRepository.findById(id).orElse(null);
    }
    public PatientDiagnosis addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
        return patientDiagnosisRepository.save(patientDiagnosis);
    }
    public PatientDiagnosis updatePatientDiagnosis(PatientDiagnosis patientDiagnosis) {
        return patientDiagnosisRepository.save(patientDiagnosis);
    }
    public void deletePatientDiagnosisById(int id) {
        patientDiagnosisRepository.deleteById(id);
    }
    public void deletePatientDiagnosis(PatientDiagnosis patientDiagnosis) {
        patientDiagnosisRepository.delete(patientDiagnosis);
    }
    public void DeleteAllPatientDiagnosis() {
        patientDiagnosisRepository.deleteAll();
    }
}
