package ua.com.kisit.coursehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisit.coursehospital.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<Users> findAllByUsername(String username);

    List<Users> findAllByUsernameAndPassword(String username, String password);

    Users findByUsername(String username);


}
