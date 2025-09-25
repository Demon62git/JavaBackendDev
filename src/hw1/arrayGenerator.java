package hw1;

import java.util.Scanner;
import java.util.Arrays;

public class arrayGenerator {

    // Генерация массива случайных чисел
    private static double[] generateRandomDoubleArray(int size, double min, double max) {
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = min + (max - min) * Math.random();
        }
        return result;
    }

    private static int[] generateRandomIntArray(int size, int min, int max) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = (int)(min + (max - min + 1) * Math.random());
        }
        return result;
    }

   // Вывод максимального элемента массива
    public static double findMax(double[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("Массив пуст");

        double max = array[0];
        for (double value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Перегрузка метода для целых чисел
    public static int findMax(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("Массив пуст");

        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Вывод минимального элемента массива
    public static double findMin(double[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("Массив пуст");

        double min = array[0];
        for (double value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Перегрузка метода для целых чисел
    public static int findMin(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("Массив пуст");

        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Вычисление среднего арифметического элементов массива
    public static double calculateAverage(double[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("Массив пуст");

        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    // Перегрузка метода для целых чисел
    public static double calculateAverage(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException("Массив пуст");

        long sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double)sum / array.length;
    }

    // Пузырьковая сортировка массива по возрастанию
    public static void sortAscending(double[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    double temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Перегрузка метода для целых чисел
    public static void sortAscending(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Пузырьковая сортировка массива по убыванию
    public static void sortDescending(double[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    double temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Перегрузка метода для целых чисел
    public static void sortDescending(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Основной метод программы
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.err.println("Ошибка: Размер массива должен быть больше нуля.");
            return;
        }

        System.out.println("Минимальное число диапазона: ");
        double minVal = scanner.nextDouble(); // Для целых используется nextInt()

        System.out.println("Максимальное число диапазона: ");
        double maxVal = scanner.nextDouble(); // Для целых используется nextInt()

        // Генерируем массивы
        int[] randomInts = generateRandomIntArray(size, (int)Math.ceil(minVal), (int)Math.floor(maxVal));
        double[] randomDouble = generateRandomDoubleArray(size, (int)Math.ceil(minVal), (int)Math.floor(maxVal));



        System.out.println("Работа с целыми значениями:");
        System.out.println("Максимальное значение: " + findMax(randomInts));
        System.out.println("Минимальное значение: " + findMin(randomInts));
        System.out.println("Среднее значение: " + calculateAverage(randomInts));

        // Сортируем массивы
        System.out.println("Исходный массив с целыми числами");
        System.out.println(Arrays.toString(randomInts));

        sortDescending(randomInts);   // По убыванию
        System.out.println("По убыванию");
        System.out.println(Arrays.toString(randomInts));

        sortAscending(randomInts);   // По возрастанию
        System.out.println("По возрастанию");
        System.out.println(Arrays.toString(randomInts));

        System.out.println("_______________________________");
        System.out.println("Работа с дробными значениями:");
        System.out.println("Максимальное значение: " + findMax(randomDouble));
        System.out.println("Минимальное значение: " + findMin(randomDouble));
        System.out.println("Среднее значение: " + calculateAverage(randomDouble));

        // Сортируем массивы
        System.out.println("Исходный массив с целыми числами");
        System.out.println(Arrays.toString(randomDouble));

        sortDescending(randomDouble);   // По убыванию
        System.out.println("По убыванию");
        System.out.println(Arrays.toString(randomDouble));

        sortAscending(randomDouble);   // По возрастанию
        System.out.println("По возрастанию");
        System.out.println(Arrays.toString(randomDouble));

        scanner.close();
    }
}