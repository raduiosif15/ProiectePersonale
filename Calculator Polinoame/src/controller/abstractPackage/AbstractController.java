package controller.abstractPackage;

import view.utilities.FrameStack;
import view.generic.PolinomeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AbstractController {
    protected PolinomeFrame frame;

    public AbstractController(PolinomeFrame frame, boolean hasBackButton) {
        this.frame = frame;
        if (hasBackButton) {
            frame.setBackButtonActionListener(new BackButtonActionListener());
        }
    }

    private class BackButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }
}
