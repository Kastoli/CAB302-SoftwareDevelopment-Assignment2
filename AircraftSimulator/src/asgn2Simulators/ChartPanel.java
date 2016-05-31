package asgn2Simulators;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot; 

/**
 * 
 * @author Liam Dinsdale
 *
 */
@SuppressWarnings("serial")
public class ChartPanel extends JFrame {
	
	public ChartPanel(String arg0, Plot plot) throws HeadlessException {
		super(arg0);
		
		setSize(800,540);
		setResizable(false);
		
		JFreeChart chart = new JFreeChart(plot);
		
		JPanel chartJPanel = new JPanel();
		chartJPanel.setLayout(new BorderLayout());
		
		org.jfree.chart.ChartPanel chartPanel = new org.jfree.chart.ChartPanel(chart);
		
		chartJPanel.add(chartPanel,BorderLayout.CENTER);
		
		add(chartJPanel);
	}
	
}
