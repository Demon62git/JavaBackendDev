package hw2;

import java.util.Scanner;

public class Calculator {
    private Scanner scanner;

    public Calculator() {
        scanner = new Scanner(System.in);
    }

    // Метод, выполняющий основную логику калькулятора
    public void run() {
        System.out.println("Доступные операции:");
        System.out.println("+ : сложение");
        System.out.println("- : вычитание");
        System.out.println("* : умножение");
        System.out.println("/ : деление");
        System.out.println("D : целочисленное деление");
        System.out.println("^ : возведение в степень");
        System.out.println("% : остаток от деления");

        while(true) {
            try {
                System.out.println("Введите выражение (или 'exit' для завершения): ");
                String input = scanner.nextLine().trim(); // Чистка пробелов перед и после строки

                if ("exit".equalsIgnoreCase(input)) break;

                Expression expression = parseInput(input);
                double result = executeOperation(expression.getOperand1(), expression.getOperand2(), expression.getOperator());
                System.out.println("Результат: " + result);
            } catch(IllegalArgumentException e) { // Обработка неверного формата выражения
                System.err.println(e.getMessage());
            } catch(ArithmeticException e) { // Обработка ошибок типа деление на 0
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Выход...");
    }

    // Разбор строки и получение значений операндов и оператора
    private Expression parseInput(String input) throws IllegalArgumentException {
        String[] parts = input.split("\\s+"); // Разделяем строку по пробелам

        if(parts.length != 3)
            throw new IllegalArgumentException("Неверное выражение. Повторите ввод.");

        double operand1 = Double.parseDouble(parts[0]);
        char operator = parts[1].charAt(0);
        double operand2 = Double.parseDouble(parts[2]);

        return new Expression(operand1, operand2, operator);
    }

    // Выполнение выбранной операции
    private double executeOperation(double operand1, double operand2, char operation) {
        switch(operation) {
            case '+':
                return new Addition(operand1, operand2).calculate();
            case '-':
                return new Subtraction(operand1, operand2).calculate();
            case '*':
                return new Multiplication(operand1, operand2).calculate();
            case '/':
                return new Division(operand1, operand2).calculate();
            case '^':
                return new Power(operand1, operand2).calculate();
            case '%':
                return new Modulo(operand1, operand2).calculate();
            case 'D': // Для целочисленного деления используем специальное обозначение
                return new IntegerDivision(operand1, operand2).calculate();
            default:
                throw new IllegalArgumentException("Ошибка, такой операции нет");
        }
    }

    // Вспомогательный класс для хранения структуры выражения
    static class Expression {
        private final double operand1;
        private final double operand2;
        private final char operator;

        public Expression(double operand1, double operand2, char operator) {
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.operator = operator;
        }

        public double getOperand1() {
            return operand1;
        }

        public double getOperand2() {
            return operand2;
        }

        public char getOperator() {
            return operator;
        }
    }

    public static void main(String[] args) {
        new Calculator().run();
    }
}