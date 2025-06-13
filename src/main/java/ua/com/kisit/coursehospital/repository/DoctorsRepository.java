package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Doctors;

import java.util.List;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {
    List<Doctors> findByLastName(String lastName);
    Doctors findByPatientsId(int patientsId);
}
