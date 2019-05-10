package com.fabio.api.credit.analysis.engine.model;

import java.util.Arrays;

public enum AnalysisLimit {

	DENIED("reprovado", AnalysisResult.DENIED, "Reprovado pela política de crédito"), 
	LOW_INCOME("renda-baixa", AnalysisResult.DENIED, "Renda baixa"), 
	BETWEEN_100_500("100-500", AnalysisResult.APPROVED, 100, 500), 
	BETWEEN_500_1000("500-1000",AnalysisResult.APPROVED, 500, 1000), 
	BETWEEN_1000_1500("1000-1500", AnalysisResult.APPROVED, 1000, 1500), 
	BETWEEN_1500_2000("1500-2000", AnalysisResult.APPROVED, 1500, 2000), 
	UPPER_2000("superior", AnalysisResult.APPROVED, 2000, Integer.MAX_VALUE);

	private String limit;
	private AnalysisResult result;
	private int startValue;
	private int endValue;
	private String observation;

	private AnalysisLimit(final String limit, final AnalysisResult result) {
		this.limit = limit;
		this.result = result;
	}

	private AnalysisLimit(final String limit, final AnalysisResult result, final String observation) {
		this.limit = limit;
		this.result = result;
		this.observation = observation;
	}

	private AnalysisLimit(final String limit, final AnalysisResult result, final int startValue, final int endValue) {
		this.limit = limit;
		this.result = result;
		this.startValue = startValue;
		this.endValue = endValue;
	}

	public String getLimit() {
		return this.limit;
	}

	public AnalysisResult getAnalysisResult() {
		return this.result;
	}

	public int getStartValue() {
		return this.startValue;
	}

	public int getEndValue() {
		return this.endValue;
	}
	
	public String getObservation() {
		return this.observation;
	}

	public static AnalysisLimit getAnalysisLimitByOrdinal(final int ordinal) {
		return Arrays.stream(values()).filter(item -> item.ordinal() == ordinal).findFirst().get();
	}
}
