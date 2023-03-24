package org.example.operation;

import org.example.calculator.Calculator;

public abstract class AbstractOperation implements Operation {

    /**
     * 操作数
     */
    double value;
    /**
     * 计算器示例
     */
    Calculator calculator;
    /**
     * 计算之前的旧值快照
     */
    double oldValue;

    AbstractOperation(Calculator calculator, double value) {
        this.value = value;
        this.calculator = calculator;
        this.oldValue = calculator.getCurrentValue();
    }

    @Override
    public void undo() {
        calculator.setCurrentValue(oldValue);
    }
}
