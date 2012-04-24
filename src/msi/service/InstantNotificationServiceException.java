package msi.service;

public class InstantNotificationServiceException extends Exception {
	private static final long serialVersionUID = -4901720328570694331L;

	public InstantNotificationServiceException(Exception e){
		super(e);
	}
	public InstantNotificationServiceException(String message){
		super(message);
	}
	public InstantNotificationServiceException(String message,Exception e){
		super(message,e);
	}
}
