package com.fabio.api.credit.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.api.credit.controller.model.ProposalDTO;
import com.fabio.api.credit.controller.service.CreditProposalEngineService;

@RestController
@RequestMapping(value = "/api/credit-controller/")
@CrossOrigin(origins = "*")
@Validated
public class CreditControllerController {

	@Autowired
	private CreditProposalEngineService service;

	@PostMapping(value = "/processProposal")
	public ResponseEntity<ProposalDTO> processProposal(@Valid @RequestBody final ProposalDTO proposal)
			throws Exception {
		return new ResponseEntity<>(this.service.processProposal(proposal), HttpStatus.OK);
	}

	@GetMapping(value = "/findProposal/{cpf}")
	public ResponseEntity<ProposalDTO> findProposal(@NotNull @PathVariable(name = "cpf") String cpf) throws Exception {
		ProposalDTO proposal = this.service.findProposal(cpf);
		return new ResponseEntity<>(proposal, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllProposals")
	public ResponseEntity<List<ProposalDTO>> getAllProposals() throws Exception {
		return new ResponseEntity<>(this.service.getAllProposals(), HttpStatus.OK);
	}

}
