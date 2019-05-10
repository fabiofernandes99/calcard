package com.fabio.api.credit.proposal.engine.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.api.credit.proposal.engine.model.ProposalDTO;
import com.fabio.api.credit.proposal.engine.service.CreditProposalEnginePersistenceService;

@RestController
@RequestMapping(value = "/api/credit-proposal-engine/")
public class CreditProposalEngineController {

	@Autowired
	private CreditProposalEnginePersistenceService persistenceService;

	@PostMapping(value = "/saveProposal")
	public void saveProposal(@Valid @RequestBody ProposalDTO proposal)
			throws Exception {
		this.persistenceService.saveProposal(proposal);
	}

	@GetMapping(value = "/findProposal/{cpf}")
	public ProposalDTO findProposal(
			@NotNull @PathVariable(name = "cpf") String cpf) throws Exception {
		return this.persistenceService.findProposal(cpf);
	}

	@GetMapping(value = "/getAllProposals")
	public List<ProposalDTO> getAllProposals() throws Exception {
		return this.persistenceService.getAllProposals();
	}

}
