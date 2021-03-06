package myPage;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.JoinFrame;
import mainClasses.MyPageFrame;

public class MyPageUserInfoPanel extends JPanel implements Setting {
	
	private JLabel[] labels = {new JLabel("Name"), new JLabel("ID"), new JLabel("PW"),new JLabel("Last PW changed"),  new JLabel("Nickname")
								, new JLabel("Birthday"), new JLabel("Gender"),new JLabel("Address"), new JLabel("E-mail")
								, new JLabel("Phone num"), new JLabel("Voucher name"), new JLabel("Is Artist"), new JLabel("Alarm to mail"), new JLabel("Alarm to SMS"), new JLabel("Streaming "), new JLabel("Download ")};
	public JLabel[] dblabels = {new JLabel("Name"), new JLabel("ID"), new JLabel("PW"),new JLabel("Last PW changed"),  new JLabel("Nickname")
								, new JLabel("Birthday"), new JLabel("Gender"),new JLabel("Address"), new JLabel("E-mail")
								, new JLabel("Phone num"), new JLabel("Voucher name"), new JLabel("Is Artist"), new JLabel("Alarm to mail"), new JLabel("Alarm to SMS"), new JLabel("0"), new JLabel("0")};

	public HashMap <String, String> infoHash = new HashMap <String, String>(); 
	public ArrayList<String> infos = new ArrayList<String>();
	
	public static Font font = new Font ("Arial", Font.BOLD, MyPageFrame.frameHeight / 30);
	
	private void setLabels(){
		for (JLabel label : labels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	private void setDbLabels() {		
		infos = DB.getInstance().getUserInfo(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText());
		
		for (int i = 0; i < infos.size(); i++) {
			dblabels[i].setText(infos.get(i));
			infoHash.put(labels[i].getText(), dblabels[i].getText());
		}
		
		
		for (JLabel label : dblabels) {
			label.setFont(font);
			label.setHorizontalAlignment(JLabel.LEFT);
		}
	}
	
	@Override
	public void setThis(Component prevComp) {
		// TODO Auto-generated method stub
		this.setBounds(JoinFrame.frameWidth / 6, JoinFrame.frameHeight / 7, JoinFrame.frameWidth / 2, JoinFrame.frameHeight * 4 / 7);
		this.setLayout(new GridLayout(labels.length, 2));
		this.setComponents();
		this.addComponents();
		this.setSize(this.getPreferredSize());
	}

	@Override
	public void setComponents() {
		// TODO Auto-generated method stub
		setLabels();
		setDbLabels();
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		for (int i = 0; i < labels.length; i++) {
			this.add(labels[i]);
			this.add(dblabels[i]);
		}
	}

}
