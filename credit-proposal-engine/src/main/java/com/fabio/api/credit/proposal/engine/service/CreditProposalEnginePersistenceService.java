package com.fabio.api.credit.proposal.engine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.api.credit.proposal.engine.entity.CustomerEntity;
import com.fabio.api.credit.proposal.engine.entity.ProposalEntity;
import com.fabio.api.credit.proposal.engine.model.ProposalDTO;
import com.fabio.api.credit.proposal.engine.persistence.CustomerRepository;
import com.fabio.api.credit.proposal.engine.persistence.ProposalRepository;

@Service
public class CreditProposalEnginePersistenceService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProposalRepository proposalRepository;

	public void saveProposal(ProposalDTO proposalDTO) throws Exception {
		CustomerEntity customer = new CustomerEntity(proposalDTO);
		this.customerRepository.save(customer);

		ProposalEntity proposalEntity = new ProposalEntity(proposalDTO);
		proposalEntity.setCustomer(customer);
		this.proposalRepository.save(proposalEntity);
	}

	public ProposalDTO findProposal(String cpf) throws Exception {
		List<ProposalEntity> proposals = this.proposalRepository
				.findByCustomerCpf(cpf);
		Optional<CustomerEntity> customer = this.customerRepository
				.findById(cpf);

		if (customer.isPresent() && proposals != null) {
			return new ProposalDTO(customer.get(),
					proposals.get(proposals.size() - 1));
		} else {
			return null;
		}
	}

	public List<ProposalDTO> getAllProposals() throws Exception {
		List<ProposalDTO> listOfProposals = new ArrayList<ProposalDTO>();

		List<CustomerEntity> allCustomers = this.customerRepository.findAll();
		allCustomers.forEach(customer -> {
			List<ProposalEntity> proposals = this.proposalRepository
					.findByCustomerCpf(customer.getCpf());
			proposals.forEach(proposal -> {
				listOfProposals.add(new ProposalDTO(customer, proposal));
			});
		});
		return listOfProposals;
	}

}
