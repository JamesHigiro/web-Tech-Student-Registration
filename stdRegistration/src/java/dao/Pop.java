/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Course;

/**
 *
 * @author diddy
 */
public class Pop {

    public static void main(String[] args) {

        GeneralDao<Course> dao = new GeneralDao<>(Course.class);
        Course course1 = new Course("CO1", "Advanced Software Modeling", 3, 45000);
        Course course2 = new Course("CO2", "Web Techonlogies", 4, 60000);
        Course course3 = new Course("CO3", "Software testing techniques", 3, 45000);
        Course course4 = new Course("CO4", "Data Structures", 5, 75000);
        Course course5 = new Course("CO5", "Introduction to Bible", 2, 30000);
        Course course6 = new Course("CO6", "Introduction to Accounting", 3, 45000);
        Course course7 = new Course("CO7", "Mobile Computing", 4, 60000);
        Course course8 = new Course("CO8", "Digital Computer Fundamentals", 4, 60000);
        dao.create(course1);
        dao.create(course2);
        dao.create(course3);
        dao.create(course4);
        dao.create(course5);
        dao.create(course6);
        dao.create(course7);
        dao.create(course8);
        System.out.println("Course saved");

    }
}
