package org.example.operation;

import org.example.calculator.Calculator;

public class AddOperation implements Operation {

    private double value;
    private Calculator calculator;


    private AddOperation(Calculator calculator, double value) {
        this.value = value;
        this.calculator = calculator;
    }

    public static Operation getInstance(Calculator calculator, double value) {
        AddOperation add = new AddOperation(calculator, value);
        return add;

    }

    @Override
    public void undo() {
        calculator.setCurrentValue(calculator.getCurrentValue() - value);
    }

    @Override
    public void redo() {
        calculator.setCurrentValue(calculator.getCurrentValue() + value);
    }
}
