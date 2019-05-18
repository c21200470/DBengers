package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;

public class MainMusicAddToListButton extends JButton implements Setting {
	int rowNum;
	
	MainMusicAddToListButton(int rowNum) {this.rowNum = rowNum;}

	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setText("Add to playlist");
		this.setFont(MainMusicRowPanel.buttonFont);
		this.setBorderPainted(true);
		this.setSize(this.getPreferredSize());
		this.addActionListener(new Listener());
	}

	@Override
	public void setComponents() {}

	@Override
	public void addComponents() {}
	
	public class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int musicId = mainClasses.MainController.mainFrame.mainPanel.musicPanel.rows[((MainMusicAddToListButton)e.getSource()).rowNum].music_id;
			String playlistName = JOptionPane.showInputDialog("Type your playlist name");
			
			
			DB.getInstance().addToMyPlaylist(DB.currentID, musicId, playlistName);
			
			JOptionPane.showMessageDialog(null, musicId + " is added to " + playlistName, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
