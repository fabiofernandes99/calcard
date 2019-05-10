package com.fabio.api.credit.controller.integration;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fabio.api.credit.controller.model.ProposalDTO;

@FeignClient(name = "CreditProposalEngineIntegration", url = "localhost:8092/api/credit-proposal-engine")
public interface CreditProposalEngineIntegration {

	@PostMapping("/saveProposal")
	public void saveProposal(ProposalDTO proposal) throws Exception;

	@GetMapping("/findProposal/{cpf}")
	public ProposalDTO findProposal(@PathVariable("cpf") String cpf) throws Exception;

	@GetMapping("/getAllProposals")
	public List<ProposalDTO> getAllProposals() throws Exception;

}
