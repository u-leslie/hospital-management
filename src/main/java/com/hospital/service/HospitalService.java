package com.hospital.service;

import com.hospital.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HospitalService {
    private final SessionFactory sessionFactory;

    public HospitalService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void createOrUpdatePatient(Patient patient) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(patient);
        session.getTransaction().commit();
        session.close();
    }

    public Patient getPatient(Long id) {
        Session session = sessionFactory.openSession();
        Patient patient = session.get(Patient.class, id);
        session.close();
        return patient;
    }

    public void deletePatient(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Patient patient = session.get(Patient.class, id);
        if (patient != null) {
            session.remove(patient);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Patient> getAllPatients() {
        Session session = sessionFactory.openSession();
        List<Patient> patients = session.createQuery("from Patient", Patient.class).list();
        session.close();
        return patients;
    }
}
