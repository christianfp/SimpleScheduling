/*
 * SimpleSchedulingResource.java
 */
package com.scheduling.simple.ws;

import com.scheduling.simple.model.MyClass;
import com.scheduling.simple.model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleSchedulingResource {
    
    private Map<Integer, Student> studentsMap;
    private Map<String, MyClass> classMap;

    public SimpleSchedulingResource() {
        studentsMap = new HashMap<Integer, Student>();
        classMap = new HashMap<String, MyClass>();
    }
    
    public Student createStudent(int studentId, String lastName, String firstName) {
        // TODO validate input data
        Student student = new Student(studentId, lastName, firstName);
        studentsMap.put(studentId, student);
        
        return student;
    }
    public Student editStudent(int studentId, String lastName, String firstName) {
        // TODO validate input data
        if(retrieveStudent(studentId)!= null)
        {
            return createStudent(studentId,lastName,firstName);
        }
        else 
        {
            return null;
        }
    }
    public void deleteStudent(int studentId)
    {
        studentsMap.remove(studentId);
    }
    public Student retrieveStudent(int studentId) {
        return studentsMap.get(studentId);
    }
    
    public MyClass createClass (String code, String title, String description)
    {
        MyClass clase = new MyClass (code, title, description);
        classMap.put(code, clase);
        return clase;
    }
    public MyClass editClass(String code, String title, String description) {
        // TODO validate input data
        if(retrieveClass(code)!= null)
        {
            return createClass(code,title,description);
        }
        else 
        {
            return null;
        }
    }
    public List<Student> allStudents()
    {
        for (Map.Entry<Integer, Student> entry : studentsMap.entrySet()) 
        {
            System.out.println("Id=" + entry.getKey() + ", Student: " + entry.getValue().getFirstName()+ " " + entry.getValue().getLastName());
        }
        return new ArrayList(studentsMap.values());
    }
    public void studentToClass(String code, Integer studentId)
    {
        if(retrieveClass(code)!= null && retrieveStudent(studentId)!= null)
        {
            MyClass cl;
            cl = new MyClass();
            cl = classMap.get(code);
            cl.llenarLista(studentId,studentsMap.get(studentId));
            classMap.put(code, cl);
        }
    }
    
    public void deleteClass(String code)
    {
        classMap.remove(code);
    }
    public MyClass retrieveClass (String code)
    {
        return classMap.get(code);
    }

    
    public void allClasses()
    {
        for (Map.Entry<String, MyClass> entry : classMap.entrySet()) 
        {
            System.out.println("code=" + entry.getKey() + ", title: " + entry.getValue().getTitle() + " Description: " + entry.getValue().getDescription());
        }
    }
    
}
