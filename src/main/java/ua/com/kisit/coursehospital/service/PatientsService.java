package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.repository.PatientsRepository;

import java.util.List;
@Service
public class PatientsService {

    private final PatientsRepository patientsRepository;
    public PatientsService(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    public List<Patients> getAllPatients() {
        return patientsRepository.findAll();
    }
    public Patients getPatientById(int id) {
        return patientsRepository.findById(id).orElse(null);
    }
    public Patients addPatient(Patients patient) {
        return patientsRepository.save(patient);
    }
    public Patients updatePatient(Patients patient) {
        return patientsRepository.save(patient);
    }
    public void deletePatientById(int id) {
        patientsRepository.deleteById(id);
    }
    public void deletePatient(Patients patient) {
        patientsRepository.delete(patient);
    }
    public void DeleteAllPatients() {
        patientsRepository.deleteAll();
    }
}
