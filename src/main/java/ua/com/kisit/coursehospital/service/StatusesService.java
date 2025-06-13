package ua.com.kisit.coursehospital.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.coursehospital.entity.Statuses;
import ua.com.kisit.coursehospital.repository.StatusesRepository;

import java.util.List;

@Service
public class StatusesService {
    private final StatusesRepository statusesRepository;
    public StatusesService(StatusesRepository statusesRepository) {
        this.statusesRepository = statusesRepository;
    }
    public List<Statuses> getAllStatuses() {
        return statusesRepository.findAll();
    }
    public Statuses getStatusesById(int id) {
        return statusesRepository.findById(id).orElse(null);
    }
    public Statuses addStatuses(Statuses statuses) {
        return statusesRepository.save(statuses);
    }
    public Statuses updateStatuses(Statuses statuses) {
        return statusesRepository.save(statuses);
    }
    public void deleteStatusesById(int id) {
        statusesRepository.deleteById(id);
    }
    public void deleteStatuses(Statuses statuses) {
        statusesRepository.delete(statuses);
    }
    public void deleteAllStatuses() {
        statusesRepository.deleteAll();
    }
}
