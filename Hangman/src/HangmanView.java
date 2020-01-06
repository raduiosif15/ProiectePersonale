import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class HangmanView extends JFrame {

    protected JPanel contentPane;

    private static JTextField litera1;
    private static JTextField litera2;
    private static JTextField litera3;
    private static JTextField litera4;
    private static JTextField litera5;
    private static JTextField litera6;
    private static JTextField litera7;
    private static JTextField litera8;
    private static JTextField litera9;
    private static JTextField litera10;

    private JButton generareCuvant = new JButton("START");

    private JButton A = new JButton("A");
    private JButton B = new JButton("B");
    private JButton C = new JButton("C");
    private JButton D = new JButton("D");
    private JButton E = new JButton("E");
    private JButton F = new JButton("F");
    private JButton G = new JButton("G");
    private JButton H = new JButton("H");
    private JButton I = new JButton("I");
    private JButton J = new JButton("J");
    private JButton K = new JButton("K");
    private JButton L = new JButton("L");
    private JButton M = new JButton("M");
    private JButton N = new JButton("N");
    private JButton O = new JButton("O");
    private JButton P = new JButton("P");
    private JButton Q = new JButton("Q");
    private JButton R = new JButton("R");
    private JButton S = new JButton("S");
    private JButton T = new JButton("T");
    private JButton U = new JButton("U");
    private JButton V = new JButton("V");
    private JButton W = new JButton("W");
    private JButton X = new JButton("X");
    private JButton Y = new JButton("Y");
    private JButton Z = new JButton("Z");

    private static JTextField statusText;

    private JButton cap = new JButton("");
    private JButton trunchi = new JButton("");
    private JButton piciorStang = new JButton("");
    private JButton piciorDrept = new JButton("");
    private JButton maini = new JButton("");

    private JTextField nrVictorii = new JTextField();
    private JTextField nrPierderi = new JTextField();

    private String cuvant = "";
    private int litereBune = 0;
    private int litereCuvant = 0;
    private int countMistakes = 0;
    private int nrJocuriPierdute = 0;
    private int nrJocuriCastigate = 0;

    public HangmanView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 480);
        contentPane = new JPanel();
        contentPane.setBackground(Color.CYAN);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        add(contentPane, BorderLayout.CENTER);

        JPanel hangman1 = new JPanel();
        hangman1.setBackground(Color.CYAN);
        hangman1.setBounds(10, 11, 290, 244);
        contentPane.add(hangman1);
        hangman1.setLayout(null);

        JButton baza = new JButton("");
        baza.setBorder(null);
        baza.setBackground(Color.BLACK);
        baza.setBounds(10, 210, 89, 23);
        hangman1.add(baza);

        JButton stalp = new JButton("");
        stalp.setBorder(null);
        stalp.setBackground(Color.BLACK);
        stalp.setBounds(38, 24, 25, 187);
        hangman1.add(stalp);

        JButton ramura = new JButton("");
        ramura.setBorder(null);
        ramura.setBackground(Color.BLACK);
        ramura.setBounds(57, 24, 109, 23);
        hangman1.add(ramura);

        JButton sfoara = new JButton("");
        sfoara.setBorder(null);
        sfoara.setBackground(Color.BLACK);
        sfoara.setBounds(148, 44, 18, 38);
        hangman1.add(sfoara);

        cap.setBackground(Color.CYAN);
        cap.setBounds(131, 81, 52, 38);
        cap.setBorder(new RoundedBorder(60));
        cap.setBorderPainted(false);
        hangman1.add(cap);

        trunchi.setBorder(null);
        trunchi.setBackground(Color.CYAN);
        trunchi.setBounds(148, 118, 18, 63);
        hangman1.add(trunchi);

        piciorStang.setBorder(null);
        piciorStang.setBackground(Color.CYAN);
        piciorStang.setBounds(133, 174, 21, 23);
        hangman1.add(piciorStang);

        piciorDrept.setBorder(null);
        piciorDrept.setBackground(Color.CYAN);
        piciorDrept.setBounds(158, 174, 21, 23);
        hangman1.add(piciorDrept);

        maini.setBorder(null);
        maini.setBackground(Color.CYAN);
        maini.setBounds(113, 123, 89, 23);
        hangman1.add(maini);

        JPanel cuvantDeGhicit = new JPanel();
        cuvantDeGhicit.setBackground(Color.CYAN);
        cuvantDeGhicit.setBounds(310, 11, 364, 244);
        contentPane.add(cuvantDeGhicit);
        cuvantDeGhicit.setLayout(null);

        litera1 = new JTextField();
        litera1.setBorder(null);
        litera1.setBackground(Color.CYAN);
        litera1.setBounds(10, 113, 26, 29);
        cuvantDeGhicit.add(litera1);
        litera1.setColumns(10);

        litera2 = new JTextField();
        litera2.setBorder(null);
        litera2.setColumns(10);
        litera2.setBackground(Color.CYAN);
        litera2.setBounds(46, 113, 26, 29);
        cuvantDeGhicit.add(litera2);

        litera3 = new JTextField();
        litera3.setBorder(null);
        litera3.setColumns(10);
        litera3.setBackground(Color.CYAN);
        litera3.setBounds(82, 113, 26, 29);
        cuvantDeGhicit.add(litera3);

        litera4 = new JTextField();
        litera4.setBorder(null);
        litera4.setColumns(10);
        litera4.setBackground(Color.CYAN);
        litera4.setBounds(118, 113, 26, 29);
        cuvantDeGhicit.add(litera4);

        litera5 = new JTextField();
        litera5.setBorder(null);
        litera5.setColumns(10);
        litera5.setBackground(Color.CYAN);
        litera5.setBounds(154, 113, 26, 29);
        cuvantDeGhicit.add(litera5);

        litera6 = new JTextField();
        litera6.setBorder(null);
        litera6.setColumns(10);
        litera6.setBackground(Color.CYAN);
        litera6.setBounds(191, 113, 26, 29);
        cuvantDeGhicit.add(litera6);

        litera7 = new JTextField();
        litera7.setBorder(null);
        litera7.setColumns(10);
        litera7.setBackground(Color.CYAN);
        litera7.setBounds(227, 113, 26, 29);
        cuvantDeGhicit.add(litera7);

        litera8 = new JTextField();
        litera8.setBorder(null);
        litera8.setColumns(10);
        litera8.setBackground(Color.CYAN);
        litera8.setBounds(263, 113, 26, 29);
        cuvantDeGhicit.add(litera8);

        litera9 = new JTextField();
        litera9.setBorder(null);
        litera9.setColumns(10);
        litera9.setBackground(Color.CYAN);
        litera9.setBounds(299, 113, 26, 29);
        cuvantDeGhicit.add(litera9);

        litera10 = new JTextField();
        litera10.setBorder(null);
        litera10.setColumns(10);
        litera10.setBackground(Color.CYAN);
        litera10.setBounds(335, 113, 26, 29);
        cuvantDeGhicit.add(litera10);

        generareCuvant.setForeground(Color.BLACK);
        generareCuvant.setBackground(Color.RED);
        generareCuvant.setBounds(118, 169, 135, 29);
        cuvantDeGhicit.add(generareCuvant);

        generareCuvant.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 0; i < 10; i++){
                    HangmanView.setLitera(i + 1, ' ');
                }
                countMistakes = 0;
                setStartCuloareStickman();
                litereBune = 0;
                String[] cuvantPosibil = new String[] {"PAT", "JUDET", "TARA", "LAPTOP", "PLAPUMA", "TRICOU",
                "PROSOP", "VALIZA", "GEAMANTAN", "PAPUCI", "GHIOZDAN", "MANCARE", "PORTOCALE", "RESTAURANT", "CARTE",
                "COMUNISM", "CONTINENT", "APARTAMENT", "IMOBILIARE", "PARINTI", "CAMASA", "GEACA", "DULAP", "BIROU",
                "MASINA", "ARTA", "CULOARE", "VIATA", "USA", "LICEU"};
                Random rand = new Random();
                int indexRandom = rand.nextInt(30);
                cuvant = cuvantPosibil[indexRandom];
                int m = cuvant.length();
                litereCuvant = m;
                for (int i = 0; i < m; i++) {
                    HangmanView.setLitera(i + 1, '_');
                }

                generareCuvant.setText("RESTART");
                setStatusText("");

                A.setBackground(new Color(255, 170, 128));
                B.setBackground(new Color(255, 170, 128));
                C.setBackground(new Color(255, 170, 128));
                D.setBackground(new Color(255, 170, 128));
                E.setBackground(new Color(255, 170, 128));
                F.setBackground(new Color(255, 170, 128));
                G.setBackground(new Color(255, 170, 128));
                H.setBackground(new Color(255, 170, 128));
                I.setBackground(new Color(255, 170, 128));
                J.setBackground(new Color(255, 170, 128));
                K.setBackground(new Color(255, 170, 128));
                L.setBackground(new Color(255, 170, 128));
                M.setBackground(new Color(255, 170, 128));
                N.setBackground(new Color(255, 170, 128));
                O.setBackground(new Color(255, 170, 128));
                P.setBackground(new Color(255, 170, 128));
                Q.setBackground(new Color(255, 170, 128));
                R.setBackground(new Color(255, 170, 128));
                S.setBackground(new Color(255, 170, 128));
                T.setBackground(new Color(255, 170, 128));
                U.setBackground(new Color(255, 170, 128));
                V.setBackground(new Color(255, 170, 128));
                W.setBackground(new Color(255, 170, 128));
                X.setBackground(new Color(255, 170, 128));
                Y.setBackground(new Color(255, 170, 128));
                Z.setBackground(new Color(255, 170, 128));
            }
        });

        JPanel litere = new JPanel();
        litere.setBackground(Color.CYAN);
        litere.setBounds(10, 278, 664, 126);
        contentPane.add(litere);
        litere.setLayout(null);

        Q.setBounds(10, 10, 52, 32);
        Q.setBackground(Color.CYAN);
        Q.setBorderPainted(false);
        Q.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Q.getBackground().equals(new Color(255, 170, 128))){
                    Q.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'Q'){
                            setLitera(i + 1, 'Q');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;
                        if (litereBune == litereCuvant){
                            setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii();
                            colorareLitere();
                        }
                    }
                }
            }
        });
        litere.add(Q);

        W.setBounds(65, 10, 52, 32);
        W.setBackground(Color.CYAN);
        W.setBorderPainted(false);
        W.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (W.getBackground().equals(new Color(255, 170, 128))) {
                    W.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'W'){
                            setLitera(i + 1, 'W');
                            setCuvantDeAfisat(i + 1, 'W');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;
                        if (litereBune == litereCuvant){
                            setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii();
                            colorareLitere();
                        }
                    }
                }
            }
        });
        litere.add(W);

        E.setBounds(120, 10, 52, 32);
        E.setBackground(Color.CYAN);
        E.setBorderPainted(false);
        E.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (E.getBackground().equals(new Color(255, 170, 128))){
                    E.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'E'){
                            setLitera(i + 1, 'E');
                            setCuvantDeAfisat(i + 1, 'E');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(E);

        R.setBounds(175, 10, 52, 32);
        R.setBackground(Color.CYAN);
        R.setBorderPainted(false);
        R.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (R.getBackground().equals(new Color(255, 170, 128))){
                    R.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'R'){
                            setLitera(i + 1, 'R');
                            setCuvantDeAfisat(i + 1, 'R');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(R);

        T.setBounds(230, 10, 52, 32);
        T.setBackground(Color.CYAN);
        T.setBorderPainted(false);
        T.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (T.getBackground().equals(new Color(255, 170, 128))){
                    T.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'T'){
                            setLitera(i + 1, 'T');
                            setCuvantDeAfisat(i + 1, 'T');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(T);

        Y.setBounds(285, 10, 52, 32);
        Y.setBackground(Color.CYAN);
        Y.setBorderPainted(false);
        Y.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Y.getBackground().equals(new Color(255, 170, 128))){
                    Y.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'Y'){
                            setLitera(i + 1, 'Y');

                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(Y);

        U.setBounds(340, 10, 52, 32);
        U.setBackground(Color.CYAN);
        U.setBorderPainted(false);
        U.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (U.getBackground().equals(new Color(255, 170, 128))){
                    U.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'U'){
                            setLitera(i + 1, 'U');
                            setCuvantDeAfisat(i + 1, 'U');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(U);

        I.setBounds(395, 10, 52, 32);
        I.setBackground(Color.CYAN);
        I.setBorderPainted(false);
        I.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (I.getBackground().equals(new Color(255, 170, 128))){
                    I.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'I'){
                            setLitera(i + 1, 'I');
                            setCuvantDeAfisat(i + 1, 'I');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(I);

        O.setBounds(450, 10, 52, 32);
        O.setBackground(Color.CYAN);
        O.setBorderPainted(false);
        O.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (O.getBackground().equals(new Color(255, 170, 128))){
                    O.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'O'){
                            setLitera(i + 1, 'O');
                            setCuvantDeAfisat(i + 1, 'O');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(O);

        P.setBounds(505, 10, 52, 32);
        P.setBackground(Color.CYAN);
        P.setBorderPainted(false);
        P.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (P.getBackground().equals(new Color(255, 170, 128))){
                    P.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'P'){
                            setLitera(i + 1, 'P');
                            setCuvantDeAfisat(i + 1, 'P');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(P);

        A.setBounds(20, 45, 52, 32);
        A.setBackground(Color.CYAN);
        A.setBorderPainted(false);
        A.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (A.getBackground().equals(new Color(255, 170, 128))){
                    A.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'A'){
                            setLitera(i + 1, 'A');
                            setCuvantDeAfisat(i + 1, 'A');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(A);

        S.setBounds(75, 45, 52, 32);
        S.setBackground(Color.CYAN);
        S.setBorderPainted(false);
        S.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (S.getBackground().equals(new Color(255, 170, 128))){
                    S.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'S'){
                            setLitera(i + 1, 'S');
                            setCuvantDeAfisat(i + 1, 'S');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(S);

        D.setBounds(130, 45, 52, 32);
        D.setBackground(Color.CYAN);
        D.setBorderPainted(false);
        D.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (D.getBackground().equals(new Color(255, 170, 128))){
                    D.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'D'){
                            setLitera(i + 1, 'D');
                            setCuvantDeAfisat(i + 1, 'D');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(D);

        F.setBounds(185, 45, 52, 32);
        F.setBackground(Color.CYAN);
        F.setBorderPainted(false);
        F.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (F.getBackground().equals(new Color(255, 170, 128))){
                    F.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'F'){
                            setLitera(i + 1, 'F');
                            setCuvantDeAfisat(i + 1, 'F');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(F);

        G.setBounds(240, 45, 52, 32);
        G.setBackground(Color.CYAN);
        G.setBorderPainted(false);
        G.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (G.getBackground().equals(new Color(255, 170, 128))){
                    G.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'G'){
                            setLitera(i + 1, 'G');
                            setCuvantDeAfisat(i + 1, 'G');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(G);

        H.setBounds(295, 45, 52, 32);
        H.setBackground(Color.CYAN);
        H.setBorderPainted(false);
        H.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (H.getBackground().equals(new Color(255, 170, 128))){
                    H.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'H'){
                            setLitera(i + 1, 'H');
                            setCuvantDeAfisat(i + 1, 'H');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(H);

        J.setBounds(350, 45, 52, 32);
        J.setBackground(Color.CYAN);
        J.setBorderPainted(false);
        J.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (J.getBackground().equals(new Color(255, 170, 128))){
                    J.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'J'){
                            setLitera(i + 1, 'J');
                            setCuvantDeAfisat(i + 1, 'J');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(J);

        K.setBounds(405, 45, 52, 32);
        K.setBackground(Color.CYAN);
        K.setBorderPainted(false);
        K.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (K.getBackground().equals(new Color(255, 170, 128))){
                    K.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'K'){
                            setLitera(i + 1, 'K');
                            setCuvantDeAfisat(i + 1, 'K');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(K);

        L.setBounds(460, 45, 52, 32);
        L.setBackground(Color.CYAN);
        L.setBorderPainted(false);
        L.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (L.getBackground().equals(new Color(255, 170, 128))){
                    L.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'L'){
                            setLitera(i + 1, 'L');
                            setCuvantDeAfisat(i + 1, 'L');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(L);

        Z.setBounds(40, 80, 52, 32);
        Z.setBackground(Color.CYAN);
        Z.setBorderPainted(false);
        Z.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Z.getBackground().equals(new Color(255, 170, 128))){
                    Z.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'Z'){
                            setLitera(i + 1, 'Z');
                            setCuvantDeAfisat(i + 1, 'Z');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(Z);

        X.setBounds(95, 80, 52, 32);
        X.setBackground(Color.CYAN);
        X.setBorderPainted(false);
        X.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (X.getBackground().equals(new Color(255, 170, 128))){
                    X.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'X'){
                            setLitera(i + 1, 'X');
                            setCuvantDeAfisat(i + 1, 'X');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(X);

        C.setBounds(150, 80, 52, 32);
        C.setBackground(Color.CYAN);
        C.setBorderPainted(false);
        C.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (C.getBackground().equals(new Color(255, 170, 128))){
                    C.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'C'){
                            setLitera(i + 1, 'C');
                            setCuvantDeAfisat(i + 1, 'C');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(C);

        V.setBounds(205, 80, 52, 32);
        V.setBackground(Color.CYAN);
        V.setBorderPainted(false);
        V.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (V.getBackground().equals(new Color(255, 170, 128))){
                    V.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'V'){
                            setLitera(i + 1, 'V');
                            setCuvantDeAfisat(i + 1, 'V');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(V);

        B.setBounds(260, 80, 52, 32);
        B.setBackground(Color.CYAN);
        B.setBorderPainted(false);
        B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (B.getBackground().equals(new Color(255, 170, 128))){
                    B.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'B'){
                            setLitera(i + 1, 'B');
                            setCuvantDeAfisat(i + 1, 'B');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(B);

        N.setBounds(315, 80, 52, 32);
        N.setBackground(Color.CYAN);
        N.setBorderPainted(false);
        N.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (N.getBackground().equals(new Color(255, 170, 128))){
                    N.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'N'){
                            setLitera(i + 1, 'N');
                            setCuvantDeAfisat(i + 1, 'N');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){
                            setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii();
                            colorareLitere();
                            nrJocuriCastigate++; setNrVictorii();
                        }
                    }
                }
            }
        });
        litere.add(N);

        M.setBounds(370, 80, 52, 32);
        M.setBackground(Color.CYAN);
        M.setBorderPainted(false);
        M.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (M.getBackground().equals(new Color(255, 170, 128))){
                    M.setBackground(Color.CYAN);
                    int count = 0;
                    for (int i = 0; i < litereCuvant; i++){
                        if (cuvant.charAt(i) == 'M'){
                            setLitera(i + 1, 'M');
                            setCuvantDeAfisat(i + 1, 'M');
                            count++;
                        }
                    }

                    if (count == 0){
                        countMistakes++;
                        setCuloareStickman();
                        if (countMistakes >= 5){
                            setStatusText("PIERDUT"); nrJocuriPierdute++; setNrPierderi();
                            afisareCuvant();
                            colorareLitere();
                        }
                    } else {
                        litereBune += count;  if (litereBune == litereCuvant){setStatusText("VICTORIE"); nrJocuriCastigate++; setNrVictorii(); colorareLitere();}
                    }
                }
            }
        });
        litere.add(M);

        statusText = new JTextField();
        statusText.setBorder(null);
        statusText.setHorizontalAlignment(SwingConstants.CENTER);
        statusText.setFont(new Font("Times New Roman", Font.BOLD, 30));
        statusText.setEditable(false);
        statusText.setBackground(Color.CYAN);
        statusText.setBounds(0, 44, 361, 64);
        cuvantDeGhicit.add(statusText);
        statusText.setColumns(10);

        JTextField victorii = new JTextField();
        victorii.setBorder(null);
        victorii.setHorizontalAlignment(SwingConstants.CENTER);
        victorii.setFont(new Font("Times New Roman", Font.BOLD, 18));
        victorii.setEditable(false);
        victorii.setBackground(Color.CYAN);
        victorii.setText("VICTORII:");
        victorii.setBounds(10, 11, 98, 34);
        cuvantDeGhicit.add(victorii);
        victorii.setColumns(10);

        JTextField pierderi = new JTextField();
        pierderi.setBorder(null);
        pierderi.setText("PIERDERI:");
        pierderi.setHorizontalAlignment(SwingConstants.CENTER);
        pierderi.setFont(new Font("Times New Roman", Font.BOLD, 18));
        pierderi.setEditable(false);
        pierderi.setColumns(10);
        pierderi.setBackground(Color.CYAN);
        pierderi.setBounds(204, 11, 98, 34);
        cuvantDeGhicit.add(pierderi);
        
        nrVictorii.setBorder(null);
        nrVictorii.setHorizontalAlignment(SwingConstants.CENTER);
        nrVictorii.setFont(new Font("Times New Roman", Font.BOLD, 18));
        nrVictorii.setBackground(Color.CYAN);
        nrVictorii.setBounds(109, 13, 39, 32);
        cuvantDeGhicit.add(nrVictorii);
        nrVictorii.setColumns(10);

        nrPierderi.setBorder(null);
        nrPierderi.setHorizontalAlignment(SwingConstants.CENTER);
        nrPierderi.setFont(new Font("Times New Roman", Font.BOLD, 18));
        nrPierderi.setColumns(10);
        nrPierderi.setBackground(Color.CYAN);
        nrPierderi.setBounds(304, 13, 39, 32);
        cuvantDeGhicit.add(nrPierderi);
    }

    public static void setLitera1(char litera) {
        litera1.setText(String.valueOf(litera));
    }

    public static void setLitera2(char litera) {
        litera2.setText(String.valueOf(litera));
    }

    public static void setLitera3(char litera) {
        litera3.setText(String.valueOf(litera));
    }

    public static void setLitera4(char litera) {
        litera4.setText(String.valueOf(litera));
    }

    public static void setLitera5(char litera) {
        litera5.setText(String.valueOf(litera));
    }

    public static void setLitera6(char litera) {
        litera6.setText(String.valueOf(litera));
    }

    public static void setLitera7(char litera) {
        litera7.setText(String.valueOf(litera));
    }

    public static void setLitera8(char litera) {
        litera8.setText(String.valueOf(litera));
    }

    public static void setLitera9(char litera) {
        litera9.setText(String.valueOf(litera));
    }

    public static void setLitera10(char litera) {
        litera10.setText(String.valueOf(litera));
    }

    public static void setLitera(int litera, char caracter){
        if (litera == 1) setLitera1(caracter);
        if (litera == 2) setLitera2(caracter);
        if (litera == 3) setLitera3(caracter);
        if (litera == 4) setLitera4(caracter);
        if (litera == 5) setLitera5(caracter);
        if (litera == 6) setLitera6(caracter);
        if (litera == 7) setLitera7(caracter);
        if (litera == 8) setLitera8(caracter);
        if (litera == 9) setLitera9(caracter);
        if (litera == 10) setLitera10(caracter);
    }

    public static void setStatusText(String text){
        statusText.setText(text);
    }

    public void setStartCuloareStickman(){
        cap.setBorderPainted(false);
        trunchi.setBackground(Color.CYAN);
        piciorDrept.setBackground(Color.CYAN);
        piciorStang.setBackground(Color.CYAN);
        maini.setBackground(Color.CYAN);
    }

    public void setCuloareStickman(){
        if (this.countMistakes == 1){
            cap.setBorderPainted(true);
        } else if (this.countMistakes == 2){
            trunchi.setBackground(Color.BLACK);
            cap.setBorderPainted(true);
        } else if (this.countMistakes == 3){
            piciorStang.setBackground(Color.BLACK);
        } else if (this.countMistakes == 4){
            piciorDrept.setBackground(Color.BLACK);
        } else if (this.countMistakes == 5) {
            maini.setBackground(Color.BLACK);
        }
    }

    public void afisareCuvant(){
        for (int i = 0; i < litereCuvant; i++){
            setLitera(i + 1, cuvant.charAt(i));
        }
    }

    public void colorareLitere(){
        A.setBackground(Color.CYAN);
        B.setBackground(Color.CYAN);
        C.setBackground(Color.CYAN);
        D.setBackground(Color.CYAN);
        E.setBackground(Color.CYAN);
        F.setBackground(Color.CYAN);
        G.setBackground(Color.CYAN);
        H.setBackground(Color.CYAN);
        I.setBackground(Color.CYAN);
        J.setBackground(Color.CYAN);
        K.setBackground(Color.CYAN);
        L.setBackground(Color.CYAN);
        M.setBackground(Color.CYAN);
        N.setBackground(Color.CYAN);
        O.setBackground(Color.CYAN);
        P.setBackground(Color.CYAN);
        Q.setBackground(Color.CYAN);
        R.setBackground(Color.CYAN);
        S.setBackground(Color.CYAN);
        T.setBackground(Color.CYAN);
        U.setBackground(Color.CYAN);
        V.setBackground(Color.CYAN);
        W.setBackground(Color.CYAN);
        X.setBackground(Color.CYAN);
        Y.setBackground(Color.CYAN);
        Z.setBackground(Color.CYAN);
    }

    public void setNrVictorii() {
        nrVictorii.setText(String.valueOf(nrJocuriCastigate));
    }

    public void setNrPierderi() {
        nrPierderi.setText(String.valueOf(nrJocuriPierdute));
    }

    public void setCuvantDeAfisat(int litere, char caracter){

    }
}
