package com.calculadora.controlador;

import com.calculadora.modelo.CalcModel;
import com.calculadora.vista.CalcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private final CalcModel m_model;
    private final CalcView m_view;

    public CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view = view;

        m_view.addMultiplyListener(new MultiplyListener());
        m_view.addAddListener(new AddListener());
        m_view.addClearListener(new ClearListener());
    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.add(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException error) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput);
                m_view.setTotal(m_model.getValue());
            } catch (NumberFormatException error) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            m_model.reset();
            m_view.reset();
        }
    }
}
