package ua.com.kisit.coursehospital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int weight;
    private String medicalHistory;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctors doctor;
    @OneToMany(mappedBy = "patient")
    private List<PatientDiagnosis> patientDiagnosis;
    @OneToMany(mappedBy = "patient")
    private List<PrescriptionsToPatients> prescriptionsToPatients;
    @ManyToOne
    @JoinColumn(name="status_id")
    private Statuses status;

}
