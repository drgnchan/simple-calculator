package org.example.operation;

import org.example.calculator.Calculator;

public class AddOperation extends AbstractOperation {

    AddOperation(Calculator calculator, double value) {
        super(calculator, value);
    }


    @Override
    public void redo() {
        calculator.setCurrentValue(calculator.getCurrentValue() + value);
    }
}
