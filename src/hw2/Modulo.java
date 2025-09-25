package hw2;

// Остаток от деления
public class Modulo extends Operation {
    public Modulo(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    public double calculate() {
        if (operand2 == 0) throw new ArithmeticException("Ошибка - деление на ноль.");
        return operand1 % operand2;
    }
}
