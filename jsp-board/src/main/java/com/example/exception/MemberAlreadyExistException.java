package com.example.exception;

public class MemberAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MemberAlreadyExistException(String msg) { super(msg); }

}
