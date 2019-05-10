package com.fabio.api.credit.controller.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.fabio.api.credit.controller.model.ProposalDTO;

@FeignClient(name = "CreditAnalysisEngineIntegration", url = "localhost:8091/api/credit-analysis-engine")
public interface CreditAnalysisEngineIntegration {

	@PostMapping("/processAnalysis")
	public ProposalDTO processAnalysis(ProposalDTO proposalDTO);

}
