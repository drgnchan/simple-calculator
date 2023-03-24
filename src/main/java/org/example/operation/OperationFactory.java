package org.example.operation;

import org.example.calculator.Calculator;

public class OperationFactory {
    public static <T extends AbstractOperation> Operation getInstance(Class<T> tClass, Calculator calculator, double value) {
        if (tClass.equals(AddOperation.class)) {
            return new AddOperation(calculator, value);
        } else if (tClass.equals(MultiplyOperation.class)) {
            return new MultiplyOperation(calculator, value);
        } else if (tClass.equals(DivideOperation.class)) {
            return new DivideOperation(calculator, value);
        } else {
            throw new RuntimeException("不支持的操作符");
        }
    }
}
