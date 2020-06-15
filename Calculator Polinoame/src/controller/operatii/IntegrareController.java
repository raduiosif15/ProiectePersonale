package controller.operatii;

import controller.abstractPackage.AbstractController;
import model.Integrate;
import model.Polinom;
import view.generic.OperatiiCuDouaPolinoame;
import view.generic.OperatiiCuUnPolinom;
import view.generic.PolinomeFrame;
import view.operatii.IntegrareFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegrareController extends AbstractController {
    public IntegrareController(IntegrareFrame frame, boolean hasBackButton) {
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
            Integrate polinom = new Integrate();
            polinom.crearePolinom(polinomString);
            polinom.integrare();
            OperatiiCuUnPolinom.setRezultat(polinom.polinomToString());
        }
    }
}
