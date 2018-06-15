package org.learn.hibernate.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.learn.hibernate.dao.EmployeeDao;
import org.learn.hibernate.datasource.DataSource;
import org.learn.hibernate.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public void insert(Employee employee) {
		Session session = DataSource.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(employee);
		transaction.commit();
		session.close();
		
	}

	public void update(Employee employee) {
		Session session = DataSource.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		session.close(); 
	}

	public Employee findByEmployeeId(Integer id) {
		Session session = DataSource.getSessionFactory().openSession();
		TypedQuery<Employee> query = session.createQuery("From Employee where id=:id", Employee.class);
		query.setParameter("id", id);
		Employee employee = query.getSingleResult();
		return employee;
		
		// below does not need to be converted to list unlike findAll()
		/*Employee employee = session.find(Employee.class, id);
		return employee;*/
	}

	public List<Employee> findAll() {
		Session session = DataSource.getSessionFactory().openSession();
		// Employee is not same as EMPLOYEE or employee, it should match with class name
		TypedQuery<Employee> query = session.createQuery("From Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		session.close();
		return employees;
		
		/*List<Employee> employees = session.createCriteria(Employee.class).list();
		return employees;*/
	}

	public void delete(Integer id) {
		Session session = DataSource.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = session.load(Employee.class,id);
		session.delete(employee);
		transaction.commit();
		session.close();
		
	}

}
