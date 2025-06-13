package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.Roles;
import ua.com.kisit.coursehospital.repository.RolesRepository;

import java.util.List;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }
    public Roles getRoleById(int id) {
        return rolesRepository.findById(id).orElse(null);
    }
    public Roles addRole(Roles role) {
        return rolesRepository.save(role);
    }
    public Roles updateRole(Roles role) {
        return rolesRepository.save(role);
    }
    public void deleteRoleById(int id) {
        rolesRepository.deleteById(id);
    }
    public void deleteRole(Roles role) {
        rolesRepository.delete(role);
    }
    public void deleteAllRoles() {
        rolesRepository.deleteAll();
    }
}
