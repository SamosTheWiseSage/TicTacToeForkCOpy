import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TicTacToe extends JFrame {
    static int gameMode = 0; //använd variabeln eller likande för gamemode
    static final int UNI_PADDING = 10;
    static JButton [] arrayJB =  new JButton[9];
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
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(UNI_PADDING, UNI_PADDING, UNI_PADDING, UNI_PADDING));
        panel.setBackground(Color.lightGray);
        panel.setSize(300, 300);

        //Gridlayout för att JButtons skall displayas rätt
        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(UNI_PADDING);
        gl.setVgap(UNI_PADDING);
        panel.setLayout(gl);

        //Textfield för att displaya vems tur det är och så vidare.
        JTextField outputTF = new JTextField("Här kommer det komma grejer");
        Font bigFont = outputTF.getFont().deriveFont(Font.PLAIN, 30f);
        outputTF.setFont(bigFont);
        JPanel panelTop = new JPanel();
        panelTop.add(outputTF);
        outputTF.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        application.add(panelTop, BorderLayout.NORTH);

        for (int i = 0; i < 9; i++) {
            arrayJB[i] = new JButton();
            arrayJB[i].addActionListener(listener);
            panel.add(arrayJB[i]);
        }
        application.add(panel);
        application.setVisible(true);
        //changeGameMode();
    }
    static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                System.out.println("snopp");
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
