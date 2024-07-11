package B2_P1_Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculadora {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton sumaButton;
    private JButton multiplicacionButton;
    private JButton divisionButton;
    private JButton restaButton;

    public Calculadora() {

        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 + num2;

                JOptionPane.showMessageDialog(panel1, "La suma es: " + result);
            }
        });

        restaButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 - num2;
                JOptionPane.showMessageDialog(panel1, "La resta es: " + result);
            }
        });

        multiplicacionButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double result = num1 * num2;
                JOptionPane.showMessageDialog(panel1, "La multiplicación es: " + result);
            }
        });

        divisionButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                if (num2 != 0) {
                    double result = num1 / num2;
                    JOptionPane.showMessageDialog(panel1, "La división es: " + result);
                } else {
                    JOptionPane.showMessageDialog(panel1, "Error: División por cero");
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Calculadora().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //se ajusta al tamaño de la interfaz
        frame.setVisible(true);

    }

}