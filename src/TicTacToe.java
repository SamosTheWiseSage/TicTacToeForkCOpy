import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class TicTacToe extends JFrame {
    //TextField som outputar meddelanden till spelare
    static JTextField outputTF;
    //Andreas? hehehe
    static int gameMode = 0; //använd variabeln eller likande för gamemode
    //Padding för att knapparna skall se mer ordnade ut
    static final int UNI_PADDING = 10;
    //Array för att plocka in värden på våra knappar
    static JButton [] arrayJB =  new JButton[9];
    //För att få igång if-satser som byter vilken spelare som spelar - byt till bättre namn på denna!!
    static boolean startGame;
    //Vårt spel
    private static TicTacToe application;


    public TicTacToe() {
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        //Application eller frame
        application = new TicTacToe();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setResizable(false);
        application.setLayout(new BorderLayout());

        //JPanel som rymmer JButtons
        JPanel panelJB = new JPanel();
        panelJB.setBorder(new EmptyBorder(UNI_PADDING, UNI_PADDING, UNI_PADDING, UNI_PADDING));
        panelJB.setBackground(Color.lightGray);
        panelJB.setSize(300, 300);

        //Gridlayout för att JButtons skall displayas rätt
        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(UNI_PADDING);
        gl.setVgap(UNI_PADDING);
        panelJB.setLayout(gl);

        //Textfield för att displaya vems tur det är och så vidare.
        outputTF = new JTextField("Welcome players!");
        Font bigFont = outputTF.getFont().deriveFont(Font.PLAIN, 30f);
        outputTF.setFont(bigFont);
        JPanel panelTop = new JPanel();
        panelTop.add(outputTF);
        outputTF.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        application.add(panelTop, BorderLayout.NORTH);

        //For-loop som bygger våra JButtons
        for (int i=0;i<9;i++) {
            Font f = new Font("Open sans", Font.BOLD, 50);
            arrayJB[i] = new JButton();
            arrayJB[i].addActionListener(listener);
            arrayJB[i].setFont(f);
            arrayJB[i].setActionCommand(i+"");
            panelJB.add(arrayJB[i]);
        }
        application.add(panelJB);
        application.setVisible(true);
        //changeGameMode();
    }
    //ActionListener till våra knappar för att kunna köra spelet
    static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        //For-loop för att köra if-statements 9 gånger(alla knappar) som sätter X/O på knapparna och byter spelare efter varje klick.
            for (int i=0;i<9;i++){
                if(e.getSource()==arrayJB[i]){
                    if(startGame){
                        if (arrayJB[i].getText()=="") {
                            arrayJB[i].setText("O");
                            outputTF.setText("X's turn");
                            startGame=false;
                            //Här måste vi bygga klart metoden för att kolla om X/O har vunnit, förlorat eller fått slut på drag
                            checkWinOrDraw();
                        }
                    }else { if (arrayJB[i].getText()==""){
                            arrayJB[i].setText("X");
                            outputTF.setText("O's turn");
                            startGame=true;
                            checkWinOrDraw();
                        }
                    }
                }
            }
            //För att kolla så vår knapp funkar, plocka bort när vi är klara!!!
            if (e.getSource() instanceof JButton) {
                String text = e.getActionCommand();
                int i = parseInt(text);
                System.out.println("Knappen funkar");
            }
        }
    };
    /*
    public static void changeGameMode(){
        // skapa en panel med er custom game mode
        final JDialog frame = new JDialog(application, "Game mode", true);
        frame.getContentPane().add(new JPanel());
        frame.pack();
        frame.setVisible(true);
    }
     */
    // GETA YOU GO HERE
    public static boolean checkWinOrDraw(){
        // kod för spelet avslutas
        return false; //true  when draw/win
    }
    /*
    public void setTaskbarIcon(Image image) { // förmodligen apple docked iconen
        final Taskbar taskbar = Taskbar.getTaskbar();

        try {
            //set icon for Mac Os (and other systems which do support this method)
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
            System.out.println("The os does not support: 'taskbar.setIconImage'");
        } catch (final SecurityException e) {
            System.out.println("There was a security exception for: 'taskbar.setIconImage'");
        }
    }*/
}
