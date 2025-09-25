package hw2;

// Целочисленное деление
public class IntegerDivision extends Operation {
    public IntegerDivision(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    public double calculate() {
        if (operand2 == 0) throw new ArithmeticException("Ошибка - деление на ноль.");
        return Math.floorDiv((long) operand1, (long) operand2); // Используем long для целочисленного деления
    }
}