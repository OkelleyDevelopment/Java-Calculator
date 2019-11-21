import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class CalculatorUI extends JFrame{

    JFrame window;
    JPanel buttonPanel;
    JTextField textField1;

    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSubtract, bDivide, bMultiply, bClr, bPlusMinus, bPercent, bDecimal;
    JButton bEquals, blank3;

    Font bigNum = new Font("Times New Roman", Font.BOLD, 30);
    Font textFieldFont = new Font("Times New Roman", Font.BOLD, 40);

    DecimalFormat form = new DecimalFormat("#.#");
    //THis is bad because it messes with the larger numbers.



    public void createdUI(){


        window = new JFrame("Java Calculator");
        window.setSize(700, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

        textField1= new JTextField(16);
        textField1.setBounds(35, 75, 600, 100);
        textField1.setFont(textFieldFont);
        textField1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField1.setEditable(false);
        textField1.setText(""+ 0);

        //textField2 = new JTextField(16);
        //textField2.setBounds(35, 75, 400, 100);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(35, 210, 600, 480);
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.setLayout(new GridLayout(5, 4));

        ListenForButton listenForButton = new ListenForButton();

        bClr = new JButton("AC");
        bClr.setFont(bigNum);
        bClr.addActionListener(listenForButton);
        bClr.setActionCommand("AC");
        buttonPanel.add(bClr);

        bPlusMinus= new JButton("+/-");
        bPlusMinus.addActionListener(listenForButton);
        bPlusMinus.setActionCommand("PlusMinus");
        bPlusMinus.setFont(bigNum);
        buttonPanel.add(bPlusMinus);

        bPercent = new JButton("%");
        bPercent.addActionListener(listenForButton);
        bPercent.setActionCommand("percent");
        bPercent.setFont(bigNum);
        buttonPanel.add(bPercent);

        bDivide = new JButton("/");
        bDivide.setFont(bigNum);
        bDivide.setBackground(Color.orange);
        bDivide.addActionListener(listenForButton);
        bDivide.setActionCommand("/");
        buttonPanel.add(bDivide);


        b7 = new JButton("7");
        b7.setFont(bigNum);
        b7.addActionListener(listenForButton);
        b7.setActionCommand("7");
        buttonPanel.add(b7);

        b8 = new JButton("8");
        b8.addActionListener(listenForButton);
        b8.setActionCommand("8");
        b8.setFont(bigNum);
        buttonPanel.add(b8);

        b9 = new JButton("9");
        b9.setFont(bigNum);
        b9.addActionListener(listenForButton);
        b9.setActionCommand("9");
        buttonPanel.add(b9);

        bMultiply = new JButton("*");
        bMultiply.setFont(bigNum);
        bMultiply.setBackground(Color.orange);
        bMultiply.addActionListener(listenForButton);
        bMultiply.setActionCommand("*");
        buttonPanel.add(bMultiply);


        b4 = new JButton("4");
        b4.setFont(bigNum);
        b4.addActionListener(listenForButton);
        b4.setActionCommand("4");
        buttonPanel.add(b4);

        b5 = new JButton("5");
        b5.setFont(bigNum);
        b5.addActionListener(listenForButton);
        b5.setActionCommand("5");
        buttonPanel.add(b5);

        b6 = new JButton("6");
        b6.setFont(bigNum);
        b6.addActionListener(listenForButton);
        b6.setActionCommand("6");
        buttonPanel.add(b6);

        bSubtract = new JButton("-");
        bSubtract.setFont(bigNum);
        bSubtract.setBackground(Color.orange);
        bSubtract.addActionListener(listenForButton);
        bSubtract.setActionCommand("-");
        buttonPanel.add(bSubtract);


        b1 = new JButton("1");
        b1.setFont(bigNum);
        b1.addActionListener(listenForButton);
        b1.setActionCommand("1");
        buttonPanel.add(b1);

        b2 = new JButton("2");
        b2.setFont(bigNum);
        b2.addActionListener(listenForButton);
        b2.setActionCommand("2");
        buttonPanel.add(b2);

        b3 = new JButton("3");
        b3.setFont(bigNum);
        b3.addActionListener(listenForButton);
        b3.setActionCommand("3");
        buttonPanel.add(b3);

        bAdd = new JButton("+");
        bAdd.setFont(bigNum);
        bAdd.setBackground(Color.orange);
        bAdd.addActionListener(listenForButton);
        bAdd.setActionCommand("add");
        buttonPanel.add(bAdd);


        b0 = new JButton("0");
        b0.setFont(bigNum);
        b0.addActionListener(listenForButton);
        b0.setActionCommand("0");
        buttonPanel.add(b0);

        blank3 = new JButton("");
        buttonPanel.add(blank3);

        bDecimal = new JButton(".");
        bDecimal.setFont(bigNum);
        bDecimal.addActionListener(listenForButton);
        bDecimal.setActionCommand("decimal");
        buttonPanel.add(bDecimal);

        bEquals = new JButton("=");
        bEquals.setFont(bigNum);
        bEquals.setBackground(Color.orange);
        bEquals.addActionListener(listenForButton);
        bEquals.setActionCommand("=");
        buttonPanel.add(bEquals);


        window.add(textField1);
        window.add(buttonPanel);
        window.setVisible(true);

    }
    //TODO: Decimal is not working correctly.
    //TODO: The program is acting up. It worked on the 10th and when i reloaded on the 11th to fix the decimal
    //issue, the numbers were not acting like they were the day before and i had not changed any code yet.
    private class ListenForButton implements ActionListener {

    public void clear() {

        try {
            textField1.setText("");
            //Calculator.firstNum = 0;
            //Calculator.secondNum = 0;
            //Calculator.tempVar = "";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void makeOppositeSign(){

        double opposite = Double.parseDouble(textField1.getText());
        clear();
        opposite = opposite * (-1);
        textField1.setText(opposite + "");

    }

    private void percentChange(){

        double num = Double.parseDouble(textField1.getText());
        clear();
        num = num / 100;
        textField1.setText(num + "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Calculator.firstNum = 0;
        //Calculator.secondNum = 0;

        try {


            // This first section handles the button action events.
            if (e.getActionCommand().equals("1")) {
                clear();
                Calculator.tempVar = textField1.getText() + "1";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("2")) {
                clear();
                Calculator.tempVar = textField1.getText() + "2";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("3")) {
                clear();
                Calculator.tempVar = textField1.getText() + "3";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("4")) {
                clear();
                Calculator.tempVar = textField1.getText() + "4";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("5")) {
                clear();
                Calculator.tempVar = textField1.getText() + "5";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("6")) {
                clear();
                Calculator.tempVar = textField1.getText() + "6";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("7")) {
                clear();
                Calculator.tempVar = textField1.getText() + "7";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("8")) {
                clear();
                Calculator.tempVar = textField1.getText() + "8";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("9")) {
                clear();
                Calculator.tempVar = textField1.getText() + "9";
                textField1.setText(Calculator.tempVar);
            }
            else if (e.getActionCommand().equals("0")) {
                clear();
                Calculator.tempVar = textField1.getText() + "0";
                textField1.setText(Calculator.tempVar);
            }

            // Now we can address the operators
            else if (e.getActionCommand().equals("add")) {

                Calculator.firstNum = Double.parseDouble(textField1.getText());
                Calculator.operator = "+";
                //textField1.setText("");
            } else if (e.getActionCommand().equals("-")) {

                Calculator.firstNum = Double.parseDouble(textField1.getText());
                Calculator.operator = "-";
            } else if (e.getActionCommand().equals("*")) {

                Calculator.firstNum = Double.parseDouble(textField1.getText());
                //textField1.setText("");
                Calculator.operator = "*";
            } else if (e.getActionCommand().equals("/")) {

                Calculator.firstNum = Double.parseDouble(textField1.getText());
                //textField1.setText("");
                Calculator.operator = "/";
            } else if (e.getActionCommand().equals("PlusMinus")) {

                makeOppositeSign();

            } else if (e.getActionCommand().equals("decimal")) {

                Calculator.tempVar = textField1.getText() + ".";
                textField1.setText(Calculator.tempVar);

            } else if (e.getActionCommand().equals("percent")) {

                percentChange();

            } else if (e.getActionCommand().equals("AC")) {

                clear();
                textField1.setText("" + 0);

            } else {

                if (Calculator.operator.equals("")) {
                    textField1.setText("" + 0);
                    return;
                } else {

                    Calculator.secondNum = Double.parseDouble(textField1.getText());
                    //Calculator.answer = 0.0;

                    if (Calculator.operator.equals("+")) {
                        //System.out.println(Calculator.firstNum);
                        //System.out.println(Calculator.secondNum);
                        Calculator.answer = Calculator.firstNum + Calculator.secondNum;
                    } else if (Calculator.operator.equals("-")) {
                        Calculator.answer = Calculator.firstNum - Calculator.secondNum;
                    } else if (Calculator.operator.equals("*")) {
                        Calculator.answer = Calculator.firstNum * Calculator.secondNum;
                    } else if (Calculator.operator.equals("/")) {
                        Calculator.answer = Calculator.firstNum / Calculator.secondNum;
                    }


                    textField1.setText("" + Calculator.answer);
                }


            }
        } catch (InputMismatchException error) {
            textField1.setText("Enter Integers only");
        } catch (ArithmeticException error) {
            textField1.setText("Illegal Op.");
        } catch (Exception error) {
            System.out.println("Check and Try again");

            // Left for future debugging
            error.printStackTrace();
        }
    }
}

}
