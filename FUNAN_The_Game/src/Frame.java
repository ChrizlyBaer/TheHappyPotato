import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


//NOTICE: Maybe I have to make the class Frame to implements ActionListener
public class Frame extends JFrame{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JButton start;
	private static JButton options;
	private static JButton information;
	private static JButton close;

	public static void main(String[] args) {
				
		//create an ActionListener 
		ActionListener buttonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == start){
					createGameFrame("The FUNAN Game", 1500, 1000);
				} else if(e.getSource() == options){
					
				} else if(e.getSource() == information){
					//Object[] option = {"OK"};
					JOptionPane.showConfirmDialog(null, "Programmiert von FUFU", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );	
				} else if(e.getSource() == close){
					System.exit(0);
				}
				
			}

		};
		
		//declarate the frame
		JFrame menuFrame = new JFrame("Menu");
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setSize(400, 400);
		menuFrame.setLayout(null);
		menuFrame.setVisible(true);
		
		//set the titels and sizes of the buttons
		start = new JButton("Start");
		start.setBounds(120, 40, 160, 40);
		start.addActionListener(buttonListener);
		
		options = new JButton("Options");
		options.setBounds(120, 120, 160, 40);
		options.addActionListener(buttonListener);
		
		information = new JButton("Information");
		information.setBounds(120, 200, 160, 40);
		information.addActionListener(buttonListener);
		
		
		close = new JButton("Close");
		close.setBounds(120, 280, 160, 40);
		close.addActionListener(buttonListener);
		
		//add the button to the frame
		menuFrame.add(start);
		menuFrame.add(options);
		menuFrame.add(information);
		menuFrame.add(close);
		
		try{
		Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
		URL url = new File("src/Sound/BackgroundSound.wav").toURI().toURL();
        AudioInputStream ais = AudioSystem.  getAudioInputStream(url);    // getAudioInputStream("Sound/BackgroundSound.wav");
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
	
	private static void createGameFrame(String title, int width, int height) {
		
		//declarate the frame
		JFrame gameFrame = new JFrame(title);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(width, height);
		gameFrame.add(new gui());
		//gameFrame.setLayout(null);
		gameFrame.setVisible(true);
	}



}
