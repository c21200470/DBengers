package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mainClasses.DB;
import mainClasses.JoinFrame;

public class LogButtonActionListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource().toString().contains("text=Login")) {
			int count = DB.getInstance().getPreviousWrongCount(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText());
			if(DB.getInstance().checkLogin(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText()
							, new String(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().pwTextF.getPassword()),count)) {
				
				//지울때는 항상 setVisible(false) 할
				mainClasses.MainController.mainFrame.logPanel.setVisible(false);
				mainClasses.MainController.mainFrame.remove(mainClasses.MainController.mainFrame.logPanel);
				mainClasses.MainController.mainFrame.add(mainClasses.MainController.mainFrame.mainPanel);
			
			}	
			else {
				DB.getInstance().updateCurrentWrongCount(mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText());
				JOptionPane.showMessageDialog(null, "Wrong ID or PW!", "WARNING", JOptionPane.ERROR_MESSAGE);
			}
				
				
		} else if (e.getSource().toString().contains("text=Join")) {
			int ans = JOptionPane.showOptionDialog(null, "Do you want to sign up as a Artist?", "User type check", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			
			//make question to choose user artist
			if (ans == JOptionPane.CANCEL_OPTION || ans == JOptionPane.CLOSED_OPTION)
				return;
			
			if (ans == JOptionPane.NO_OPTION) {
				mainClasses.MainController.joinFrame = new mainClasses.JoinFrame();
				mainClasses.MainController.joinFrame.setThis();
			}
			else	// artist registration
			{
				mainClasses.MainController.joinFrame = new mainClasses.JoinFrame();
				mainClasses.MainController.joinFrame.setThis2();
			}
		}
	}
	
}
