package cis350.group.trocker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.util.List;

import cis350.group.trocker.model.*;

public class WaiverStatisticsController {

	@FXML
	private BarChart<String, Integer> barChart;

	@FXML
	private CategoryAxis xAxis;

	private ObservableList<String> waiverOptions = FXCollections.observableArrayList();

	@FXML
	public void intialize() {
		waiverOptions.add("Yes");
		waiverOptions.add("No");

		xAxis.setCategories(waiverOptions);
	}

	public void setMemberData(List<Member> members) {
		int[] counter = new int[2];
		
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).isWaiver() == "Yes")
				counter[0] += 1;
			if (members.get(i).isWaiver() == "No")
				counter[1] += 1;
		}

		XYChart.Series<String, Integer> series = createWaiverSeries(counter);
		barChart.getData().add(series);
	}

	private XYChart.Series<String, Integer> createWaiverSeries(int[] counter) {
		XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();

		for (int i = 0; i < counter.length; i++) {
			XYChart.Data<String, Integer> monthData = new XYChart.Data<String,Integer>(waiverOptions.get(i), counter[i]);
			series.getData().add(monthData);
		}

		return series;
	}
}
