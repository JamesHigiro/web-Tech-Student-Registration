/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.GeneralDao;
import util.DbUtil;

/**
 *
 * @author james
 */
public class Main {
 
    public static void main(String[] args) {
        DbUtil.getSessionFactory().openSession();
        Course c1 =new Course("C01", "Advanced Software Modelling", 3, 45000);
        Course c2 =new Course("C02", "Web Technology", 4, 60000);
        Course c3 =new Course("C03", "Data structure and algorithm", 3, 75000);
        Course c4 =new Course("C04", "Software testing techniques", 3, 45000);
        Course c5=new Course("C05", "introduction to bible", 2, 30000);
        Course c6 =new Course("C06", "Introduction to accounting", 3, 45000);
        Course c7 =new Course("C07", "Mobile computing", 4, 60000);
        Course c8 =new Course("C08", "Digital computer fundamentals", 4, 60000);
        
          GeneralDao<Course> cDao = new GeneralDao<Course>(Course.class);
        cDao.create(c1);
        cDao.create(c2);
        cDao.create(c3);
        cDao.create(c4);
        cDao.create(c5);
        cDao.create(c6);
        cDao.create(c7);
        cDao.create(c8);
    }
}
