package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;
import ua.com.kisit.coursehospital.entity.Prescriptions;

import java.util.List;

public interface PrescriptionsRepository extends JpaRepository<Prescriptions, Integer> {

    List<Prescriptions> findAllPrescriptionsByCategory(PrescriptionCategories category);

}
