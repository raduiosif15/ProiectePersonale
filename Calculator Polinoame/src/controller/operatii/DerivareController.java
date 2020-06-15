package controller.operatii;

import controller.abstractPackage.AbstractController;
import model.Polinom;
import view.generic.OperatiiCuDouaPolinoame;
import view.generic.OperatiiCuUnPolinom;
import view.generic.PolinomeFrame;
import view.operatii.DerivareFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DerivareController extends AbstractController {
    public DerivareController(DerivareFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        frame.setClearBtnActionListener(new SetClearBtnActionListener());
        frame.setSubmitBtnActionListener(new SetSubmitBtnActionListener());
    }

    private class SetClearBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            OperatiiCuUnPolinom.getPolinomText().setText(null);
        }
    }

    private class SetSubmitBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String polinomString = OperatiiCuUnPolinom.getPolinomText().getText();
            Polinom polinom = new Polinom();
            polinom.crearePolinom(polinomString);
            polinom.derivare();
            OperatiiCuUnPolinom.setRezultat(polinom.polinomToString());
        }
    }
}
