package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Patients;

public interface PatientsRepository extends JpaRepository<Patients, Integer> {
}
