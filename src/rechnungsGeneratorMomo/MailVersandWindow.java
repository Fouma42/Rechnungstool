package rechnungsGeneratorMomo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MailVersandWindow {

	private JFrame mailFrame;
	private JTextField mailempfaenger;
	private File pathToPdf;


	/**
	 * Create the application.
	 */
	public MailVersandWindow(File path) {
		initialize(path);
	}
public JFrame getMailFrame() {
	return mailFrame;
}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(File path) {
		this.pathToPdf=path;
		mailFrame = new JFrame();
		mailFrame.setBounds(100, 100, 411, 372);
		mailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mailFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empf\u00E4nger");
		lblNewLabel.setBounds(38, 45, 65, 23);
		mailFrame.getContentPane().add(lblNewLabel);
		mailFrame.setLocationRelativeTo(null);
		mailempfaenger = new JTextField();
		mailempfaenger.setBounds(38, 65, 324, 29);
		mailFrame.getContentPane().add(mailempfaenger);
		mailempfaenger.setColumns(10);
		
		JTextArea mailText = new JTextArea();
		mailText.setBounds(38, 140, 324, 105);
		mailFrame.getContentPane().add(mailText);
		
		JLabel lblNewLabel_1 = new JLabel("Email text");
		lblNewLabel_1.setBounds(38, 117, 65, 13);
		mailFrame.getContentPane().add(lblNewLabel_1);
		
		JButton sendMail_btn = new JButton("Versenden");
		sendMail_btn.addActionListener(new ActionListener() {
			String subject="Ihre Rechnung.";
			
			public void actionPerformed(ActionEvent e) {
				SendMail sendMail=new SendMail();
				boolean ok= sendMail.sendEmail(mailempfaenger.getText(), subject, mailText.getText(), pathToPdf);
				
				if(ok) {
				mailFrame.dispose();
				}
				else {
					DialogUtil dialogUtil=new DialogUtil();
					dialogUtil.createDialog("Fehler", "Ein Fehler ist aufgetreten!", mailFrame);
				}
			}
		});
		sendMail_btn.setBounds(38, 268, 324, 41);
		mailFrame.getContentPane().add(sendMail_btn);
	}
}
