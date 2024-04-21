package rechnungsGeneratorMomo;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfHelper {
	// CONSTANTS
	static public String path = "C:\\Rechnungen\\";

	static public PDFont FONT_DEFAULT = PDType1Font.TIMES_ROMAN;
	static public PDFont FONT_DEFAULT_BOLD = PDType1Font.TIMES_BOLD;
	static public int FONT_SIZE_DEFAULT = 12;
	static public int FONT_SIZE_BOLD = 9;
	static public int FONT_SIZE_BOLD_BOLD = 12;

	static public int DEFAULT_TEXT_COLUMN = 15;

	static public final int RAND_LINKS_DEFAULT = 72;

	// Adresszzeile
	static public final int RAND_LINKS_ADRESSZEILE = RAND_LINKS_DEFAULT;
	static public final int OBEN_BEGIN_ABSENDER_ADRESSZEILE = 770;
	static public final int OBEN_BEGIN_EMPFAENGER_ADRESSZEILE = 660;
	static public final int OBEN_BEGIN_LETTER_TEXT = 530;

	// Orange Rectangle
	static public final int RECT_START_X = RAND_LINKS_DEFAULT;
	static public final int RECT_START_Y = 470;
	static public final int RECT_WIDTH = 469;
	static public final int RECT_HEIGHT = 18;

	static public final int RECT_START_Y_TEXT = RECT_START_Y + 6;
	static public final int RECT_START_X_TEXT_POS = RECT_START_X + 4;
	static public final int RECT_START_X_TEXT_BESCHREIBUNG = RECT_START_X + 48;
	static public final int RECT_START_X_TEXT_MENGE = RECT_START_X + 285;
	static public final int RECT_START_X_TEXT_EINZELPREIS = RECT_START_X + 320;
	static public final int RECT_START_X_TEXT_GESAMTPREIS = RECT_START_X + 407;

	// Gray Rectangle
	static public final Color LIGHT_SENTAX_GRAY = new Color(241, 241, 241);

	// METHODS
	static public String getCurrentDate() {
		Date date = (Date) java.util.Calendar.getInstance().getTime();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
		return String.valueOf(dateFormatter.format(date));
	}
}
