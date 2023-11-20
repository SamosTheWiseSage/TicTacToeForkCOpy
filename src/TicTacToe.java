import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TicTacToe extends JFrame {
    static int gameMode = 0; //använd variabeln eller likande för gamemode
    static final int UNI_PADDING = 10;
    // ni kan ha 2d array [][] för cellerna också

    //List the jbuttons saves in
    static ArrayList<JButton> cellList = new ArrayList<>();
    private static TicTacToe application;

    //Builds a frame
    public TicTacToe() {
        setSize(500, 600);
        setVisible(true);
    }

    public static void main(String[] args) {
        //Tells the baseframe what to do
        application = new TicTacToe();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Icon image if we want it
        Image iconImage= new ImageIcon("src/icon-05.png").getImage();
        application.setIconImage(iconImage);
        application.setTaskbarIcon(iconImage); //mac har dockad icon
        application.setResizable(false);
        application.setLayout(new BorderLayout());

        //skapa bättre struktur med GUI som displayar info som player turn och vem som har vunnit.
        //skapa en knapp för att kunna byta gamemode


        //Basepanel for displaying the different buttons on
        JPanel panel = new JPanel();
        //Padding to evenly distribute the buttons on the grid
        panel.setBorder(new EmptyBorder(UNI_PADDING, UNI_PADDING, UNI_PADDING, UNI_PADDING));
        panel.setBackground(Color.lightGray);
        panel.setSize(300, 300);

        JPanel panelTop = new JPanel();
        application.add(panelTop);
        JTextField textField = new JTextField("Här hamnar info");
        panelTop.add(textField);



        //Gridlayout for my buttons
        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(UNI_PADDING);
        gl.setVgap(UNI_PADDING);
        panel.setLayout(gl);

        //For-loop constructing the buttons
        for (int i = 0; i < 9; i++) {
            Font f = new Font("Open sans", Font.BOLD, 50);
            //Setting a value and constructing JButtons
            JButton jb = new JButton((i % 2 < 1) ? "x" : "o");
            jb.setFont(f);
            cellList.add(jb);
            panel.add(jb);
        }

        application.add(panel);
        application.setVisible(true);
        changeGameMode();
    }

    public static void changeGameMode(){
        // skapa en panel med er custom game mode
        final JDialog frame = new JDialog(application, "Game mode", true);
        frame.getContentPane().add(new JPanel());
        frame.pack();
        frame.setVisible(false);
    }

    public static boolean checkWinOrDraw(){
        // kod för spelet avslutas
        return false; //true  when draw/win
    }

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
    }
}
