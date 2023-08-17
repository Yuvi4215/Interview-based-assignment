package com.Hibernate.assignment20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Hibernate.Model.EmployeeModel;
import com.Hibernate.Utill.HibernateUtil;

public class Question {

	public static void main(String[] args) {
		EmployeeModel employeeUpdate = new EmployeeModel();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try (Session session = HibernateUtil.getSession()) {
			System.out.println("Enter the Employee Id :: ");
			String id = reader.readLine();
			employeeUpdate.setId(Integer.parseInt(id));

			employeeUpdate = session.get(EmployeeModel.class, employeeUpdate.getId());
			if (employeeUpdate != null) {
				System.out.println("Retrieved Employee:");
				System.out.println("Employee old Name : " + employeeUpdate.getName());
				System.out.println("Enter new Name :: ");
				String name = reader.readLine();

				System.out.println("Employee old Salary : " + employeeUpdate.getSalary());
				System.out.println("Enter new Salary :: ");
				String salary = reader.readLine();

				if (name != null) {
					employeeUpdate.setName(name);
				}
				if (salary != null) {
					employeeUpdate.setSalary(Double.parseDouble(salary));
				}

			} else {
				System.out.println("Employee not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSession()) {
			Transaction transaction = session.beginTransaction();

			if (transaction != null) {
				session.merge(employeeUpdate);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Session session = HibernateUtil.getSession()) {
			EmployeeModel employeeModel = session.get(EmployeeModel.class, employeeUpdate.getId());

			if (employeeModel != null) {
				System.out.println("ID: " + employeeModel.getId() + ", Name: " + employeeModel.getName() + ", Salary: "
						+ employeeModel.getSalary());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
