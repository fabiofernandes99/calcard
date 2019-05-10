package com.fabio.api.credit.proposal.engine.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fabio.api.credit.proposal.engine.model.ProposalDTO;

@Entity
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String cpf;
	@NotNull
	private String name;
	@NotNull
	private Integer age;
	@NotNull
	private String gender;
	@NotNull
	private String maritalStatus;
	@NotNull
	private String state;
	@NotNull
	private Integer numberOfDependents;
	@NotNull
	private Long income;

	public CustomerEntity() {
	}
	
	public CustomerEntity(final ProposalDTO proposalDTO) {
		this.name = proposalDTO.getName();
		this.cpf = proposalDTO.getCpf();
		this.age = proposalDTO.getAge();
		this.gender = proposalDTO.getGender();
		this.maritalStatus = proposalDTO.getMaritalStatus();
		this.state = proposalDTO.getState();
		this.numberOfDependents = proposalDTO.getNumberOfDependents();
		this.income = proposalDTO.getIncome();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getNumberOfDependents() {
		return numberOfDependents;
	}

	public void setNumberOfDependents(Integer numberOfDependents) {
		this.numberOfDependents = numberOfDependents;
	}

	public Long getIncome() {
		return income;
	}

	public void setIncome(Long income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Customer [cpf=" + cpf + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus
				+ ", state=" + state + ", numberOfDependents="
				+ numberOfDependents + ", income=" + income + "]";
	}

}
