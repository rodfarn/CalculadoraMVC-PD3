package com.calculadora;

import com.calculadora.controlador.CalcController;
import com.calculadora.modelo.CalcModel;
import com.calculadora.vista.CalcView;
import javax.swing.SwingUtilities;

public class CalcMVC {
    private CalcMVC() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalcModel model = new CalcModel();
            CalcView view = new CalcView(model);
            new CalcController(model, view);
            view.setVisible(true);
        });
    }
}
