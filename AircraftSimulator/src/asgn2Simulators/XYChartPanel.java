package asgn2Simulators;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities; 

/**
 * 
 * @author Liam Dinsdale
 *
 */
@SuppressWarnings("serial")
public class XYChartPanel extends ApplicationFrame {
	
	/**
	 * Constructor for the XYChartPanel (Chart and Window)
	 * 
	 * @param windowTitle String containing the window title.
	 * @param chartTitle String containing the chart title.
	 * @param dataset Dataset containing the chart data.
	 */
	public XYChartPanel(String windowTitle, String chartTitle, XYDataset dataset){
		super(windowTitle);
		JFreeChart XYLineChart = ChartFactory.createXYLineChart(chartTitle, "Days", "Passengers", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(XYLineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 540));
		XYPlot plot = XYLineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	    plot.setRenderer(renderer); 
	    setContentPane(chartPanel);
	}
	
	/**
	 * Main loop for the XYChartPanel.
	 * 
	 * @param dataset
	 */
	public static void main(XYDataset dataset){
		XYChartPanel chart = new XYChartPanel("Simulation Graph", "Simulation Results", dataset);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}
