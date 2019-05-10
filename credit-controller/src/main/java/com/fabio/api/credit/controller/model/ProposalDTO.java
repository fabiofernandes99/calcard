package com.fabio.api.credit.controller.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ProposalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;
	@NotNull
	private String cpf;
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
	private String resultProposal;
	private String limitProposal;

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

	public String getResultProposal() {
		return resultProposal;
	}

	public void setResultProposal(String resultProposal) {
		this.resultProposal = resultProposal;
	}

	public String getLimitProposal() {
		return limitProposal;
	}

	public void setLimitProposal(String limitProposal) {
		this.limitProposal = limitProposal;
	}

	@Override
	public String toString() {
		return "Proposal [name=" + name + ", cpf=" + cpf + ", age=" + age
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus
				+ ", state=" + state + ", numberOfDependents="
				+ numberOfDependents + ", income=" + income + "]";
	}
}
