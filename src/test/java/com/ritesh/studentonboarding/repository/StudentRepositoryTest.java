package com.ritesh.studentonboarding.repository;

import com.ritesh.studentonboarding.entity.LocalGuardian;
import com.ritesh.studentonboarding.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("RKW")
                .lastName("VasuQ")
                .emailId("vasuram031@ccm.org")
                //.localGuardianEmail("test001@cc2.org")
                //.localGuardianName("tester baby")
                //.localGuardianphone("1111111111")
                .build();
        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){
        LocalGuardian localGuardian = LocalGuardian.builder()
                .name("LG1")
                .email("lg112@gmai.com")
                .phone("22222222222222")
                .build();
        Student student = Student.builder()
                .firstName("Ritesh")
                .lastName("Rai")
                .emailId("we120U@test.com")
                .localGuardian(localGuardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student>  students = studentRepository.findAll();
        System.out.println("Total count of students are + " + students.size());
        System.out.println("Students are + " + students);
    }

    @Test
    public void showAllStudentsByFirstName(){
        List<Student> students = studentRepository
                .findByFirstName("Ritesh");
        System.out.println("Students " + students);
    }

    @Test
    public void showAllStudentsByFirstNameContaining(){
        List<Student> students = studentRepository
                .findByFirstNameContaining("RK");
        System.out.println("Students " + students);
    }

    @Test
    public void showAllStudentsByLocalGuardianName() {
       List<Student> students = studentRepository
       .findByLocalGuardianName("LG1");
        System.out.println("Students : " + students);
    }

    @Test
    public void showAllNotNullLastName(){
        List<Student> students = studentRepository
                .findByLastNameNotNull();
        System.out.println("Students : " + students);
    }

    @Test
    public void showStudentWithFirstAndLastName() {
        Student student = studentRepository
                .findByFirstNameAndLastName("Ritesh","Rai");
        System.out.println("Student is : " + student);
    }

    @Test
    public void showStudentByEmailId() {
        Student student = studentRepository
                .getStudentByEmailId("rmk20@ccm.org");
        System.out.println("Student is : " + student);
    }

    @Test
    public void showStudentLastNameByEmailId() {
        String student = studentRepository
                .getStudentLastNameByEmailId("rmk20@ccm.org");
        System.out.println("Student is : " + student);
    }

    @Test
    public void showStudentByEmailIdUsingNativeMethod() {
        Student student = studentRepository
                .getStudentByEmailIdNative("rmk20@ccm.org");
        System.out.println("Student is : " + student);
    }
}