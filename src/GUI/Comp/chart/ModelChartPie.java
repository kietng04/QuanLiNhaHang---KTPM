/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Comp.chart;

import java.awt.Color;

public class ModelChartPie {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModelChartPie(String name, double value, Color color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public ModelChartPie() {
    }

    private String name;
    private double value;
    private Color color;
}
