package rechnungsGeneratorMomo;

public class MailCredentials {
	private final String SMTP_HOST = "smtp-mail.outlook.com";
	private final String TLS_PORT = "587";
	private final String AUTHENTICATION = "true";
	private final String PROTOCOL = "TLSv1.2";
	private final String START_TLS_ENABLE = "true";
	private final String FROM_MAIL = "fouma2003@msn.com";
	private final String PASSWORD = "Fouma1322251509";

	public String getSMTP_HOST() {
		return SMTP_HOST;
	}

	public String getTLS_PORT() {
		return TLS_PORT;
	}

	public String getAUTHENTICATION() {
		return AUTHENTICATION;
	}

	public String getPROTOCOL() {
		return PROTOCOL;
	}

	public String getSTART_TLS_ENABLE() {
		return START_TLS_ENABLE;
	}

	public String getFROM_MAIL() {
		return FROM_MAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

}
