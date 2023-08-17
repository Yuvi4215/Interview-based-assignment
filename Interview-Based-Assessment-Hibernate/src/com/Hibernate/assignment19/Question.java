package com.Hibernate.assignment19;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Hibernate.Model.EmployeeModel;
import com.Hibernate.Utill.HibernateUtil;


public class Question {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSession()) {

            Transaction transaction = session.beginTransaction();
            EmployeeModel newEmployee = new EmployeeModel();

            if (transaction != null) {
            	// Insert new employee
            	newEmployee.setName("John Doe");
            	newEmployee.setSalary(50000.0);
            	session.save(newEmployee);
			}

     
            
            if (transaction != null) {
            	EmployeeModel retrievedEmployee = session.get(EmployeeModel.class, newEmployee.getId());
            	if (retrievedEmployee != null) {
            		System.out.println("Retrieved Employee:");
            		System.out.println("ID: " + retrievedEmployee.getId() +
            				", Name: " + retrievedEmployee.getName() +
            				", Salary: " + retrievedEmployee.getSalary());
            	} else {
            		System.out.println("Employee not found.");
            	}
			}

            transaction.commit();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
