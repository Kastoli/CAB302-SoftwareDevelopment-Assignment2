/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

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
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		
		setSize(800,540);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		getContentPane().add(p1);
		
		p1.add(panel);
		panel.add(ta);
		
		p1.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 80, 0));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		
		l1.setFont(new Font("Arial", Font.PLAIN, 30));
		p5.setLayout(new GridLayout(0, 2, 0, 0));
		
		p5.add(l4);
		p5.add(t1);
		p7.setLayout(new GridLayout(0, 2, 0, 0));
		p7.add(l6);
		p7.add(t3);
		p8.setLayout(new GridLayout(0, 2, 0, 0));
		p8.add(l7);
		p8.add(t4);
		panel_1.add(p2);
		p2.setLayout(new GridLayout(5, 1, 0, 0));
		
		p2.add(l1);
		p2.add(p5);
		p2.add(p6);
		p6.setLayout(new GridLayout(0, 2, 0, 0));
		p6.add(l5);
		p6.add(t2);
		p2.add(p7);
		p2.add(p8);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Arial", Font.PLAIN, 30));
		p9.setLayout(new GridLayout(0, 2, 0, 0));
		p9.add(l8);
		
		p9.add(t5);
		p10.setLayout(new GridLayout(0, 2, 0, 0));
		p10.add(l9);
		p10.add(t6);
		p11.setLayout(new GridLayout(0, 2, 0, 0));
		p11.add(l10);
		p11.add(t7);
		p12.setLayout(new GridLayout(0, 2, 0, 0));
		p12.add(l11);
		p12.add(t8);
		panel_1.add(p3);
		p3.setLayout(new GridLayout(5, 1, 0, 0));
		
		p3.add(l2);
		p3.add(p9);
		p3.add(p10);
		p3.add(p11);
		p3.add(p12);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setFont(new Font("Arial", Font.PLAIN, 30));
		panel_1.add(p4);
		p4.setLayout(new GridLayout(5, 1, 0, 0));
		p4.add(l3);
		p4.add(b1);
		p4.add(b2);
		
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
