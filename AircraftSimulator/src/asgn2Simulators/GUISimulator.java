/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable {	
	JPanel p = new JPanel();
	JButton b = new JButton("Hello");
	JTextField t = new JTextField("Hi", 20);
	JTextArea ta = new JTextArea("How\nAre\nYou?", 5, 20);
	JLabel l = new JLabel("What's up");
	String choices[] = {
		"Hallo",
		"Bonjour",
		"Guten Tag"
	};
	JComboBox cb = new JComboBox(choices);

	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		
		setSize(400,300);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.add(b);
		p.add(t);
		p.add(ta);
		p.add(l);
		p.add(cb);
		add(p);
		
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUISimulator("Window Title");
	}

}
