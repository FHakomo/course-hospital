package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.PrescriptionCategories;

public interface PrescriptionCategoriesRepository extends JpaRepository<PrescriptionCategories, Integer> {
}
