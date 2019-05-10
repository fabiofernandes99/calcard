package com.fabio.api.credit.proposal.engine.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fabio.api.credit.proposal.engine.model.ProposalDTO;

@Entity
public class ProposalEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seqIdProposal;
	@NotNull
	private String resultProposal;
	@NotNull
	private String limitProposal;

	@OneToOne(targetEntity = CustomerEntity.class)
	@JoinColumn(name = "cpf")
	@NotNull
	private CustomerEntity customer;

	public ProposalEntity() {
	}

	public ProposalEntity(final ProposalDTO proposalDTO) {
		this.limitProposal = proposalDTO.getLimitProposal();
		this.resultProposal = proposalDTO.getResultProposal();
	}

	public Long getSeqIdProposal() {
		return seqIdProposal;
	}

	public void setSeqIdProposal(Long seqIdProposal) {
		this.seqIdProposal = seqIdProposal;
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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "ProposalEntity [seqIdProposal=" + seqIdProposal
				+ ", resultProposal=" + resultProposal + ", limitProposal="
				+ limitProposal + ", customer=" + customer + "]";
	}

}
