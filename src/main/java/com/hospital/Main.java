package com.hospital;
import com.hospital.model.Patient;
import com.hospital.service.HospitalService;

public class Main {
    public static void main(String[] args) {
        HospitalService service = new HospitalService();

        // Create a new patient
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAge(30);
        service.createPatient(patient);

        // Read a patient
        Patient retrievedPatient = service.getPatient(patient.getId());
        System.out.println("Retrieved Patient: " + retrievedPatient.getName());

        // Update a patient
        retrievedPatient.setAge(31);
        service.updatePatient(retrievedPatient);

        // Delete a patient
        service.deletePatient(retrievedPatient.getId());

        // List all patients
        service.getAllPatients().forEach(p -> System.out.println(p.getName()));
    }
}
