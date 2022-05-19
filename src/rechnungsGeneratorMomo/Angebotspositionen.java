package rechnungsGeneratorMomo;

import java.util.ArrayList;

public class Angebotspositionen {
	private String leistungsBeschreibung;
	private String leistungsBeschreibung1;
	private String leistungsBeschreibung2;
	private String betrag;
	private ArrayList<String>beschreibungen;
	
	public ArrayList<String> getBeschreibungen() {
		return beschreibungen;
	}
	public void setBeschreibungen(ArrayList<String> beschreibungen) {
		this.beschreibungen = beschreibungen;
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
	public String getBetrag() {
		return betrag;
	}
	public void setBetrag(String betrag) {
		this.betrag = betrag;
	}
	
	

}
