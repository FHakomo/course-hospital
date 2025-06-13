package ua.com.kisit.coursehospital.BusinessLogic;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisit.coursehospital.entity.Doctors;
import ua.com.kisit.coursehospital.entity.Patients;
import ua.com.kisit.coursehospital.entity.Prescriptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter

public class PrescriptionList {

    List<ItemList> list;
    private int sumItInList;

    public PrescriptionList() {
        list = new ArrayList<ItemList>();
        sumItInList=0;
    }
    public synchronized void AddItemToList(Prescriptions prescription, Patients patient, LocalDate date, String description) {
        boolean logic = true;

        for (ItemList itemList : list) {
            if (itemList.getPrescriptions().getId() == prescription.getId() && itemList.getPatient().getId() == patient.getId()) {
                logic = false;
                itemList.setPrescriptions(prescription);
            }
        }
        if (logic) {
            list.add(new ItemList(prescription,patient,description, date));
        }
    }
    public synchronized  void updateItemInList(Prescriptions prescription, Patients patient, LocalDate date, String description) {
        if(date != null || description != null) {
            for (ItemList itemList : list) {
                if (itemList.getPrescriptions().getId() == prescription.getId() && itemList.getPatient().getId() == patient.getId()) {
                    itemList.setDescription(description); itemList.setDateOfPrescription(date);
                }
            }
        }
    }
    public  synchronized void deleteItemFromList(Prescriptions prescription,  Patients patient) {
        for (ItemList itemList : list) {
            if (itemList.getPrescriptions().getId() == prescription.getId() && itemList.getPatient().getId() == patient.getId()) {
                list.remove(itemList);
                break;
            }
        }
    }
    public  synchronized void deleteAllItemsFromList() {
        list.clear();
        sumItInList=0;
    }
    public  synchronized int getSumItInList() {
        return list.size();
    }
}
