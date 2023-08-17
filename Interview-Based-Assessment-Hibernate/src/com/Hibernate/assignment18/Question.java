package com.Hibernate.assignment18;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Hibernate.Model.EmployeeModel;
import com.Hibernate.Utill.HibernateUtil;

public class Question {

	public static void main(String[] args) {
        try ( Session session =HibernateUtil.getSession()) {

            Transaction transaction = session.beginTransaction();
            if (transaction != null) {
            	Query<EmployeeModel> query = session.createQuery("from EmployeeModel", EmployeeModel.class);
            	List<EmployeeModel> employees =query.getResultList();
            	
            	for (EmployeeModel employee : employees) {
            		System.out.println("ID: " + employee.getId() +
            				", Name: " + employee.getName() +
            				", Salary: " + employee.getSalary());
            	}
			}

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
