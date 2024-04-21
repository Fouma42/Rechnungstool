package rechnungsGeneratorMomo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JFrame;

public class ClipboardUeberwachen extends JFrame implements FlavorListener{
 
    private Clipboard clip;
    private Transferable transferData;
 
    public ClipboardUeberwachen() {
        setTitle("Clipbordtest");
        setSize(new Dimension(250, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);      
        clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.addFlavorListener(this);
    }
    
    public static void main(String arg[]) {
        new ClipboardUeberwachen();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
@Override
	public void flavorsChanged(FlavorEvent e) {
		
		//clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		transferData = clip.getContents(null);
      
        try {
            String data = "";
            if (transferData != null) {
                data = (String) transferData
                        .getTransferData(DataFlavor.stringFlavor);
                System.out.println(data);
            } else {
                System.out.println("null");
            }
 
        } catch (UnsupportedFlavorException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }		
    }
}
