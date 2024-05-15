package com.hospital;

import com.hospital.model.Patient;
import com.hospital.service.HospitalService;

public class Main {
    public static void main(String[] args) {
        HospitalService hospitalService = new HospitalService();

        // Create a new patient
        Patient newPatient = new Patient();
        newPatient.setName("John Doe");
        newPatient.setAge(30);
        hospitalService.createOrUpdatePatient(newPatient);

        // Retrieve the patient
        Patient retrievedPatient = hospitalService.getPatient(newPatient.getId());
        System.out.println("Retrieved Patient: " + retrievedPatient.getName() + ", Age: " + retrievedPatient.getAge());
    }
}
