package com.roxoft.buildingcompany.main;

public class AbsolutFilePathException extends Exception {

	private static final long serialVersionUID = 1L;

	public AbsolutFilePathException() {
	}

	public AbsolutFilePathException(String message) {
		super(message);
	}

	public AbsolutFilePathException(String message, Throwable exception) {
		super(message, exception);
	}

}
