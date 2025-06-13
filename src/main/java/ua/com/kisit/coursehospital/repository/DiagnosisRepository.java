package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

    Diagnosis findByName(String name);
}
