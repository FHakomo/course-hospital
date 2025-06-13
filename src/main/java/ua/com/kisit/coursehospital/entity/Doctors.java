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
@Table(name="doctors")

public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age;
    private String specialization;
    @OneToOne
    @MapsId
    @MapKey
    @JoinColumn(name="id")
    private Users user;
    @OneToMany(mappedBy="doctor")
    private List<Patients> patients;
    @OneToMany(mappedBy = "doctor")
    private List<PrescriptionsToPatients> prescriptionsToPatients;
    @OneToMany(mappedBy = "doctor")
    private List<PatientDiagnosis> patientDiagnosis;
}
