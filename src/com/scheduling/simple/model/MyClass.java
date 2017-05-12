/*
 * Class.java
 */
package com.scheduling.simple.model;

import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Class")
public class MyClass {
    
    @XmlElement(name = "code")
    private String code;
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "description")
    private String description;
    
    private Map<Integer, Student> students;
    /**
     * @return the code
     */
    public MyClass(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public MyClass() {
        
    }
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void llenarLista(Integer studentId, Student st)
    {
        students.put(studentId, st);
    }
    public void mostrarLista()
    {
        for (Map.Entry<Integer, Student> entry : students.entrySet()) 
        {
            System.out.println("Id=" + entry.getKey() + ", Student: " + entry.getValue().getFirstName()+ " " + entry.getValue().getLastName());
        }
    }
}
