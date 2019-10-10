package ru.job4j.calculator;

/**
 * Класс для вычисления арифметических функций.
 *
 * @author Vitaly Gilev (vitvit1@yandex.ru)
 * @version 1
 * @since 10.10.2019
 */
public class Calculator {

    /**
     * Сложение
     * @param first первое слагаемое
     * @param second  второе слагаемое
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * Деление
     * @param first делимое
     * @param second  делитель
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * Умножение
     * @param first первый сомножитель
     * @param second  второй сомножитель
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    /**
     * Вычитание
     * @param first уменьшаемое
     * @param second  вычитаемое
     */
    public static void subtract(double first, double second) {
        double result =  first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * Запуск калькулятора
     * @param args параметры
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }

}
