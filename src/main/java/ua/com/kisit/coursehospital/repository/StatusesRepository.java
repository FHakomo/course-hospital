package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Statuses;

public interface StatusesRepository extends JpaRepository<Statuses, Integer> {
}
