package com.fabio.api.credit.controller.model;

public enum AnalysisResult {

	APPROVED("Aprovado"), DENIED("Negado");

	private String statusName;

	private AnalysisResult(final String statusName) {
		this.statusName = statusName;
	}

	public String getStatusName() {
		return this.statusName;
	}
}
