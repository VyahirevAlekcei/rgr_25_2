package Calculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public final class buttonPDF extends JButton {
	
	public buttonPDF() {

	        setText("Создать PDF");
	        setBounds(325, 300, 150, 30);
	        setBackground(Color.WHITE);
	        setForeground(Color.BLACK);
	}
}