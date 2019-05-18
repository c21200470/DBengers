package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import interfaces.Setting;

public class MainAllButton extends JButton implements Setting {

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("All");
		this.setFont(MainPanel.smallFont);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize().width, this.getFont().getSize() + MainPanel.marginHeight);
		this.setLocation(prevComp.getX(), prevComp.getY() + prevComp.getHeight());
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	public class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
}
