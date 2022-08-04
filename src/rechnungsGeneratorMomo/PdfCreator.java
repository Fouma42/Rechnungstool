package rechnungsGeneratorMomo;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfCreator {

	public  String createPdf(Kunde kunde, ArrayList<Angebotspositionen>positionen) throws IOException {
		String path=PdfHelper.path +kunde.getVorname()+"_"+kunde.getNachName()+"_"+ PdfHelper.getCurrentDate()+"_"+kunde.getRechnungsNummer()+".pdf";
		PDDocument document = new PDDocument();
		PDPage page1 = new PDPage(PDRectangle.A4);
		document.addPage(page1);
		PDPageContentStream cos = new PDPageContentStream(document, page1);
		cos.beginText();
		cos.setFont(PDType1Font.COURIER_BOLD, 18);
		cos.newLineAtOffset(360, 800);
		cos.showText("Momo´s Fensterputz");
		cos.endText();

		createadress(cos, kunde);
		addStartText(cos,kunde);
		drawRectangle(cos);
		addOfferCredentials(cos,kunde, positionen);
		addlastText(cos);
		footer(cos);
		cos.close();
		document.save(path);
		document.close();
		return path;
	}

	public  void createadress(PDPageContentStream cos, Kunde kunde) throws IOException {
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_ABSENDER_ADRESSZEILE);
		cos.showText("Muammer Dalkilic");
		cos.endText();

		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_ABSENDER_ADRESSZEILE - PdfHelper.DEFAULT_TEXT_COLUMN);
		cos.showText("Bachstr. 8/1");
		cos.endText();
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_ABSENDER_ADRESSZEILE -(2* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText("71384 Weinstadt");
		cos.endText();
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_ABSENDER_ADRESSZEILE -(3* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText("Tel: 01577/1928653");
		cos.endText();
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_ABSENDER_ADRESSZEILE -(4* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText("E-mail: info@momos-fensterputz.de");
		cos.endText();
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_ABSENDER_ADRESSZEILE -(5* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText("Web: www.momos-fensterputz.de");
		cos.endText();
		
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_EMPFAENGER_ADRESSZEILE -(1* PdfHelper.DEFAULT_TEXT_COLUMN));
		if(kunde.getFirma()==null) {
			cos.showText(kunde.getVorname()+ " "+ kunde.getNachName());
		}else {
			cos.showText(kunde.getFirma());
		}
		cos.endText();
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_EMPFAENGER_ADRESSZEILE -(2* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText(kunde.getStrasse());
		cos.endText();
		cos.beginText();
		
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_EMPFAENGER_ADRESSZEILE -(3* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText(kunde.getPlz()+ " "+ kunde.getOrt());
		cos.endText();
		
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE, PdfHelper.OBEN_BEGIN_EMPFAENGER_ADRESSZEILE -(6* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText("Datum: "+ PdfHelper.getCurrentDate());
		cos.endText();
		
		cos.beginText();
		cos.setFont(PdfHelper.FONT_DEFAULT_BOLD, 12);
		cos.newLineAtOffset(PdfHelper.RAND_LINKS_ADRESSZEILE+300, PdfHelper.OBEN_BEGIN_EMPFAENGER_ADRESSZEILE -(6* PdfHelper.DEFAULT_TEXT_COLUMN));
		cos.showText("Rechnungsnummer: " +kunde.getRechnungsNummer());
		cos.endText();

	}
	
	 void drawRectangle(PDPageContentStream contentStream) throws IOException {
		// Rectangle
		contentStream.addRect(PdfHelper.RECT_START_X, PdfHelper.RECT_START_Y,
				PdfHelper.RECT_WIDTH, PdfHelper.RECT_HEIGHT);
		contentStream.setNonStrokingColor(Color.orange);
		contentStream.fill();

		contentStream.setNonStrokingColor(Color.black);
		
		// Offer Position Description
		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_POS, PdfHelper.RECT_START_Y_TEXT);
		contentStream.showText("Leistung");
		contentStream.endText();

		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_EINZELPREIS,
				PdfHelper.RECT_START_Y_TEXT);
		contentStream.showText("Einzelpreis");
		contentStream.endText();

		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_GESAMTPREIS,
				PdfHelper.RECT_START_Y_TEXT);
		contentStream.showText("Gesamtpreis");
		contentStream.endText();

	}
	
	 void addOfferCredentials(PDPageContentStream contentStream, Kunde kunde, ArrayList<Angebotspositionen>positionen) throws IOException {
		int pixelPosition_Y = PdfHelper.RECT_START_Y_TEXT - 20;
		int gesamtPreis=0;
		int posNr=0;
		for (Angebotspositionen i : positionen) {
			posNr++;
			gesamtPreis=gesamtPreis +Integer.valueOf(i.getBetrag());
			contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_EINZELPREIS, pixelPosition_Y);
			contentStream.showText(String.valueOf(i.getBetrag()) + ",00 EUR");
			contentStream.endText();
			contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_GESAMTPREIS, pixelPosition_Y);
			contentStream.showText(String.valueOf(i.getBetrag()) + ",00 EUR");
			contentStream.endText();
					if(!i.getLeistungsBeschreibung().isBlank()) {
						contentStream.beginText();
						contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_POS, pixelPosition_Y);
						contentStream.showText(i.getLeistungsBeschreibung().replace("\n", "").replace("\r", ""));
						contentStream.endText();
					}
					pixelPosition_Y-=15;
					if(!i.getLeistungsBeschreibung().isBlank()) {
						contentStream.beginText();
						contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_POS, pixelPosition_Y);
						contentStream.showText(i.getLeistungsBeschreibung1().replace("\n", "").replace("\r", ""));
						contentStream.endText();
					}
					pixelPosition_Y-=15;
					if(!i.getLeistungsBeschreibung2().isBlank()) {
						contentStream.beginText();
						contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_POS, pixelPosition_Y);
						contentStream.showText(i.getLeistungsBeschreibung2().replace("\n", "").replace("\r", ""));
						contentStream.endText();
					}				
					
			pixelPosition_Y -=20;
		}
		
		contentStream.setFont(PdfHelper.FONT_DEFAULT_BOLD, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_MENGE, pixelPosition_Y-30);
		contentStream.showText("Gesamtsumme:");		
		contentStream.endText();
		
		
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RECT_START_X_TEXT_GESAMTPREIS, pixelPosition_Y-30);
		contentStream.showText(String.valueOf(gesamtPreis)+",00 EUR");		
		contentStream.endText();
	}
	
	 void addlastText(PDPageContentStream contentStream) throws IOException {
		int startEndText=PdfHelper.RECT_START_Y_TEXT - 250;
		
		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT, startEndText);
		contentStream.showText("Zahlbar innerhalb 14 Tagen nach Erhalt der Rechnung.");
		contentStream.endText();	

		contentStream.setFont(PdfHelper.FONT_DEFAULT, 8);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT, startEndText-20);
		contentStream.showText("Diese Rechnung enthält aufgrund §19 UstG. keine Umsatzsteuer.");
		contentStream.endText();
		 
		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT, startEndText-50);
		contentStream.showText("Vielen Dank für Ihren Auftrag.");
		contentStream.endText();	
		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT, startEndText-70);
		contentStream.showText("Mit freundlichen Grüßen");
		contentStream.endText();	
		
		contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
		contentStream.beginText();
		contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT, startEndText-120);
		contentStream.showText("Muammer Dalkilic");
		contentStream.endText();
		
	}

	  void addStartText(PDPageContentStream contentStream, Kunde kunde) throws IOException {
		 contentStream.setNonStrokingColor(Color.black);
		 String anrede=kunde.getAnrede();

			// Dicke Schrift bzw. Überschrift
			contentStream.setFont(PdfHelper.FONT_DEFAULT_BOLD, PdfHelper.FONT_SIZE_BOLD_BOLD);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT, PdfHelper.OBEN_BEGIN_LETTER_TEXT);
			if(anrede.equals("Herr")) {
				contentStream.showText("Sehr geehrter Herr "+ kunde.getNachName()+ ",");
			}
			if(anrede.equals("Frau")){
				contentStream.showText("Sehr geehrte Frau "+ kunde.getNachName()+ ",");
			}
			if(anrede.equals("Damen und Herren")) {
				contentStream.showText("Sehr geehrte Damen und Herren,");
			}
			contentStream.endText();

			// Farbe auf dark gray
			contentStream.setNonStrokingColor(Color.black);

			int abstandsHalter = 20;

			// Textzeile 1 bis 3
			contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT,	PdfHelper.OBEN_BEGIN_LETTER_TEXT - abstandsHalter);
			contentStream.showText("Ich erlaube mir folgende Leistungen für meine Dienstleistungen in Rechnung zu stellen.");
			contentStream.endText();

	 }
	  
	  void footer(PDPageContentStream contentStream) throws IOException {
			contentStream.addRect(PdfHelper.RECT_START_X, 80,
					PdfHelper.RECT_WIDTH, PdfHelper.RECT_HEIGHT);
			contentStream.setNonStrokingColor(Color.orange);
			contentStream.fill();
			
			contentStream.setNonStrokingColor(Color.black);
		    contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT,60);
			contentStream.showText("Bankverbindung Sparkasse Waiblingen");
			contentStream.endText();
			
			contentStream.setNonStrokingColor(Color.black);
			contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT+ 320,60);
			contentStream.showText("Steuernummer: 90064-19340");
			contentStream.endText();
			
			contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT,40);
			contentStream.showText("IBAN: DE64 6025 0010 1001 6949 19");
			contentStream.endText();
			
			contentStream.setFont(PdfHelper.FONT_DEFAULT, PdfHelper.FONT_SIZE_DEFAULT);
			contentStream.beginText();
			contentStream.newLineAtOffset(PdfHelper.RAND_LINKS_DEFAULT,20);
			contentStream.showText("BIC: SOLADES1WBN");
			contentStream.endText();
	  }
}
