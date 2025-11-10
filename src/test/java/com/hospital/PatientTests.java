package com.hospital;

import com.hospital.dto.BloodGroupCountResponseEntity;
import com.hospital.entity.BloodGroupType;
import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

//        Patient p1 = new Patient();
//        patientRepository.save(p1);
    }

    @Test
    public void testPatientTransactional() {
//        Patient p1 = patientService.getPatientById(1L);
//        patientRepository.findById(1L).orElseThrow(()-> new EntityNotFoundException("Patient not found with id: 1"));

//        Patient patient = patientRepository.findByName("Diya Patel");
//        List<Patient> patients = patientRepository.findByNameContainingOrderByIdDesc("Di");
//        List<Patient> patients = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        LocalDate date = LocalDate.of(1993, 3, 14);
//        List<Patient> patients = patientRepository.findByBornAfterDate(date);
//
//        for (Patient patient : patients) {
//            System.out.println(patient);
//        }

//        List<Object[]> bloodGroupList = patientRepository.findByCountEachBloodGroupType();
//        for (Object[] objects : bloodGroupList) {
//            System.out.println(objects[0] + " " + objects[1]);
//        }
//
        List<BloodGroupCountResponseEntity> bloodGroups = patientRepository.countEachBloodGroupType();
        for (BloodGroupCountResponseEntity bloodGroup : bloodGroups) {
            System.out.println(bloodGroup);
        }

        // Pagination and Sort
//        Page<Patient> patientPage = patientRepository.findAllPatient(PageRequest.of(0,2, Sort.by("name")));
//        for (Patient patient : patientPage) {
//            System.out.println(patient);
//        }

    }

}
