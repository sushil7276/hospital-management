package com.hospital.repository;

import com.hospital.dto.BloodGroupCountResponseEntity;
import com.hospital.entity.BloodGroupType;
import com.hospital.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    List<Patient> findByNameContainingOrderByIdDesc(String name);

    // JPA Query
    @Query("SELECT p FROM Patient p WHERE p.bloodGroup=?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p from Patient p WHERE p.birthDate> :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup,count(p) from Patient p group by p.bloodGroup")
    List<Object[]> findByCountEachBloodGroupType();

    @Query("SELECT new com.hospital.dto.BloodGroupCountResponseEntity(p.bloodGroup,count (p))  FROM Patient p GROUP BY  p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    // Pagination
    @Query(value = "select * from  patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

    // If you update Query then specified ["@Modifying", "@Transactional"]
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name")  String name, @Param("id") Long id);


    // Pagination
}
