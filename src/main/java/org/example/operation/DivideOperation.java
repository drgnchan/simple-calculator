package org.example.operation;

import org.example.calculator.Calculator;

public class DivideOperation extends AbstractOperation {

    DivideOperation(Calculator calculator, double value) {
        super(calculator, value);
    }

    @Override
    public void redo() {
        if (value == 0) {
            throw new IllegalArgumentException("不能除以0");
        }
        calculator.setCurrentValue(calculator.getCurrentValue() / value);
    }
}
