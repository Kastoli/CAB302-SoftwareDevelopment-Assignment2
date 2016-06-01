package asgn2Simulators;

import java.awt.BasicStroke;
import java.awt.Color;

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
	public XYChartPanel(String windowTitle, String chartTitle, XYDataset dataset){
		super(windowTitle);
		JFreeChart XYLineChart = ChartFactory.createXYLineChart(chartTitle, "Days", "Passengers", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(XYLineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 540));
		XYPlot plot = XYLineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	    renderer.setSeriesPaint( 0 , Color.RED );
	    renderer.setSeriesPaint( 1 , Color.GREEN );
	    renderer.setSeriesPaint( 2 , Color.YELLOW );
	    renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	    renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
	    renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
	    plot.setRenderer( renderer ); 
	    setContentPane( chartPanel );
	}
	
	public static void main(XYDataset dataset){
		XYChartPanel chart = new XYChartPanel("Simulation Graph 1", "Simulation Results", dataset);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}
}
