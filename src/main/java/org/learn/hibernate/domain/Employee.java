package org.learn.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4722390033665734759L;

	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
