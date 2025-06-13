package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.Diagnosis;
import ua.com.kisit.coursehospital.repository.DiagnosisRepository;

import java.util.List;

@Service
public class DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;
    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisRepository.findAll();
    }
    public Diagnosis getDiagnosisById(int id) {
        return diagnosisRepository.findById(id).orElse(null);
    }
    public Diagnosis addDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }
    public Diagnosis updateDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }
    public void deleteDiagnosisById(int id) {
        diagnosisRepository.deleteById(id);
    }
    public void deleteDiagnosis(Diagnosis diagnosis) {
        diagnosisRepository.delete(diagnosis);
    }
    public void deleteAllDiagnosis() {
        diagnosisRepository.deleteAll();
    }
    public Diagnosis getDiagnosisByName(String name) {
        return diagnosisRepository.findByName(name);
    }
}
