package controller.operatii;

import controller.abstractPackage.AbstractController;
import model.Polinom;
import view.generic.OperatiiCuDouaPolinoame;
import view.operatii.AdunareFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdunareController extends AbstractController {

    public AdunareController(AdunareFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        frame.setClearBtnActionListener(new SetClearBtnActionListener());
        frame.setSubmitBtnActionListener(new SetSubmitBtnActionListener());
    }

    private class SetClearBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            OperatiiCuDouaPolinoame.getPolinomText1().setText(null);
            OperatiiCuDouaPolinoame.getPolinomText2().setText(null);
        }
    }

    private class SetSubmitBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String polinomString1 = OperatiiCuDouaPolinoame.getPolinomText1().getText();
            String polinomString2 = OperatiiCuDouaPolinoame.getPolinomText2().getText();
            Polinom polinom1 = new Polinom();
            Polinom polinom2 = new Polinom();
            polinom1.crearePolinom(polinomString1);
            polinom2.crearePolinom(polinomString2);
            polinom1.adunare(polinom2);
            OperatiiCuDouaPolinoame.setRezultat(polinom1.polinomToString());
        }
    }
}