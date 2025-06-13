package ua.com.kisit.coursehospital.BusinessLogic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Diagnosis;
import ua.com.kisit.coursehospital.entity.Prescriptions;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diagnose {

    private Diagnosis diagnosis;
    private Patients patient;
    private LocalDate date;


}
