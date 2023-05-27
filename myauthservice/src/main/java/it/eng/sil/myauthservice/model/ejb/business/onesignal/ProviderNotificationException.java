package it.eng.sil.myauthservice.model.ejb.business.onesignal;

public class ProviderNotificationException extends Exception {

	private static final long serialVersionUID = -9129054711633044041L;

	public ProviderNotificationException(String message) {
		super(message);
	}

	public ProviderNotificationException(String message, Throwable cause) {
		super(message, cause);

	}

}
