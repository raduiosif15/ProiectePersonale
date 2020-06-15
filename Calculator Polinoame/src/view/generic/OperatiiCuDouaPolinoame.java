package view.generic;

import view.generic.PolinomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OperatiiCuDouaPolinoame extends PolinomeFrame {

    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel submitPanel;

    private JLabel topLabel;
    private JLabel polinom1;
    private JLabel polinom2;
    private static JLabel rezultat;

    private static JTextField polinomText1;
    private static JTextField polinomText2;

    private JButton submitBtn;
    private JButton clearBtn;

    private Color culoareFundal = new Color(51, 153, 255);
    private Font fontText = new Font("Times new roman", Font.BOLD, 20);

    public OperatiiCuDouaPolinoame(String title) {
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
        leftPanel.setBounds(10, 110, 120, 180);
        leftPanel.setLayout(null);
        contentPanel.add(leftPanel);

        polinom1 = new JLabel("P(X) = ");
        polinom1.setBounds(10, 20, 100, 40);
        polinom1.setHorizontalAlignment(SwingConstants.CENTER);
        polinom1.setFont(fontText);
        leftPanel.add(polinom1);

        polinom2 = new JLabel("Q(X) = ");
        polinom2.setHorizontalAlignment(SwingConstants.CENTER);
        polinom2.setFont(fontText);
        polinom2.setBounds(10, 110, 100, 40);
        leftPanel.add(polinom2);

        /*
         *   RIGHT  PANEL
         */

        rightPanel = new JPanel();
        rightPanel.setBackground(culoareFundal);
        rightPanel.setLayout(null);
        rightPanel.setBounds(140, 110, 740, 180);
        contentPanel.add(rightPanel);

        polinomText1 = new JTextField();
        polinomText1.setBackground(culoareFundal);
        polinomText1.setFont(fontText);
        polinomText1.setBounds(10, 20, 720, 40);
        rightPanel.add(polinomText1);

        polinomText2 = new JTextField();
        polinomText2.setBounds(10, 110, 720, 40);
        polinomText2.setFont(fontText);
        polinomText2.setBackground(culoareFundal);
        rightPanel.add(polinomText2);

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

        rezultat = new JLabel("...........................................................................");
        rezultat.setBounds(250, 35, 600, 30);
        rezultat.setFont(fontText);
        submitPanel.add(rezultat);
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

    public static JTextField getPolinomText1() {
        return polinomText1;
    }

    public static JTextField getPolinomText2() {
        return polinomText2;
    }
}
