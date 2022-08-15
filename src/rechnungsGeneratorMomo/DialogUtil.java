package rechnungsGeneratorMomo;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogUtil {

	public JDialog createDialog(String title, String label, JFrame frame) {
		JDialog dialog = new JDialog();
		dialog.setTitle(title);
		dialog.getContentPane().add(new JLabel(label));
		dialog.setSize(200, 150);
		dialog.setLocation((int) frame.getLocation().getX() + 100, (int) frame.getLocation().getY() + 50);
		dialog.setModal(true);
		dialog.setVisible(true);
		return dialog;
	}

}
