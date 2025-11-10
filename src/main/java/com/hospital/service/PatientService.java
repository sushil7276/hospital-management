package com.hospital.service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    @Transactional
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2 = patientRepository.findById(id).orElseThrow();

//        LocalDate date = LocalDate.of(1996,05,24);
//        p1.setName("Devika Phase");
//        p1.setBirthDate(date);
//        p1.setGender("Female");
//        p1.setEmail("d@gmail.com");

        System.out.println(p1==p2);

        return p1;
    }

}
