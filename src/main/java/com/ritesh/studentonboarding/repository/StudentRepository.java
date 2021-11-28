package com.ritesh.studentonboarding.repository;

import com.ritesh.studentonboarding.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByLocalGuardianName(String name);
    Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL queries to fetch the data
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String emailId);

    // JPQL queries to fetch the data
    @Query("select s.lastName from Student s where s.emailId = ?1")
    String getStudentLastNameByEmailId(String emailId);

    // JPQL queries to fetch the data
    @Query(
            value = "SELECT * FROM students s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);
}
