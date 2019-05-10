package com.fabio.api.credit.controller.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final String message, final Throwable e) {
		super(message, e);
	}

}
