package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.PatientDiagnosis;

public interface PatientDiagnosisRepository extends JpaRepository<PatientDiagnosis, Integer> {
}
