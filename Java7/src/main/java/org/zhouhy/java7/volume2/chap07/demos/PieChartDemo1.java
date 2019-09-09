package org.zhouhy.java7.volume2.chap07.demos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartDemo1 {

	public static void main(String[] args) {
		PieChartDemo1 p = new PieChartDemo1();
		ChartFrame frame = new ChartFrame("JFreeChart Demo",p.getJfreeChart());
		frame.setVisible(true);
	}
	
	public JFreeChart getJfreeChart() {
		PieDataset pieDataset = getPieDataset();
		JFreeChart chart = ChartFactory.createPieChart("Pie Chart", pieDataset, false,false,false);
		return chart;
	}
	
	private PieDataset getPieDataset() {
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		defaultPieDataset.setValue("A",200);
		defaultPieDataset.setValue("B", 300);
		defaultPieDataset.setValue("C", 500);
		return defaultPieDataset;
		
	}
}
