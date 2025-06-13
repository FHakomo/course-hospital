package ua.com.kisit.coursehospital.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.Statuses;
import ua.com.kisit.coursehospital.entity.Users;
import ua.com.kisit.coursehospital.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService implements UserDetailsService

{

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    public Users getUserById(int id) {
        return usersRepository.findById(id).orElse(null);
    }
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }
    public void deleteUserById(int id) {
        usersRepository.deleteById(id);
    }
    public void deleteUser(Users user) {
        usersRepository.delete(user);
    }
    public void deleteAllUsers() {
        usersRepository.deleteAll();
    }
    public boolean userExistsByUsername(String username) {
        return usersRepository.findAllByUsername(username).isEmpty() ? false : true;
    }
    public boolean userExistsByUsernameAndPassword(String username, String password) {
        return usersRepository.findAllByUsernameAndPassword(username, password).isEmpty() ? false : true;
    }
    public Users getUserByUsername(String username) {
        return usersRepository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }



        return user;
    }
}
