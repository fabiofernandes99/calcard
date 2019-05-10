package com.fabio.api.credit.analysis.engine.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.fabio.api.credit.analysis.engine.model.AnalysisLimit;
import com.fabio.api.credit.analysis.engine.model.ProposalDTO;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class CreditAnalysisEngineService {

	public ProposalDTO processAnalysis(final ProposalDTO proposalDTO) throws Exception {
		ProposalDTO proposalDTOResult = proposalDTO;

		try {
			DataSource dataSource = new DataSource("proposals.arff");
			Instances instances = dataSource.getDataSet();
			instances.setClassIndex(6);

			NaiveBayes naiveBayes = new NaiveBayes();
			naiveBayes.buildClassifier(instances);

			Instance newProposal = new DenseInstance(7);
			newProposal.setDataset(instances);
			newProposal.setValue(0, proposalDTOResult.getIncome());
			newProposal.setValue(1, proposalDTOResult.getAge());
			newProposal.setValue(2, proposalDTOResult.getGender().toUpperCase());
			newProposal.setValue(3, proposalDTOResult.getMaritalStatus().toLowerCase());
			newProposal.setValue(4, proposalDTOResult.getState().toUpperCase());
			newProposal.setValue(5, proposalDTOResult.getNumberOfDependents());

			double probabilities[] = naiveBayes.distributionForInstance(newProposal);
			Double maxProbability = Arrays.stream(probabilities).max().getAsDouble();
			Arrays.stream(probabilities).forEach(System.out::println);

			int index = 0;
			for (Double probability : probabilities) {
				if (probability.doubleValue() == maxProbability.doubleValue()) {
					break;
				}
				index++;
			}
			this.calculateLimit(proposalDTOResult, AnalysisLimit.getAnalysisLimitByOrdinal(index));

		} catch (Exception e) {
			throw new Exception("Erro ao processar a proposta.", e);
		}
		return proposalDTOResult;
	}

	private void calculateLimit(ProposalDTO proposalDTOResult, AnalysisLimit analysisLimit) {
		double limit = proposalDTOResult.getIncome() * 0.2;

		String limitProposal = null;
		if (limit > AnalysisLimit.UPPER_2000.getStartValue()) {
			limitProposal = String.valueOf(limit);
			analysisLimit = AnalysisLimit.UPPER_2000;

		} else if (AnalysisLimit.DENIED.equals(analysisLimit) || AnalysisLimit.LOW_INCOME.equals(analysisLimit)) {
			limitProposal = analysisLimit.getObservation();

		} else {
			int startValue = analysisLimit.getStartValue();
			int endValue = analysisLimit.getEndValue();

			if (limit < startValue) {
				limitProposal = String.valueOf(startValue);
			} else if (limit > endValue) {
				limitProposal = String.valueOf(endValue);
			} else {
				limitProposal = String.valueOf(limit);
			}
		}
		proposalDTOResult.setLimitProposal(limitProposal);
		proposalDTOResult.setResultProposal(analysisLimit.getAnalysisResult().getStatusName());
	}

}
