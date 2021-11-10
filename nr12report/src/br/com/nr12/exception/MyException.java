package br.com.nr12.exception;

public class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyException(String message){
		super(message);
	}

	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public MyException(Throwable arg1) {
		super(arg1);
	}
}
