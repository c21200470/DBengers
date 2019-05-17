package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import interfaces.Setting;

public class MainDateButton extends JButton implements Setting {

	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Date");
		this.setFont(MainPanel.font);
		this.setBorderPainted(true);
		this.setSize(MainPanel.rankButtonWidth, this.getFont().getSize() + MainPanel.marginHeight);
		this.setLocation(prevComp.getX() + prevComp.getWidth(), prevComp.getY());
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
