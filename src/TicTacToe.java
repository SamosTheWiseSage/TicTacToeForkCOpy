import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TicTacToe extends JFrame {
    public static final String ICON_URL = "src/icon-05.png";
    static int gameMode = 0; //använd variabeln eller likande för gamemode
    static final int UNI_PADDING = 10;
    // ni kan ha 2d array [][] för cellerna också
    static ArrayList<JButton> cellList = new ArrayList<>();
    private static TicTacToe application;
    public static JPanel panel = new JPanel();
    public TicTacToe() {
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        application = new TicTacToe();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image iconImage= new ImageIcon("src/icon-05.png").getImage();
        application.setIconImage(iconImage);
        application.setTaskbarIcon(iconImage); //mac har dockad icon
        application.setResizable(false);

        //skapa bättre struktur med GUI som displayar info som player turn och vem som har vunnit.
        //skapa en knapp för att kunna byta gamemode


        panel.setBorder(new EmptyBorder(UNI_PADDING, UNI_PADDING, UNI_PADDING, UNI_PADDING));
        panel.setBackground(Color.lightGray);
        panel.setSize(300, 300);

        GridLayout gl = new GridLayout(3, 3);
        gl.setHgap(UNI_PADDING);
        gl.setVgap(UNI_PADDING);
        panel.setLayout(gl);



        application.add(panel);
        application.setVisible(true);

        changeGameMode();
        PlayGame();
    }

    public static void changeGameMode(){
        // skapa en panel med er custom game mode
        JDialog frame = new JDialog(application, "Game mode", true);
        JPanel dialog = new JPanel();
        frame.add(dialog);
        dialog.setSize(100, 100);
        LayoutManager FlowLayout = new FlowLayout();
        dialog.setLayout(FlowLayout);
        dialog.setSize(100, 100);
        JButton gameMode1 = new JButton("PvP");
        JButton gameMode2 = new JButton("PvTerminator");
        dialog.add(gameMode1);
        dialog.add(gameMode2);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }

    public static void PlayGame(){
        for (int i = 0; i < 9; i++) {
            Font f = new Font("Open sans", Font.BOLD, 50);
            JButton jb = new JButton((i % 2 < 1) ? "x" : "o");
            jb.setFont(f);
            cellList.add(jb);
            panel.add(jb);
        }
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
