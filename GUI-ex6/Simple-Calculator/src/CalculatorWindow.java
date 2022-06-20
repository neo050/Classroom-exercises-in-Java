

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWindow extends JFrame {
    private double previousNumber = 0;
    private String operation = null;
    private final JTextField tbNumber;

    public CalculatorWindow() {
        super("Primitive Calculator");
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(tbNumber = new JTextField("0"));
        tbNumber.setEditable(false);

        JPanel topRow = new JPanel();
        topRow.setLayout(new BoxLayout(topRow, BoxLayout.LINE_AXIS));
        topRow.add(createButton("Backspace", new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String str = tbNumber.getText().substring(0, tbNumber.getText().length() - 1);
                tbNumber.setText(str.isEmpty() ? "0" : str);
            }
        }));
        topRow.add(Box.createHorizontalGlue());
        topRow.add(createButton("CE", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previousNumber = 0;
                tbNumber.setText("0");
            }
        }));
        topRow.add(createButton("C", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tbNumber.setText("0");
            }
        }));
        this.add(topRow);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4, 5));
        ActionListener digitAdder = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                String text = tbNumber.getText();
                tbNumber.setText((text.equals("0") ? "" : text) + ((JButton)e.getSource()).getText());
            }
        };
        ActionListener arithOP = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcPrevious();
                operation = ((JButton)e.getSource()).getText();
            }
        };
        buttons.add(createButton("7", digitAdder));
        buttons.add(createButton("8", digitAdder));
        buttons.add(createButton("9", digitAdder));
        buttons.add(createButton("/", arithOP));
        buttons.add(createButton("sqrt", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tbNumber.setText(Double.toString(Math.sqrt(Double.parseDouble(tbNumber.getText()))));
            }
        }));
        buttons.add(createButton("4", digitAdder));
        buttons.add(createButton("5", digitAdder));
        buttons.add(createButton("6", digitAdder));
        buttons.add(createButton("*", arithOP));
        buttons.add(createButton("1/x", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tbNumber.setText(Double.toString(1 / Double.parseDouble(tbNumber.getText())));
            }
        }));
        buttons.add(createButton("1", digitAdder));
        buttons.add(createButton("2", digitAdder));
        buttons.add(createButton("3", digitAdder));
        buttons.add(createButton("-", arithOP));
        buttons.add(createButton("%", null));
        buttons.add(createButton("0", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tbNumber.getText();
                if (!text.equals("0"))
                    tbNumber.setText(text + "0");
            }
        }));
        buttons.add(createButton("+/-", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tbNumber.getText();
                tbNumber.setText(text.charAt(0) == '-' ? text.substring(1) : "-" + text);
            }
        }));
        buttons.add(createButton(".", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tbNumber.getText();
                if (!text.contains("."))
                    tbNumber.setText(text + ".");
            }
        }));
        buttons.add(createButton("+", arithOP));
        buttons.add(createButton("=", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcPrevious();
                operation = null;
                tbNumber.setText(Double.toString(previousNumber));
            }
        }));
        this.add(buttons);

        this.pack();
        this.setVisible(true);
    }

    private static JButton createButton(String text, ActionListener react) {
        JButton btn = new JButton(text);
        btn.addActionListener(react);
        return btn;
    }

    private void calcPrevious() {
        double number = Double.parseDouble(tbNumber.getText());
        if (operation == null) {
            previousNumber = number;
        } else
        {
            switch (operation) {
                case "+": previousNumber += number; break;
                case "-": previousNumber -= number; break;
                case "*": previousNumber *= number; break;
                case "/": previousNumber /= number; break;
            }
        }
        tbNumber.setText("0");
    }

    public static void main(String[] args)
    {
        CalculatorWindow window = new CalculatorWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
