package rechnungsGeneratorMomo;

public class Angebotspositionen {
	private String leistungsBeschreibung;
	private String leistungsBeschreibung1;
	private String leistungsBeschreibung2;
	private int betrag;
	


	
	public Angebotspositionen(String besch1,String besch2, String besch3,int betrag) {
		this.leistungsBeschreibung=besch1;
		this.leistungsBeschreibung1=besch2;
		this.leistungsBeschreibung2=besch3;
		this.betrag=betrag;
		
	}

	public String getLeistungsBeschreibung() {
		return leistungsBeschreibung;
	}

	public void setLeistungsBeschreibung(String leistungsBeschreibung) {
		this.leistungsBeschreibung = leistungsBeschreibung;
	}

	public String getLeistungsBeschreibung1() {
		return leistungsBeschreibung1;
	}

	public void setLeistungsBeschreibung1(String leistungsBeschreibung1) {
		this.leistungsBeschreibung1 = leistungsBeschreibung1;
	}

	public String getLeistungsBeschreibung2() {
		return leistungsBeschreibung2;
	}

	public void setLeistungsBeschreibung2(String leistungsBeschreibung2) {
		this.leistungsBeschreibung2 = leistungsBeschreibung2;
	}

	public int getBetrag() {
		return betrag;
	}

	public void setBetrag(int betrag) {
		this.betrag = betrag;
	}

}
