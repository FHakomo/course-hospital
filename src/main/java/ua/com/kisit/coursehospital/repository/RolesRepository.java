package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
