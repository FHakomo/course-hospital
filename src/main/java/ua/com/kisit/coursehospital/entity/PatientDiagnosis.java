package ua.com.kisit.coursehospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="patientDiagnosis")
public class PatientDiagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate diagnosisDate;
    @ManyToOne
    @JoinColumn(name="diagnosis_id")
    private Diagnosis diagnosis;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patients patient;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctors doctor;

}
