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
@Table(name="prescriptions")
public class Prescriptions
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String image;
    @ManyToOne
    @JoinColumn(name="category_id")
    private PrescriptionCategories category;
    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionsToPatients> prescriptionsToPatients;
}
