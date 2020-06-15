package controller.main;

import controller.operatii.OperationsController;
import model.Integrate;
import model.Polinom;
import view.generic.MainMenuFrame;
import view.generic.OperatiiCuDouaPolinoame;

public class MainController {
    public static void main(String[] args) {
        new OperationsController(new MainMenuFrame("Operatii polinoame"), false);
    }
}
