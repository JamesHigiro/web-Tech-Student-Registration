/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dao.GeneralDao;
import domain.Course;
import domain.Student;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean(name = "regModel")
@SessionScoped
public class RegistrationModel {
    
    private Student student = new Student();
    private List<Course> courses;
    private List<Course> selectedCourses = new ArrayList<>();
    private Set<Student> students;

    
    // getters and setters
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<Course> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    
    
    // business logic
    
    public String goToNext(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
            session.setAttribute("std", student);
            return "courseSelection";
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
    }
    
    public String save() {
        try {
            GeneralDao<Student> dao = new GeneralDao<>(Student.class);
             dao.create(student);
            FacesMessage msg = new FacesMessage("student saved successfully");
            FacesContext context = FacesContext.getCurrentInstance();
            return "feedback";
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage("student not saved");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "check";
        }
    }
   
    public List<Course> getAllCourses(){
     GeneralDao<Course> dao = new GeneralDao<>(Course.class);
     return dao.findAll();
    };
     public void addCourse(Course course) {
        selectedCourses.add(course);
        student.setCourses(selectedCourses);
    }

    public void removeCourse(Course course) {
        selectedCourses.remove(course);
    }
    
    
    public List<Course> getProductList() {
        return selectedCourses;
    }

    public Integer getCount() {
        return selectedCourses.size();
    }

    public Integer totalCredits() {
        int credits = 0;
        for (Course c : selectedCourses) {
            credits =credits + c.getCredits();
        }
        return credits;
    }

    public Integer getTotal() {
        int total = 0;
        for (Course p : selectedCourses) {
            total =total + p.getFees();
        }
        
        return total;
    }
    
    public boolean checkCourse(Course course){
       return selectedCourses.contains(course);
    }
}
