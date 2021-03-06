/**
 * 
 * This file is part of the AircraftSimulator Project, written as 
 * part of the assessment for CAB302, semester 1, 2016. 
 * 
 */
package asgn2Simulators;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author hogan
 *
 */
@SuppressWarnings("serial")
public class GUISimulator extends JFrame implements Runnable {
	// Create Text Area & Make it scrollable
	static JTextArea ta = new JTextArea("", 19, 69);
	JScrollPane scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	// Create Labels
	JLabel l1 = new JLabel("Simulation");
	JLabel l2 = new JLabel("Face Classes");
	JLabel l3 = new JLabel("Operation");
	JLabel l4 = new JLabel("RNG Seed");
	JLabel l5 = new JLabel("Daily Mean");
	JLabel l6 = new JLabel("Queue Size");	
	JLabel l7 = new JLabel("Cancellation");
	JLabel l8 = new JLabel("First");
	JLabel l9 = new JLabel("Business");
	JLabel l10 = new JLabel("Premium");
	JLabel l11 = new JLabel("Economy");
	
	// Create Text Fields
	JTextField t1 = new JTextField(Integer.toString(Constants.DEFAULT_SEED), 8);
	JTextField t2 = new JTextField(Double.toString(Constants.DEFAULT_DAILY_BOOKING_MEAN), 8);
	JTextField t3 = new JTextField(Integer.toString(Constants.DEFAULT_MAX_QUEUE_SIZE), 8);
	JTextField t4 = new JTextField(Double.toString(Constants.DEFAULT_CANCELLATION_PROB), 8);
	JTextField t5 = new JTextField(Double.toString(Constants.DEFAULT_FIRST_PROB), 8);
	JTextField t6 = new JTextField(Double.toString(Constants.DEFAULT_BUSINESS_PROB), 8);
	JTextField t7 = new JTextField(Double.toString(Constants.DEFAULT_PREMIUM_PROB), 8);
	JTextField t8 = new JTextField(Double.toString(Constants.DEFAULT_ECONOMY_PROB), 8);
	
	// Create Buttons
	JButton b1 = new JButton("Run Simulation");
	JButton b2 = new JButton("Show Chart 1");
	JButton b3 = new JButton("Show Chart 2");
	
	// Create Panels
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
	JPanel p13 = new JPanel();
	JPanel p14 = new JPanel();
	
