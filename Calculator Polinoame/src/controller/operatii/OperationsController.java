package controller.operatii;

import controller.abstractPackage.AbstractController;
import view.generic.OperatiiCuDouaPolinoame;
import view.operatii.*;
import view.generic.MainMenuFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationsController extends AbstractController {
    public OperationsController(MainMenuFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        frame.setAdunareBtnActionListener(new AdunareBtnActionListener());
        frame.setScadereBtnActionListener(new ScadereBtnActionListener());
        frame.setInmultireBtnActionListener(new InmultireBtnActionListener());
        frame.setImpartireBtnActionListener(new ImpartireBtnActionListener());
        frame.setDerivareBtnActionListener(new DerivareBtnActionListener());
        frame.setIntegrareBtnActionListener(new IntegrareBtnActionListener());
        frame.setExitBtnActionListener(new ExitBtnActionListener());
    }

    private class AdunareBtnActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new AdunareController(new AdunareFrame("Adunare"), true);
        }
    }

    private class ScadereBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new ScadereController(new ScadereFrame("Scadere"), true);
        }
    }

    private class InmultireBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new InmultireController(new InmultireFrame("Inmultire"), true);
        }
    }

    private class ImpartireBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new ImpartireController(new ImpartireFrame("Impartire"), true);
            OperatiiCuDouaPolinoame.setRezultat("...............NU FUNCTIONEAZA..................");
        }
    }

    private class DerivareBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new DerivareController(new DerivareFrame("Derivare"), true);
        }
    }

    private class IntegrareBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new IntegrareController(new IntegrareFrame("Integrare"), true);
        }
    }

    private class ExitBtnActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }
}
