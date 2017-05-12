/*
 * SimpleSchedulingWS.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.MyClass;
import com.scheduling.simple.model.Student;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SimpleSchedulingWS {
    
    private final SimpleSchedulingResource resource = new SimpleSchedulingResource();
  
    /**
     * Creates a new student.
     * @param studentId Integer
     * @param lastName String
     * @param firstName String
     * @return 
     */
    public Student createStudent(@WebParam(name = "studentId") int studentId, 
            @WebParam(name = "lastName") String lastName, 
            @WebParam(name = "firstName") String firstName) {
        return resource.createStudent(studentId, lastName, firstName);
    }
    public Student editStudent(@WebParam(name = "studentId") int studentId, 
            @WebParam(name = "lastName") String lastName, 
            @WebParam(name = "firstName") String firstName) {
        return resource.editStudent(studentId, lastName, firstName);
    }
    public void deleteStudent(@WebParam(name = "studentId") int studentId) {
        resource.deleteStudent(studentId);
    }
    public List<Student> allStudents()
    {
        return resource.allStudents();
    }
    public void allClasses()
    {
        resource.allClasses();
    }
    
    public void studentToClass(@WebParam(name = "code") String code,
            @WebParam(name = "studentId") int studentId)
    {
        resource.studentToClass(code, studentId);
    }
    
    public MyClass createClass(@WebParam(name = "code") String code, 
            @WebParam(name = "title") String title,
            @WebParam(name = "description") String description){
        return resource.createClass(code, title, description);
    }
    public MyClass editClass(@WebParam(name = "code") String code, 
            @WebParam(name = "title") String title,
            @WebParam(name = "description") String description){
        return resource.createClass(code, title, description);
    }
    
    public void deleteClass(@WebParam(name = "code") String code) {
        resource.deleteClass(code);  
    }
    /**
     * Return a student based on its studentId.
     * @param studentId Integer
     * @return 
     */
    public Student retrieveStudent(@WebParam(name = "studentId") int studentId) {
        return resource.retrieveStudent(studentId);
    }
    public MyClass retrieveClass(@WebParam(name = "code") String code) {
        return resource.retrieveClass(code);  
    }
    
    // add more methods to createClass, registerStudentToClass
}
