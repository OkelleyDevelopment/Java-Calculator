
/**
 * This program models a simple calculator.
 *
 * August 1 - August 12
 * @author Nicholas O'Kelley
 */


public class Calculator {

    public static double firstNum;
    public static double secondNum;
    public static double answer;

    public static String operator, tempVar;

    //public static CalculatorUI UI = new CalculatorUI();


    public Calculator(){

        this.firstNum = 0;
        this.secondNum = 0;
        this.answer = 0;

        new CalculatorUI().createdUI();

    }


    public static void main(String[] args) {

        new Calculator();
    }
}
