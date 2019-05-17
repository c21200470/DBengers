package join;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.JoinFrame;

public class JoinIdCheckButton extends JButton implements Setting {
	private Font font = new Font("Arial", Font.BOLD, JoinUserInfoPanel.font.getSize() / 2);
	
	public void setThis(Component prevComp) {
		this.setText("ID check");
		this.setFont(font);
		this.setBorderPainted(true);
		this.setBounds(prevComp.getX() + prevComp.getWidth() + JoinFrame.marginWidth / 2, prevComp.getY(), prevComp.getWidth() / 3, this.getFont().getSize() + JoinFrame.marginHeight / 2);
		this.addActionListener(new Listener());
	}

	public void setComponents() {}

	public void addComponents() {}
	
	class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(DB.getInstance().checkId(mainClasses.MainController.joinFrame.joinUserPanel.joinUserInfoPanel.idTextF.getText()))
				JOptionPane.showMessageDialog(null, "You can use it", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Use another ID", "WARNING", JOptionPane.ERROR_MESSAGE);
		}
	}
}
