package view.generic;

import view.generic.PolinomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuFrame extends PolinomeFrame {

    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel middlePanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;

    private JLabel topLabel;
    private JLabel operatiiGrad1;
    private JLabel operatiiGrad2;
    private JLabel operatiiGrad3;

    private JButton adunareBtn;
    private JButton scadereBtn;
    private JButton inmultireBtn;
    private JButton impartireBtn;
    private JButton derivareBtn;
    private JButton integrareBtn;
    private JButton exitBtn;

    private Color culoareFundal = new Color(51, 153, 255);

    public MainMenuFrame(String title) {
        super(title);
        contentPanel.setLayout(null);
        contentPanel.setBackground(culoareFundal);

        /*
        *   TOP PANEL
         */

        topPanel = new JPanel();
        topPanel.setBounds(10, 10, 880, 80);
        topPanel.setBackground(culoareFundal);
        topPanel.setLayout(null);
        contentPanel.add(topPanel);

        topLabel = new JLabel("OPERATII POLINOAME");
        topLabel.setVisible(true);
        topLabel.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setBounds(10, 10, 860, 60);
        topPanel.add(topLabel);

        /*
        *   LEFT PANEL
        */

        leftPanel = new JPanel();
        leftPanel.setBackground(culoareFundal);
        leftPanel.setLayout(null);
        leftPanel.setBounds(10, 100, 280, 400);
        contentPanel.add(leftPanel);

        operatiiGrad1 = new JLabel("GRAD 1");
        operatiiGrad1.setBounds(10, 10, 260, 100);
        operatiiGrad1.setHorizontalAlignment(SwingConstants.CENTER);
        operatiiGrad1.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        leftPanel.add(operatiiGrad1);

        adunareBtn = new JButton("Adunare");
        adunareBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        adunareBtn.setBorderPainted(false);
        adunareBtn.setBackground(culoareFundal);
        adunareBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
        adunareBtn.setBounds(40, 120, 200, 30);
        leftPanel.add(adunareBtn);

        scadereBtn = new JButton("Scadere");
        scadereBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        scadereBtn.setBorderPainted(false);
        scadereBtn.setBackground(culoareFundal);
        scadereBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
        scadereBtn.setBounds(40, 210, 200, 30);
        leftPanel.add(scadereBtn);


        /*
        *   MIDDLE PANEL
         */

        middlePanel = new JPanel();
        middlePanel.setBackground(culoareFundal);
        middlePanel.setLayout(null);
        middlePanel.setBounds(310,100, 280, 400);
        contentPanel.add(middlePanel);

        operatiiGrad2 = new JLabel("GRAD 2");
        operatiiGrad2.setBounds(10, 10, 260, 100);
        operatiiGrad2.setHorizontalAlignment(SwingConstants.CENTER);
        operatiiGrad2.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        middlePanel.add(operatiiGrad2);

        inmultireBtn = new JButton("Inmultire");
        inmultireBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        inmultireBtn.setBorderPainted(false);
        inmultireBtn.setBackground(culoareFundal);
        inmultireBtn.setBounds(40, 120, 200, 30);
        inmultireBtn.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        middlePanel.add(inmultireBtn);

        impartireBtn = new JButton("Impartire");
        impartireBtn.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        impartireBtn.setBorderPainted(false);
        impartireBtn.setBounds(40, 210, 200, 30);
        impartireBtn.setBackground(culoareFundal);
        impartireBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        middlePanel.add(impartireBtn);

        /*
        *   RIGHT PANEL
         */

        rightPanel = new JPanel();
        rightPanel.setBackground(culoareFundal);
        rightPanel.setLayout(null);
        rightPanel.setBounds(610, 100, 280, 400);
        contentPanel.add(rightPanel);

        operatiiGrad3 = new JLabel("GRAD 3");
        operatiiGrad3.setBounds(10, 10, 260, 100);
        operatiiGrad3.setHorizontalAlignment(SwingConstants.CENTER);
        operatiiGrad3.setFont(new Font("Times new roman", Font.BOLD | Font.ITALIC, 30));
        rightPanel.add(operatiiGrad3);

        derivareBtn = new JButton("Derivare");
        derivareBtn.setBackground(culoareFundal);
        derivareBtn.setBorderPainted(false);
        derivareBtn.setBounds(40, 120, 200, 30);
        derivareBtn.setFont(new Font("Times new roman", Font.BOLD, 30));
        derivareBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        rightPanel.add(derivareBtn);

        integrareBtn = new JButton("Integrare");
        integrareBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        integrareBtn.setBorderPainted(false);
        integrareBtn.setFont(new Font("Times new roman", Font.BOLD, 30));
        integrareBtn.setBounds(40, 210, 200, 30);
        integrareBtn.setBackground(culoareFundal);
        rightPanel.add(integrareBtn);

        /*
        *   BOTTOM PANEL
         */

        bottomPanel = new JPanel();
        bottomPanel.setBounds(10, 510, 880, 80);
        bottomPanel.setLayout(null);
        bottomPanel.setBackground(culoareFundal);
        contentPanel.add(bottomPanel);

        exitBtn = new JButton("Exit");
        exitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        exitBtn.setBorderPainted(false);
        exitBtn.setBackground(culoareFundal);
        exitBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
        exitBtn.setBounds(340, 10, 200, 30);
        bottomPanel.add(exitBtn);
    }

    public void setAdunareBtnActionListener(ActionListener actionListener) {
        this.adunareBtn.addActionListener(actionListener);
    }

    public void setScadereBtnActionListener(ActionListener actionListener) {
        this.scadereBtn.addActionListener(actionListener);
    }

    public void setInmultireBtnActionListener(ActionListener actionListener) {
        this.inmultireBtn.addActionListener(actionListener);
    }

    public void setImpartireBtnActionListener(ActionListener actionListener) {
        this.impartireBtn.addActionListener(actionListener);
    }

    public void setDerivareBtnActionListener(ActionListener actionListener) {
        this.derivareBtn.addActionListener(actionListener);
    }

    public void setIntegrareBtnActionListener(ActionListener actionListener) {
        this.integrareBtn.addActionListener(actionListener);
    }

    public void setExitBtnActionListener(ActionListener actionListener) {
        this.exitBtn.addActionListener(actionListener);
    }
}
