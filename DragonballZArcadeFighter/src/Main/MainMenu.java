/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ChampSelect.CheckBox;

public class MainMenu extends JFrame implements ActionListener {

	ImageIcon background = new ImageIcon("DBZBackground.png");
	Image backG = background.getImage();
	Image bg = backG.getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);
	ImageIcon DBZBackground = new ImageIcon(bg);
	JLabel bgLabel = new JLabel(DBZBackground);

	ImageIcon logo = new ImageIcon("DBZLogo.png");
	Image logo1 = logo.getImage();
	Image logo2 = logo1.getScaledInstance(450, 200, java.awt.Image.SCALE_SMOOTH);
	ImageIcon logo3 = new ImageIcon(logo2);
	JLabel logoLabel = new JLabel(logo3);
	
	ImageIcon cont = new ImageIcon("controls.png");
	Image cont1 = cont.getImage();
	Image cont2 = cont1.getScaledInstance(630, 270, java.awt.Image.SCALE_SMOOTH);
	ImageIcon cont3 = new ImageIcon(cont2);
	JLabel controlLabel = new JLabel(cont3);

	JButton controls = new JButton("Controls");
	JButton credits = new JButton("Credits");
	JButton play = new JButton("Play");
	JButton rtrn = new JButton("Return");
	
	
	JLabel spriteCredit = new JLabel("Sprites From: ");
	JLabel spriteCredit1 = new JLabel("https://www.spriters-resource.com/3ds/dragonballzextremebutoden");
	
	JLabel youtubeCredit = new JLabel("Tutorials Used: ");
	//HTML text formatting
	JLabel youtubeCredit1 = new JLabel("<html>"
			+ "RealTutsGML. (2013, September 13).  Java Game Programming #1 - Window [video file]. Retrieved"
			+ "<br/>"
			+ " &nbsp&nbsp&nbsp&nbsp "
			+ "from http://www.youtube.com"
			+ "<br/>"
			+ "RealTutsGML. (2013, September 13).  Java Game Programming #2 - Window [video file]. Retrieved"
			+ "<br/>"
			+ " &nbsp&nbsp&nbsp&nbsp "
			+ "from http://www.youtube.com"
			+ "</html>");
	
	
	JLabel controls1 = new JLabel("Controls: ");
	JLabel controls2 = new JLabel("*To select a character, Player1 uses [a] and [d] to move and [enter] to confirm. Player2 uses [left] and [right] instead");
	
	
	public MainMenu() {

		super("DBZ");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setBackground(Color.black);

		// controls button and settings
		controls.setBounds(125, 330, 220, 30);
		controls.setActionCommand("Controls");
		controls.addActionListener(this);
		controls.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		// credits button and settings

		credits.setBounds(355, 330, 220, 30);
		credits.setActionCommand("Credits");
		credits.addActionListener(this);
		credits.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		// play button and settings

		play.setBounds(125, 265, 450, 55);
		play.setActionCommand("Play");
		play.addActionListener(this);
		play.setFont(new Font("Times New Roman", Font.PLAIN, 28));

		// label settings
		
		rtrn.setBounds(125, 365, 450, 55);
		rtrn.setActionCommand("Return");
		rtrn.addActionListener(this);
		rtrn.setFont(new Font("Times New Roman", Font.PLAIN, 28));

		spriteCredit.setBounds(40, 20, 650, 55);
		spriteCredit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		spriteCredit1.setBounds(40, 50, 650, 55);
		spriteCredit1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		spriteCredit1.setForeground(Color.white);
		
		
		youtubeCredit.setBounds(40, 80, 650, 55);
		youtubeCredit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		youtubeCredit1.setBounds(40, 110, 650, 75);
		youtubeCredit1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		youtubeCredit1.setForeground(Color.white);
		
		controls2.setBounds(40, 270, 670, 70);
		controls2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		controls2.setForeground(Color.white);
		
		bgLabel.setBounds(0, 0, 700, 500);
		logoLabel.setBounds(110, 75, 500, 180);
		controlLabel.setBounds(25, 15, 630, 270);

		// add components to contentPane

		
		add(controls2);
		add(credits);
		add(controls);
		add(play);
		add(rtrn);
		add(spriteCredit);
		add(spriteCredit1);
		add(youtubeCredit);
		add(youtubeCredit1);
		add(controlLabel);
		add(logoLabel);
		add(bgLabel);

		controls2.setVisible(false);
		controlLabel.setVisible(false);
		spriteCredit.setVisible(false);
		spriteCredit1.setVisible(false);
		youtubeCredit.setVisible(false);
		youtubeCredit1.setVisible(false);
		rtrn.setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {

		String E = event.getActionCommand();
		if (E.equals("Play")) {
			Timer timer = new Timer();
			timer.schedule(new CheckBox(), 0, 1000);
			dispose();
		}
		if (E.equals("Credits")) {
			credits.setVisible(false);
			controls.setVisible(false);
			play.setVisible(false);
			logoLabel.setVisible(false);
			spriteCredit.setVisible(true);
			spriteCredit1.setVisible(true);
			youtubeCredit.setVisible(true);
			youtubeCredit1.setVisible(true);
			rtrn.setVisible(true);
		}
		if(E.equals("Controls")) {
			credits.setVisible(false);
			controls.setVisible(false);
			play.setVisible(false);
			logoLabel.setVisible(false);

			controls2.setVisible(true);
			controlLabel.setVisible(true);
			rtrn.setVisible(true);
		}
		
		if(E.equals("Return")) {
			credits.setVisible(true);
			controls.setVisible(true);
			play.setVisible(true);
			logoLabel.setVisible(true);
			spriteCredit.setVisible(false);
			spriteCredit1.setVisible(false);
			youtubeCredit.setVisible(false);
			youtubeCredit1.setVisible(false);
			rtrn.setVisible(false);
			controls2.setVisible(false);
			controlLabel.setVisible(false);
		}

	}

	public static void main(String args[]) {
		MainMenu menu = new MainMenu();
	}

}