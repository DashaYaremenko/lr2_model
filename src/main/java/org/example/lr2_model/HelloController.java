package org.example.lr2_model;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    private LineChart<Number, Number> yChart;

    @FXML
    private LineChart<Number, Number> yDotChart;

    @FXML
    private Button simulateButton;

    private final Calculate calculator = new Calculate();

    @FXML
    private void initialize() {
        NumberAxis xAxis1 = new NumberAxis();
        xAxis1.setLabel("Time (t)");
        NumberAxis yAxis1 = new NumberAxis();
        yAxis1.setLabel("y(t)");

        yChart.setTitle("Графік y(t)");
        yChart.getXAxis().setLabel("Time (t)");
        yChart.getYAxis().setLabel("y(t)");

        NumberAxis xAxis2 = new NumberAxis();
        xAxis2.setLabel("Time (t)");
        NumberAxis yAxis2 = new NumberAxis();
        yAxis2.setLabel("y'(t)");

        yDotChart.setTitle("Графік y'(t)");
        yDotChart.getXAxis().setLabel("Time (t)");
        yDotChart.getYAxis().setLabel("y'(t)");

        simulateButton.setOnAction(e -> simulate());
    }

    private void simulate() {
        XYChart.Series<Number, Number> ySeries = calculator.getYSeries();
        XYChart.Series<Number, Number> yDotSeries = calculator.getYDotSeries();

        yChart.getData().clear();
        yChart.getData().add(ySeries);
        yDotChart.getData().clear();
        yDotChart.getData().add(yDotSeries);
    }
}