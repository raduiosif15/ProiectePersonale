package view.generic;

import view.generic.PolinomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OperatiiCuUnPolinom extends PolinomeFrame {
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel submitPanel;

    private JLabel topLabel;
    private JLabel polinom;
    private static JLabel rezultat;

    private static JTextField polinomText;

    private JButton submitBtn;
    private JButton clearBtn;

    private Color culoareFundal = new Color(51, 153, 255);
    private Font fontText = new Font("Times new roman", Font.BOLD, 20);

    public OperatiiCuUnPolinom(String title) {
        super(title);
        contentPanel.setLayout(null);

        /*
         *   TOP  PANEL
         */

        topPanel = new JPanel();
        topPanel.setBounds(10, 10, 880, 80);
        topPanel.setBackground(culoareFundal);
        topPanel.setLayout(null);
        contentPanel.add(topPanel);

        topLabel = new JLabel(title.toUpperCase());
        topLabel.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setBounds(10, 10, 860, 60);
        topPanel.add(topLabel);

        /*
         *   LEFT  PANEL
         */

        leftPanel = new JPanel();
        leftPanel.setBackground(culoareFundal);
        leftPanel.setBounds(10, 110, 100, 180);
        leftPanel.setLayout(null);
        contentPanel.add(leftPanel);

        polinom = new JLabel("P(X) = ");
        polinom.setBounds(10, 20, 80, 40);
        polinom.setHorizontalAlignment(SwingConstants.CENTER);
        polinom.setFont(fontText);
        leftPanel.add(polinom);

        /*
         *   RIGHT  PANEL
         */

        rightPanel = new JPanel();
        rightPanel.setBackground(culoareFundal);
        rightPanel.setLayout(null);
        rightPanel.setBounds(120, 110, 760, 180);
        contentPanel.add(rightPanel);

        polinomText = new JTextField();
        polinomText.setBackground(culoareFundal);
        polinomText.setFont(fontText);
        polinomText.setBounds(10, 20, 740, 40);
        rightPanel.add(polinomText);

        /*
         *   SUBMIT  PANEL
         */

        submitPanel = new JPanel();
        submitPanel.setBackground(culoareFundal);
        submitPanel.setLayout(null);
        submitPanel.setBounds(10, 320, 880, 150);
        contentPanel.add(submitPanel);

        submitBtn = new JButton("Calculeaza");
        submitBtn.setBackground(culoareFundal);
        submitBtn.setBounds(10, 35, 200, 30);
        submitBtn.setFont(fontText);
        submitBtn.setBorderPainted(false);
        submitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        submitPanel.add(submitBtn);

        clearBtn = new JButton("Sterge");
        clearBtn.setBackground(culoareFundal);
        clearBtn.setBounds(10, 80, 200, 30);
        clearBtn.setBorderPainted(false);
        clearBtn.setFont(fontText);
        clearBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        submitPanel.add(clearBtn);

        rezultat = new JLabel(".......................................................................");
        rezultat.setBounds(250, 35, 600, 30);
        rezultat.setFont(fontText);
        submitPanel.add(rezultat);
    }

    public String getPolinomInput() {
        return polinom.getText();
    }

    public static JTextField getPolinomText() {
        return polinomText;
    }

    public void setSubmitBtnActionListener(ActionListener actionListener) {
        this.submitBtn.addActionListener(actionListener);
    }

    public void setClearBtnActionListener(ActionListener actionListener) {
        this.clearBtn.addActionListener(actionListener);
    }

    public static void setRezultat(String text) {
        rezultat.setText(text);
    }

    public void setPolinomText(String text) {
        this.polinomText.setText(text);
    }
}
