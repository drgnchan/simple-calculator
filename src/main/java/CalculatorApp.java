import org.example.calculator.Calculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n输入以下操作符(+, -, *, /, undo, redo)，加减乘除可以直接跟随一个数字，或者输入 q 退出程序:");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            if (input.equalsIgnoreCase("undo")) {
                if (!calculator.undo()) {
                    System.out.println("undo完了，没得undo了");
                }
                System.out.printf("undo之后结果: %.2f\n", calculator.getCurrentValue());
                continue;
            }

            if (input.equalsIgnoreCase("redo")) {
                if (!calculator.redo()) {
                    System.out.println("redo完了，没得redo了");
                }
                System.out.printf("redo之后结果: %.2f\n", calculator.getCurrentValue());
                continue;
            }

            String operation = input.substring(0, 1);
            double number = 0;
            boolean validInput = true;

            try {
                number = Double.parseDouble(input.substring(1));
            } catch (NumberFormatException e) {
                validInput = false;
                System.out.println("请保证数字格式正确，请再次输入");
            }

            if (validInput) {
                // jdk新版本的语法，我用的jdk17
                switch (operation) {
                    case "+" -> calculator.add(number);
                    case "-" -> calculator.subtract(number);
                    case "*" -> calculator.multiply(number);
                    case "/" -> {
                        if (number != 0) {
                            calculator.divide(number);
                        } else {
                            System.out.println("不能除以0");
                            continue;
                        }
                    }
                    default -> {
                        System.out.println("无效的操作符，请重新输入");
                        continue;
                    }
                }
                System.out.printf("计算结果为: %.2f\n", calculator.getCurrentValue());
            }
        }

        scanner.close();
    }
}
