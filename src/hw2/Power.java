package hw2;

// Возведение в степень
public class Power extends Operation {
    public Power(double operand1, double operand2) {
        super(operand1, operand2);
    }

    @Override
    public double calculate() {
        return Math.pow(operand1, operand2);
    }
}