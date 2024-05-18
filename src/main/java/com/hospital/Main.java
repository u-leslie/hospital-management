package com.hospital;

import com.hospital.model.Appointment;
import com.hospital.model.MedicalRecord;
import com.hospital.model.Patient;
import com.hospital.service.HospitalService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HospitalService hospitalService = new HospitalService();

        // Create a patient with medical records and appointments
        Patient patient = new Patient();
        patient.setAge(30);

        MedicalRecord record1 = new MedicalRecord();
        record1.setDetails("Record 1");
        record1.setPatient(patient);

        MedicalRecord record2 = new MedicalRecord();
        record2.setDetails("Record 2");
        record2.setPatient(patient);

        Appointment appointment1 = new Appointment();
        appointment1.setDate("2024-05-20");
        appointment1.setPatient(patient);

        Appointment appointment2 = new Appointment();
        appointment2.setDate("2024-05-21");
        appointment2.setPatient(patient);

        patient.setMedicalRecords(Arrays.asList(record1, record2));
        patient.setAppointments(Arrays.asList(appointment1, appointment2));

        // Save patient
        hospitalService.createOrUpdatePatient(patient);

        // Fetch patient
        Patient fetchedPatient = hospitalService.getPatient(patient.getId());
        System.out.println("Fetched Patient Age: " + fetchedPatient.getAge());
        System.out.println("Fetched Medical Records: " + fetchedPatient.getMedicalRecords().size());
        System.out.println("Fetched Appointments: " + fetchedPatient.getAppointments().size());

        // Fetch all patients
        for (Patient p : hospitalService.getAllPatients()) {
            System.out.println("Patient Age: " + p.getAge());
        }

        // Delete patient
        hospitalService.deletePatient(patient.getId());
    }
}
