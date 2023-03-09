package org.main.resource.myinterface;

import org.main.resource.model.Student;

import java.util.List;


public interface StudentDAO {

    public int insertStudent(Student student);
    public int deleteStudent(Integer order);
    public int updateStudent(Integer order , Student student);
    public Student getStudentById(Integer order);
    public List<Student> getAllStudent();

}
