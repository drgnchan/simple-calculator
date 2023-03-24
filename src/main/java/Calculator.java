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
        Operation operation = new Operation() {
            @Override
            public void undo() {
                currentValue -= value;
            }

            @Override
            public void redo() {
                currentValue += value;
            }
        };

        operation.redo();
        undoStack.push(operation);
        redoStack.clear();
        return currentValue;
    }

    public double subtract(double value) {
        return add(-value);
    }

    public double multiply(double value) {
        double oldValue = currentValue;
        Operation operation = new Operation() {
            @Override
            public void undo() {
                currentValue = oldValue;
            }

            @Override
            public void redo() {
                currentValue *= value;
            }
        };

        operation.redo();
        undoStack.push(operation);
        redoStack.clear();
        return currentValue;
    }


    public double divide(double value) {
        if (value == 0) {
            throw new IllegalArgumentException("不能除以0");
        }
        double oldValue = currentValue;
        Operation operation = new Operation() {
            @Override
            public void undo() {
                currentValue = oldValue;
            }

            @Override
            public void redo() {
                currentValue /= value;
            }
        };

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
}
