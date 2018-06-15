package org.learn.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.learn.hibernate.dao.EmployeeDao;
import org.learn.hibernate.dao.impl.EmployeeDaoImpl;
import org.learn.hibernate.datasource.DataSource;
import org.learn.hibernate.domain.Employee;

public class HibernateApplication {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDaoImpl();
		// EntityManager entityManager = (EntityManager) session.getDelegate();

		/*
		 * List<Employee> employees = dao.findAll();
		 * 
		 * for (Employee e : employees) { System.out.println(e); }
		 */

		//System.out.println(dao.findByEmployeeId(1005));
		Employee employee = new Employee("John Silva");
		//dao.insert(employee);
		employee = new Employee("Will Smith");
		//dao.insert(employee);
		dao.findAll().forEach(e -> System.out.println(e));
		//dao.delete(1);
		

		DataSource.closeSessionFactory();

	}

}
