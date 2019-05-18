package search;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interfaces.Setting;
import mainClasses.DB;
import mainClasses.SearchFrame;
import mainClasses.SearchFrame;
import search.DownloadButton;
import search.ListenButton;

public class SearchPanel extends JPanel implements Setting {
	private JLabel musicTitle = new JLabel("MusicTitle");
	private JLabel musicArtist = new JLabel("MusicArtist");
	public ArrayList<ListenButton> listenButtons = new ArrayList<ListenButton>();
	public ArrayList<DownloadButton> downloadButtons = new ArrayList<DownloadButton>();
	public static ArrayList<JLabel> musicNames = new ArrayList<JLabel>();
	public ArrayList<JLabel> artistNames = new ArrayList<JLabel>();
	public ArrayList<String> musics;
	public ArrayList<String> artists;
	public String userID = mainClasses.MainController.mainFrame.logPanel.getLogInfoPanel().idTextF.getText();
	public String searchText = mainClasses.MainController.mainFrame.mainPanel.searchTextF.getText();

	public static int numOfMusicInSearchList = 0;	// number of music in the play-list
	
	public static Font font = new Font ("Arial", Font.BOLD, SearchFrame.frameHeight / 30);
	
	public SearchPanel() {this.setThis(null);}

	public void setThis(Component prevComp) {
		ListenButton.numOfListen = 0;
		DownloadButton.numOfListen = 0;
		musics = DB.getInstance().getSearchMusic(userID,searchText);
		artists = DB.getInstance().getSearchMusicArtist(userID,searchText);
		numOfMusicInSearchList = musics.size();
		System.out.println("Music: "+musics.get(0)+"\nArtist: "+artists.get(0));
		this.setBounds(0, 0, SearchFrame.frameWidth, SearchFrame.frameHeight);
		this.setLayout(null);
		this.setComponents();
		this.addComponents();
	}

	public void setComponents() {
		
		for(int i=0; i<numOfMusicInSearchList ;i++)
		{
			listenButtons.add(new ListenButton());
			listenButtons.get(i).setThis(null,i);
			downloadButtons.add(new DownloadButton());
			downloadButtons.get(i).setThis(null,i);
			musicNames.add(new JLabel(musics.get(i)));
			musicNames.get(i).setBounds(SearchFrame.frameWidth/10, SearchFrame.frameHeight/10+40*i, 180, 35);
			artistNames.add(new JLabel(artists.get(i)));
			artistNames.get(i).setBounds(SearchFrame.frameWidth/10+190, SearchFrame.frameHeight/10+40*i, 180, 35);
		}
		
		musicTitle.setFont(font);
		musicTitle.setSize(musicTitle.getPreferredSize());
		musicTitle.setLocation(50, 30);
		musicArtist.setFont(font);
		musicArtist.setSize(musicArtist.getPreferredSize());
		musicArtist.setLocation(250, 30);
		
	}

	public void addComponents() {
		
		this.add(musicTitle);
		this.add(musicArtist);
		
		for(int i=0; i<numOfMusicInSearchList; i++)
		{
			this.add(musicNames.get(i));
			this.add(artistNames.get(i));
			this.add(listenButtons.get(i));
			this.add(downloadButtons.get(i));
		}
	}	
}
