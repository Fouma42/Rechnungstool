package rechnungsGeneratorMomo;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class RecnungsClentMaske {

	private JFrame frame;
	private JTextField nameText;
	private JTextField nachnameText;
	private JTextField strasseText;
	private JTextField plzText;
	private JTextField ortText;
	private JTextField betragText;
	private JTextField beschreibung;
	private JTextField beschreibung1;
	private JTextField beschreibung2;
	private JTextField firmaTextfield;
	ArrayList<Angebotspositionen> pos;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecnungsClentMaske window = new RecnungsClentMaske();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecnungsClentMaske() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pos= new ArrayList<Angebotspositionen>();
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("activeCaption"));
		frame.setBackground(Color.GRAY);
		frame.setResizable(false);
		frame.setTitle("Rechnungs Generator");
		frame.setBounds(100, 100, 784, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(399, 52, 73, 25);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nachname");
		lblNewLabel_1.setBounds(583, 58, 80, 13);
		frame.getContentPane().add(lblNewLabel_1);

		final JComboBox<String> anredeCombo = new JComboBox<String>();
		anredeCombo.setModel(new DefaultComboBoxModel(new String[] { "Herr", "Frau", "Damen und Herren" }));
		anredeCombo.setBounds(28, 77, 158, 32);
		frame.getContentPane().add(anredeCombo);

		JLabel lblNewLabel_2 = new JLabel("Anrede");
		lblNewLabel_2.setBounds(31, 60, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);

		nameText = new JTextField();
		nameText.setBounds(396, 76, 158, 32);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);

		nachnameText = new JTextField();
		nachnameText.setBounds(581, 76, 158, 32);
		frame.getContentPane().add(nachnameText);
		nachnameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Stra\u00DFe");
		lblNewLabel_3.setBounds(32, 169, 73, 13);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PLZ");
		lblNewLabel_4.setBounds(219, 169, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ort");
		lblNewLabel_5.setBounds(400, 168, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);

		strasseText = new JTextField();
		strasseText.setBounds(28, 196, 158, 32);
		frame.getContentPane().add(strasseText);
		strasseText.setColumns(10);

		plzText = new JTextField();
		plzText.setBounds(212, 196, 158, 32);
		frame.getContentPane().add(plzText);
		plzText.setColumns(10);

		ortText = new JTextField();
		ortText.setBounds(396, 194, 158, 34);
		frame.getContentPane().add(ortText);
		ortText.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Betrag");
		lblNewLabel_6.setBounds(586, 168, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);

		betragText = new JTextField();
		betragText.setBounds(583, 196, 155, 32);
		frame.getContentPane().add(betragText);
		betragText.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Beschreibung");
		lblNewLabel_7.setBounds(105, 287, 110, 13);
		frame.getContentPane().add(lblNewLabel_7);

		beschreibung = new JTextField();
		beschreibung.setBounds(105, 314, 539, 40);
		frame.getContentPane().add(beschreibung);
		beschreibung.setColumns(10);

		beschreibung1 = new JTextField();
		beschreibung1.setBounds(105, 373, 539, 40);
		frame.getContentPane().add(beschreibung1);
		beschreibung1.setColumns(10);

		beschreibung2 = new JTextField();
		beschreibung2.setBounds(106, 434, 538, 40);
		frame.getContentPane().add(beschreibung2);
		beschreibung2.setColumns(10);

		JButton rechnungErstellenButton = new JButton("Speichern");
		rechnungErstellenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameText.getText().isBlank() || nachnameText.getText().isBlank() || strasseText.getText().isBlank()
						|| ortText.getText().isBlank() || plzText.getText().isBlank() || betragText.getText().isBlank()
						|| beschreibung.getText().isBlank()) {
					JDialog dialog = new JDialog();
					dialog.setTitle("Hinweis");
					dialog.getContentPane().add(new JLabel("Bitte alle Felder befüllen!"));
					dialog.setSize(200, 150);
					dialog.setLocation(300, 300);
					dialog.setModal(true);
					dialog.setVisible(true);

				}
				Kunde kunde = new Kunde();

				kunde.setAnrede(anredeCombo.getSelectedItem().toString());
				kunde.setVorname(nameText.getText());
				kunde.setNachName(nachnameText.getText());

				kunde.setStrasse(strasseText.getText());
				kunde.setOrt(ortText.getText());
				kunde.setPlz(plzText.getText());
				if (!firmaTextfield.getText().isBlank()) {
					kunde.setFirma(firmaTextfield.getText());
				}

				try {
					kunde.setRechnungsNummer("RE-" + String.valueOf(createRechnungsnummer()));
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				PdfCreator pdf = new PdfCreator();
				try {
					String path=pdf.createPdf(kunde, pos);
					kunde = null;
					dialogFrame(path);					
					clearAllFields(true);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		rechnungErstellenButton.setBounds(327, 499, 94, 25);
		frame.getContentPane().add(rechnungErstellenButton);

		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllFields(true);
			}

			
		});
		clearBtn.setBounds(442, 499, 86, 25);
		frame.getContentPane().add(clearBtn);

		JButton addNewPosButton = new JButton("+");
		addNewPosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beschreibung.setText("");
				beschreibung1.setText("");
				beschreibung2.setText("");
				betragText.setText("");
			}
		});
		addNewPosButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		addNewPosButton.setBounds(719, 10, 45, 21);
		frame.getContentPane().add(addNewPosButton);

		JButton uebernehmenButton = new JButton("\u00DCbernehmen");
		uebernehmenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!beschreibung.getText().isBlank() && !betragText.getText().isBlank()) {
					pos.add(new Angebotspositionen(beschreibung.getText(),  beschreibung1.getText().isBlank()?"": beschreibung1.getText(), beschreibung2.getText().isBlank()?"": beschreibung2.getText(), Integer.valueOf(betragText.getText())));
				} else {
					JDialog dialog = new JDialog();
					dialog.setTitle("Hinweis");
					dialog.getContentPane().add(new JLabel("Bitte mindesten seine Beschreibung und Betrag befüllen"));
					dialog.setSize(200, 150);
					dialog.setLocation(300, 300);
					dialog.setModal(true);
					dialog.setVisible(true);
				}
			}
		});
		
		uebernehmenButton.setBounds(194, 499, 110, 25);
		frame.getContentPane().add(uebernehmenButton);

		JLabel lblNewLabel_8 = new JLabel("Firma");
		lblNewLabel_8.setBounds(212, 59, 45, 13);
		frame.getContentPane().add(lblNewLabel_8);

		firmaTextfield = new JTextField();
		firmaTextfield.setBounds(208, 77, 162, 32);
		frame.getContentPane().add(firmaTextfield);
		firmaTextfield.setColumns(10);
		
		JButton btnNewButton = new JButton("Email versenden");
		btnNewButton.setBounds(28, 11, 110, 21);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void dialogFrame(String path) {
		JDialog dialog = new JDialog();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("PDF wurde erzeugt wollen Sie die PDF anzeigen?");
		dialog.setTitle("Done");
		panel.add(label);
		dialog.setSize(320, 100);
		dialog.setLocation(frame.getLocation().x+240, frame.getLocation().y+240);
		dialog.setModal(true);
		JButton jaButton=new JButton("Ja");
		jaButton.setSize(100, 100);
		jaButton.setVisible(true);
		jaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 File file = new File(path);
			        
			        //first check if Desktop is supported by Platform or not
			        if(!Desktop.isDesktopSupported()){
			            System.out.println("Desktop is not supported");
			            return;
			        }
			        
			        Desktop desktop = Desktop.getDesktop();
			        if(file.exists())
						try {
							desktop.open(file);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			        
			        //let's try to open PDF file
			        file = new File(path);
			        if(file.exists())
						try {
							desktop.open(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        dialog.setVisible(false);
					dialog.dispose();
			    } 
				
			
		});
		panel.add(jaButton);
		JButton neinButton=new JButton("Nein");
		neinButton.setSize(100, 100);
		neinButton.setVisible(true);
		neinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();				
			}
		});
		panel.add(neinButton);
		dialog.getContentPane().add(panel);
		dialog.setVisible(true);
		
	}
	public void clearAllFields(boolean clearList) {
		nameText.setText("");
		nachnameText.setText("");
		strasseText.setText("");
		ortText.setText("");
		plzText.setText("");
		betragText.setText("");
		beschreibung2.setText("");
		beschreibung1.setText("");
		beschreibung.setText("");
		firmaTextfield.setText("");
		if(clearList) {
			pos.clear();
		}
	}

	public int createRechnungsnummer() throws IOException {
		String number = "";
		int intValue = 0;
		number = new String(Files.readAllBytes(Paths.get("C:\\NichtLöschen\\Rechnungsnummerngenerator.txt", "")));
		intValue = Integer.valueOf(number);
		intValue = intValue + 1;
		BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\NichtLöschen\\Rechnungsnummerngenerator.txt"));
		writer.write(String.valueOf(intValue));
		writer.flush();
		return intValue;
	}
}
