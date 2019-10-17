package ru.antony.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class Controller {
    private String text;
    private double firstOperand;
    private double secondOperand;
    private double total;

    public Controller() {}

    public void calculateTotal(ActionEvent actionEvent) {
        total = firstOperand + secondOperand;
    }

    public String getText() {
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
