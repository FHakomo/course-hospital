package ua.com.kisit.coursehospital.BusinessLogic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Prescriptions;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemList {
    private Prescriptions prescriptions;
    private Patients patient;
    private String description;
    private LocalDate dateOfPrescription;
}
