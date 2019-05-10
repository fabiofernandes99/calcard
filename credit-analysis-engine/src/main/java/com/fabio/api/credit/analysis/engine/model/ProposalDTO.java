package com.fabio.api.credit.analysis.engine.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ProposalDTO implements Serializable, Cloneable {

	public void setResultProposal(String resultProposal) {
		this.resultProposal = resultProposal;
	}

	public void setLimitProposal(String limitProposal) {
		this.limitProposal = limitProposal;
	}

	private static final long serialVersionUID = 1L;

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

	public String getCpf() {
		return cpf;
	}

	public Integer getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public String getState() {
		return state;
	}

	public Integer getNumberOfDependents() {
		return numberOfDependents;
	}

	public Long getIncome() {
		return income;
	}

	public String getResultProposal() {
		return resultProposal;
	}

	public String getLimitProposal() {
		return limitProposal;
	}

	@Override
	public String toString() {
		return "CreditControllerProposal [name=" + name + ", cpf=" + cpf
				+ ", age=" + age + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", state=" + state + ", numberOfDependents="
				+ numberOfDependents + ", income=" + income + "]";
	}

	public ProposalDTO clone() {
		return this.clone();
	}
}
