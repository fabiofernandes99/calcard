package com.fabio.api.credit.proposal.engine.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fabio.api.credit.proposal.engine.entity.CustomerEntity;
import com.fabio.api.credit.proposal.engine.entity.ProposalEntity;

public class ProposalDTO implements Serializable {

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
	@NotNull
	private String resultProposal;
	@NotNull
	private String limitProposal;

	public ProposalDTO() {
	}

	public ProposalDTO(CustomerEntity customerEntity,
			ProposalEntity proposalEntity) {
		this.name = customerEntity.getName();
		this.cpf = customerEntity.getCpf();
		this.age = customerEntity.getAge();
		this.gender = customerEntity.getGender();
		this.maritalStatus = customerEntity.getMaritalStatus();
		this.state = customerEntity.getState();
		this.numberOfDependents = customerEntity.getNumberOfDependents();
		this.income = customerEntity.getIncome();
		this.resultProposal = proposalEntity.getResultProposal();
		this.limitProposal = proposalEntity.getLimitProposal();
	}

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

}
