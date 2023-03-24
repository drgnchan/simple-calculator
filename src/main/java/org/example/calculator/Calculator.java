package org.example.calculator;

import org.example.operation.*;

import java.util.Stack;

public class Calculator {
    private double currentValue;
    private Stack<Operation> undoStack;
    private Stack<Operation> redoStack;

    public Calculator() {
        // 初始值是0
        this.currentValue = 0;
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public double add(double value) {
        return doOperation(AddOperation.class, value);
    }

    public double subtract(double value) {
        return add(-value);
    }

    public double multiply(double value) {
        return doOperation(MultiplyOperation.class, value);
    }


    public double divide(double value) {
        return doOperation(DivideOperation.class, value);
    }

    private double doOperation(Class<? extends AbstractOperation> operationClazz, double value) {
        Operation operation = OperationFactory.getInstance(operationClazz, this, value);
        operation.redo();
        undoStack.push(operation);
        redoStack.clear();
        return currentValue;
    }

    public boolean undo() {
        if (!undoStack.isEmpty()) {
            Operation operation = undoStack.pop();
            operation.undo();
            redoStack.push(operation);
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (!redoStack.isEmpty()) {
            Operation operation = redoStack.pop();
            operation.redo();
            undoStack.push(operation);
            return true;
        }
        return false;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}
