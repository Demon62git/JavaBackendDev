package hw2;

// Операция сложения
public class Addition extends Operation {
    public Addition(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override   // Проверка сигнатуры метода
    public double calculate() {
        return operand1 + operand2;
    }
}