package com.capgemini.Exam.Exam1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class IDCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idl;
	private String cardNumber;
	private String issueDate;
	
	@OneToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	public IDCard() {
		
	}

	public IDCard(Long idl, String cardNumber, String issueDate, Employee employee) {
		
		this.idl = idl;
		this.cardNumber = cardNumber;
		this.issueDate = issueDate;
		this.employee = employee;
	}

	public Long getIdl() {
		return idl;
	}

	public void setIdl(Long idl) {
		this.idl = idl;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	

}
