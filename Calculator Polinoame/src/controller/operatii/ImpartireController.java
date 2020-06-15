package controller.operatii;

import controller.abstractPackage.AbstractController;
import view.generic.OperatiiCuDouaPolinoame;
import view.generic.PolinomeFrame;
import view.operatii.ImpartireFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImpartireController extends AbstractController {
    public ImpartireController(ImpartireFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        frame.setClearBtnActionListener(new SetClearBtnActionListener());
    }

    private class SetClearBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            OperatiiCuDouaPolinoame.getPolinomText1().setText(null);
            OperatiiCuDouaPolinoame.getPolinomText2().setText(null);
        }
    }
}
