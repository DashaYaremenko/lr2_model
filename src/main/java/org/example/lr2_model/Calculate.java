package org.example.lr2_model;
import javafx.scene.chart.XYChart;

public class Calculate {

    private final double b1 = 0.01;
    private final double b2 = 3.0;
    private final double c1 = 1.1;
    private final double c3 = -1.1;
    private final double sigma = 0.100;
    private final double omega = 1.0;
    private final double dt = 0.05;
    private final double maxTime = 180.0;
    private final double initY = 0.145;
    private final double initYDot = 0.0;

    public XYChart.Series<Number, Number> getYSeries() {
        XYChart.Series<Number, Number> ySeries = new XYChart.Series<>();
        ySeries.setName("y(t)");
        double y = initY;
        double yDot = initYDot;
        for (double t = 0; t <= maxTime; t += dt) {
            ySeries.getData().add(new XYChart.Data<>(t, y));
            double yDoubleDot = -b1*yDot-b2*Math.abs(yDot)*yDot-c1*y-c3*Math.pow(y,3)+sigma*Math.sin(omega*t);
            yDot+=yDoubleDot*dt;
            y+=yDot*dt;
        }
        return ySeries;
    }

    public XYChart.Series<Number, Number> getYDotSeries() {
        XYChart.Series<Number, Number> yDotSeries = new XYChart.Series<>();
        yDotSeries.setName("y'(t)");
        double y = initY;
        double yDot = initYDot;
        for (double t = 0; t <= maxTime; t += dt) {
            yDotSeries.getData().add(new XYChart.Data<>(t, yDot));
            double yDoubleDot = -b1*yDot-b2*Math.abs(yDot)*yDot-c1*y-c3*Math.pow(y,3)+sigma*Math.sin(omega*t);
            yDot+=yDoubleDot*dt;
            y+=yDot*dt;
        }
        return yDotSeries;
    }
}

