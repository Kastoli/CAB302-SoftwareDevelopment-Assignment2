/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable {	
	JTextArea ta = new JTextArea("", 19, 69);
	JLabel l1 = new JLabel("Simulation");
	JLabel l2 = new JLabel("Face Classes");
	JLabel l3 = new JLabel("Operation");
	JLabel l4 = new JLabel("RNG Seed");
	JTextField t1 = new JTextField(8);
	JLabel l5 = new JLabel("Daily Mean");
	JTextField t2 = new JTextField(8);
	JLabel l6 = new JLabel("Queue Size");
	JTextField t3 = new JTextField(8);
	JLabel l7 = new JLabel("Cancellation");
	JTextField t4 = new JTextField(8);
	JLabel l8 = new JLabel("First");
	JTextField t5 = new JTextField(8);
	JLabel l9 = new JLabel("Business");
	JTextField t6 = new JTextField(8);
	JLabel l10 = new JLabel("Premium");
	JTextField t7 = new JTextField(8);
	JLabel l11 = new JLabel("Economy");
	JTextField t8 = new JTextField(8);
	JButton b1 = new JButton("Run Simulation");
	JButton b2 = new JButton("Show Chart 2");
	
	JPanel p1 = new JPanel();
	
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();
	
	JPanel p9 = new JPanel();
	JPanel p10 = new JPanel();
	JPanel p11 = new JPanel();
	JPanel p12 = new JPanel();
	
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		l1.setFont(new Font("Arial", Font.PLAIN, 30));
		l2.setFont(new Font("Arial", Font.PLAIN, 30));
		l3.setFont(new Font("Arial", Font.PLAIN, 30));
		
		p5.add(l4);
		p5.add(t1);
		p6.add(l5);
		p6.add(t2);
		p7.add(l6);
		p7.add(t3);
		p8.add(l7);
		p8.add(t4);
		
		p2.add(l1);
		p2.add(p5);
		p2.add(p6);
		p2.add(p7);
		p2.add(p8);
		
		p9.add(t5);
		p9.add(l8);
		p10.add(t6);
		p10.add(l9);
		p11.add(t7);
		p11.add(l10);
		p12.add(t8);
		p12.add(l11);
		
		p3.add(l2);
		p3.add(p9);
		p3.add(p10);
		p3.add(p11);
		p3.add(p12);
		
		p4.add(l3);
		p4.add(b1);
		p4.add(b2);
		
		p1.add(ta);
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		
		add(p1);
		
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
