package com.calculadora.vista;

import com.calculadora.modelo.CalcModel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalcView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    private final JTextField m_userInputTf = new JTextField(5);
    private final JTextField m_totalTf = new JTextField(20);
    private final JButton m_multiplyBtn = new JButton("Multiply");
    private final JButton m_addBtn = new JButton("Add");
    private final JButton m_clearBtn = new JButton("Clear");

    public CalcView(CalcModel model) {
        model.setValue(INITIAL_VALUE);
        m_totalTf.setText(model.getValue());
        m_totalTf.setEditable(false);

        setLayout(new FlowLayout());
        add(new JLabel("Input"));
        add(m_userInputTf);
        add(m_multiplyBtn);
        add(m_addBtn);
        add(new JLabel("Total"));
        add(m_totalTf);
        add(m_clearBtn);

        setTitle("Simple Calc - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public void reset() {
        m_totalTf.setText(INITIAL_VALUE);
        m_userInputTf.setText("");
    }

    public String getUserInput() {
        return m_userInputTf.getText();
    }

    public void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void addMultiplyListener(ActionListener listener) {
        m_multiplyBtn.addActionListener(listener);
        m_userInputTf.addActionListener(listener);
    }

    public void addAddListener(ActionListener listener) {
        m_addBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        m_clearBtn.addActionListener(listener);
    }
}
