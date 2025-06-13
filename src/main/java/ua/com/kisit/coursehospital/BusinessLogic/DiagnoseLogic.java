package ua.com.kisit.coursehospital.BusinessLogic;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisit.coursehospital.entity.Diagnosis;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Prescriptions;
import ua.com.kisit.coursehospital.service.DiagnosisService;
import ua.com.kisit.coursehospital.service.PatientsService;

import java.time.LocalDate;

@Getter
@Setter
public class DiagnoseLogic {


    Diagnose diagnose;

    public DiagnoseLogic() {
        Diagnose diagnose = new Diagnose();
    }


    public synchronized void DiagnosePatient(Diagnosis diagnosis, Patients patient, LocalDate date) {

        diagnose = new Diagnose(diagnosis, patient, date);



    }
    public synchronized  void updateDiagnose(Diagnosis diagnosis, Patients patient, LocalDate date) {
        diagnose.setPatient(patient);
        diagnose.setDiagnosis(diagnosis);
        diagnose.setDate(date);
    }
    public synchronized  void deleteDiagnose() {
        diagnose = null;
    }

}
