package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.PrescriptionsToPatients;

import java.util.List;

public interface PrescriptionsToPatientsRepository extends JpaRepository<PrescriptionsToPatients, Integer> {
    List<PrescriptionsToPatients> findByPatientId(int patient_id);
}
