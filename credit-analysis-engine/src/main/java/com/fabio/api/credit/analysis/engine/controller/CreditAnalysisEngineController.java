package com.fabio.api.credit.analysis.engine.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.api.credit.analysis.engine.model.ProposalDTO;
import com.fabio.api.credit.analysis.engine.service.CreditAnalysisEngineService;

@RestController
@RequestMapping(value = "/api/credit-analysis-engine/")
public class CreditAnalysisEngineController {

	@Autowired
	private CreditAnalysisEngineService service;

	@PostMapping("/processAnalysis")
	public ProposalDTO processAnalysis(@Valid @RequestBody ProposalDTO proposalDTO) throws Exception {
		return this.service.processAnalysis(proposalDTO);
	}
}