	// Create dataset Series'
	private static XYSeries first = new XYSeries("First");
	private static XYSeries business = new XYSeries("Business");
	private static XYSeries premium = new XYSeries("Premium");
	private static XYSeries economy = new XYSeries("Economy");
	private static XYSeries total = new XYSeries("Total");
	private static XYSeries empty = new XYSeries("Empty");
	private static XYSeries queued = new XYSeries("Queued");
	private static XYSeries refused = new XYSeries("Refused");
	
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public GUISimulator(String arg0) throws HeadlessException {
		super(arg0);
		
		// Setup Frame
		setSize(800,540);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Setup Panels
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		p1.add(p13);
			p13.add(scroll);
		p1.add(p14);
			p14.setLayout(new GridLayout(0, 3, 80, 0));
			p14.add(p2);
				p2.setLayout(new GridLayout(5, 1, 0, 0));
				p2.add(l1);
					l1.setHorizontalAlignment(SwingConstants.CENTER);
					l1.setFont(new Font("Arial", Font.PLAIN, 30));
				p2.add(p5);
					p5.setLayout(new GridLayout(0, 2, 0, 0));
					p5.add(l4);
					p5.add(t1);
				p2.add(p6);
					p6.setLayout(new GridLayout(0, 2, 0, 0));
					p6.add(l5);
					p6.add(t2);
				p2.add(p7);
					p7.setLayout(new GridLayout(0, 2, 0, 0));
					p7.add(l6);
					p7.add(t3);
				p2.add(p8);
					p8.setLayout(new GridLayout(0, 2, 0, 0));
					p8.add(l7);
					p8.add(t4);
			p14.add(p3);
				p3.setLayout(new GridLayout(5, 1, 0, 0));
				p3.add(l2);
					l2.setHorizontalAlignment(SwingConstants.CENTER);
					l2.setFont(new Font("Arial", Font.PLAIN, 30));
				p3.add(p9);
					p9.setLayout(new GridLayout(0, 2, 0, 0));
					p9.add(l8);
					p9.add(t5);
				p3.add(p10);
					p10.setLayout(new GridLayout(0, 2, 0, 0));
					p10.add(l9);
					p10.add(t6);
				p3.add(p11);
					p11.setLayout(new GridLayout(0, 2, 0, 0));
					p11.add(l10);
					p11.add(t7);
				p3.add(p12);
					p12.setLayout(new GridLayout(0, 2, 0, 0));
					p12.add(l11);
					p12.add(t8);
			p14.add(p4);
				p4.setLayout(new GridLayout(5, 1, 0, 0));
				p4.add(l3);
					l3.setHorizontalAlignment(SwingConstants.CENTER);
					l3.setFont(new Font("Arial", Font.PLAIN, 30));
				p4.add(b1);
				p4.add(b2);
				p4.add(b3);

		// Add Panels to Window
		add(p1);

		/**
		 * Charts cannot be generated until the dataset series'
		 * are populated with data, and combined into a dataset
		 */
		// Disable Chart Buttons by Default
		b2.setEnabled(false);
		b3.setEnabled(false);
		
		// Add Event Listeners to Text Fields
		t3.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				changeColour();
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				changeColour();
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				changeColour();
			}
			/**
			 * If there is no text in the TextField no change
			 * in colour is noticible, so do nothing.
			 * 
			 * If the value inside the TextField is invalid
			 * change the text colour to red.
			 * 
			 * When the text is cahnged to be valid again change
			 *  the colour to black.
			 */
			public void changeColour(){
				if(!t3.getText().equals("")){
					try{
						if(Integer.parseInt(t3.getText())>Constants.DEFAULT_MAX_QUEUE_SIZE){
							t3.setForeground(Color.RED);
						} else {
							t3.setForeground(Color.BLACK);
						}
					} catch(NumberFormatException e) {
						t3.setForeground(Color.RED);
					}
				}
			}
		});
		
		/**
		 * When the Run Simulation button is pressed, evaluate
		 * all of the data in the text fields, if invalid data
		 * is present, provide the user with an error and replace
		 * the value with it's default.
		 */
		// Add Event Listeners to Buttons
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No RNG Seed specified using Default Seed instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t1.setText(Integer.toString(Constants.DEFAULT_SEED));
				}
				try{
					Integer.parseInt(t1.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid RNG Seed specified using Default Seed instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t1.setText(Integer.toString(Constants.DEFAULT_SEED));
				}
				
				if(t2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No Daily Mean specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t2.setText(Double.toString(Constants.DEFAULT_DAILY_BOOKING_MEAN));
				}
				try{
					Double.parseDouble(t2.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Daily Mean specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t2.setText(Double.toString(Constants.DEFAULT_DAILY_BOOKING_MEAN));
				}
				
				if(t3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No Queue Size specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t3.setText(Integer.toString(Constants.DEFAULT_MAX_QUEUE_SIZE));
				}
				try{
					if(Integer.parseInt(t3.getText())>Constants.DEFAULT_MAX_QUEUE_SIZE) {
						JOptionPane.showMessageDialog(null, "Custom Queue Size specified is too large using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
						t3.setText(Integer.toString(Constants.DEFAULT_MAX_QUEUE_SIZE));
					}
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Queue Size specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t3.setText(Integer.toString(Constants.DEFAULT_MAX_QUEUE_SIZE));
				}
				
				if(t4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No Cancellation Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t4.setText(Double.toString(Constants.DEFAULT_CANCELLATION_PROB));
				}
				try{
					Double.parseDouble(t4.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Cancellation Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t4.setText(Double.toString(Constants.DEFAULT_CANCELLATION_PROB));
				}
				
				if(t5.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No First Class Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t5.setText(Double.toString(Constants.DEFAULT_FIRST_PROB));
				}
				try{
					Double.parseDouble(t5.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid First Class Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t5.setText(Double.toString(Constants.DEFAULT_FIRST_PROB));
				}
				
				if(t6.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No Business Class Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t6.setText(Double.toString(Constants.DEFAULT_BUSINESS_PROB));
				}
				try{
					Double.parseDouble(t6.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Business Class Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t6.setText(Double.toString(Constants.DEFAULT_BUSINESS_PROB));
				}
				
				if(t7.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No Premium Economy Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t7.setText(Double.toString(Constants.DEFAULT_PREMIUM_PROB));
				}
				try{
					Double.parseDouble(t7.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Premium Economy Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t7.setText(Double.toString(Constants.DEFAULT_PREMIUM_PROB));
				}
				
				if(t8.getText().equals("")){
					JOptionPane.showMessageDialog(null, "No Economy Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t8.setText(Double.toString(Constants.DEFAULT_ECONOMY_PROB));
				}
				try{
					Double.parseDouble(t8.getText());
				} catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid Economy Modifier specified using Default Value instead.", "Error", JOptionPane.ERROR_MESSAGE);
					t8.setText(Double.toString(Constants.DEFAULT_ECONOMY_PROB));
				}
				
				// Run the main method from SimulationRunner
				String[] args = new String[]{t1.getText(), t3.getText(), t2.getText(), Double.toString(Constants.DEFAULT_DAILY_BOOKING_SD), t5.getText(), t6.getText(), t8.getText(), t7.getText(), t4.getText()};
				SimulationRunner.main(args);
				
				// Enable the chart buttons.
				b2.setEnabled(true);
				b3.setEnabled(true);
			}
		});
		
		// Open chart 1.
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				XYChartPanel.main(createDataset());
			}
		});
		
		// Open chart 2.
		b3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				XYChartPanel.main(createOtherDataset());
			}
		});
		
		// Make Window Visible
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// Not sure what is supposed to go here.
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new GUISimulator("Airline Simulator");
	}
	
	/**
	 * A simple helper method for writing to the GUI TextArea.
	 * 
	 * @param string Text to add to text area.
	 */
	static public void writeToTextArea(String string){
		ta.append(string);
	}
	
	/**
	 * Method to create the dataset for the first chart.
	 * 
	 * @return A dataset object.
	 */
	private XYDataset createDataset(){
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(first);
		dataset.addSeries(business);
		dataset.addSeries(premium);
		dataset.addSeries(economy);
		dataset.addSeries(total);
		dataset.addSeries(empty);
		return dataset;
	}
	
	/**
	 * Method to create the dataset or the secon chart.
	 * 
	 * @return A dataset object.
	 */
	private XYDataset createOtherDataset(){
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(queued);
		dataset.addSeries(refused);
		return dataset;
	}
	
	/**
	 * A simple helper method for recording the chart data.
	 * 
	 * @param series Integer denoting which series to input the data to.
	 * @param x Double containing the X axis value of the data.
	 * @param y Double containing the Y axis value of the data.
	 */
	public static void addData(int series, double x, double y){
		switch(series){
			case 0:
				first.add(x, y);
				break;
			case 1:
				business.add(x, y);
				break;
			case 2:
				premium.add(x, y);
				break;
			case 3:
				economy.add(x, y);
				break;
			case 4:
				total.add(x, y);
				break;
			case 5:
				empty.add(x, y);
				break;
			case 6:
				queued.add(x, y);
				break;
			case 7:
				refused.add(x, y);
				break;
		}
	}
}
