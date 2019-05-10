package com.fabio.api.credit.controller.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.api.credit.controller.exception.ServiceException;
import com.fabio.api.credit.controller.integration.CreditAnalysisEngineIntegration;
import com.fabio.api.credit.controller.integration.CreditProposalEngineIntegration;
import com.fabio.api.credit.controller.model.ProposalDTO;

import javassist.NotFoundException;

@Service
public class CreditProposalEngineService {

	@Autowired
	private CreditAnalysisEngineIntegration creditAnalysisEngineIntegration;

	@Autowired
	private CreditProposalEngineIntegration creditProposalEngineIntegration;

	public ProposalDTO processProposal(@Valid ProposalDTO proposal) throws Exception {
		ProposalDTO proposalDTOResuult = null;
		try {
			proposalDTOResuult = this.creditAnalysisEngineIntegration.processAnalysis(proposal);
		} catch (Exception e) {
			throw new ServiceException("Erro ao processar a proposta de crédito.", e);
		}
		try {
			this.creditProposalEngineIntegration.saveProposal(proposalDTOResuult);
		} catch (Exception e) {
			throw new ServiceException("Erro ao salvar a proposta.", e);
		}
		return proposalDTOResuult;
	}

	public ProposalDTO findProposal(@NotNull String cpf) throws Exception {
		ProposalDTO proposalDTO = null;
		try {
			proposalDTO = this.creditProposalEngineIntegration.findProposal(cpf);
		} catch (Exception e) {
			throw new ServiceException("Erro ao tentar recuperar uma proposta por cpf.", e);
		}
		if (proposalDTO == null) {
			throw new NotFoundException("Não existe proposta para este cpf.");
		}
		return proposalDTO;
	}

	public List<ProposalDTO> getAllProposals() throws Exception {
		List<ProposalDTO> list = null;
		try {
			list = this.creditProposalEngineIntegration.getAllProposals();
		} catch (Exception e) {
			throw new ServiceException("Erro ao tentar recuperar todas as propostas.", e);
		}
		if (list == null || list.isEmpty()) {
			throw new NotFoundException("Não existe proposta cadastrada.");
		}
		return list;
	}
}
