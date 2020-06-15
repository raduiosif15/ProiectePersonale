package view.generic;

import model.PolinomeFrame_I;
import view.utilities.FrameStack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PolinomeFrame extends JFrame implements PolinomeFrame_I {

    protected JPanel contentPanel;
    private Color culoareFundal = new Color(51, 153, 255);

    public PolinomeFrame(String title) {
        FrameStack.getInstance().push(this);
        setTitle(title);
        setSize(900, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setBackground(culoareFundal);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void setBackButtonActionListener(ActionListener actionListener) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(culoareFundal);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.setBackground(culoareFundal);
        backButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backButton.setBorderPainted(false);
        backButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        buttonPanel.add(backButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
        backButton.addActionListener(actionListener);
    }


    @Override
    public void goBack() {

    }
}
