package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.repository.DoctorsRepository;

import java.util.List;

@Service
public class DoctorsService {

    private final DoctorsRepository doctorsRepository;

    public DoctorsService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }
    public List<Doctors> getAllDoctors() {
        return doctorsRepository.findAll();
    }
    public Doctors getDoctorById(int id) {
        return doctorsRepository.findById(id).get();
    }
    public Doctors addDoctor(Doctors doctors) {
        return doctorsRepository.save(doctors);
    }
    public Doctors updateDoctor(Doctors doctors) {
        return doctorsRepository.save(doctors);
    }
    public void deleteDoctorById(int id) {
        doctorsRepository.deleteById(id);
    }
    public void DeleteDoctor(Doctors doctors) {
        doctorsRepository.delete(doctors);
    }
    public List<Doctors> getDoctorsByLastName(String lastName) {
        return doctorsRepository.findByLastName(lastName);
    }
    public Doctors findByPatientsId(int patientsId) {
        return doctorsRepository.findByPatientsId(patientsId);
    }
}
