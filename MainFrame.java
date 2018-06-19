import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton[][] jbtn = new JButton[3][1];
    private JPasswordField jpx = new JPasswordField();
    private JTextArea jta = new JTextArea();
    private JTextArea jta2 = new JTextArea();
    private Container cp;
    private JPanel jpanCenter = new JPanel(new GridLayout(3,1,3,3));
    private JPanel jpanWest = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpanEast = new JPanel(new GridLayout(1,1,3,3));
    private JPanel jpanNorth = new JPanel(new GridLayout(1,1,3,3));
    public MainFrame(){
        init();
    }
    private void init(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(120,50,600,600);
        cp = getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpanNorth,"North");
        cp.add(jpanCenter,"Center");
        cp.add(jpanWest,"West");
        cp.add(jpanEast,"East");
        jpanCenter.add(jpx);
        jbtn[0][0] = new JButton("Enter");
        jbtn[1][0] = new JButton("Exit");
        for (int i=0 ; i<2 ; i++){
            for(int j=0 ; j<1 ; j++){
                jpanCenter.add(jbtn[i][j]);
            }
        }
        jpanWest.add(jta);
        jpanEast.add(jta2);
        jpanWest.setPreferredSize(new Dimension(250,600));
        jpanEast.setPreferredSize(new Dimension(250,600));
        jbtn[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbtn[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = jta.getText();
                int a = str.length();
                char [] ch = str.toCharArray();
                String b = jpx.getPassword().toString();
                int c = b.length();
                char [] d = b.toCharArray();
                for(int i=0 ; i<a ; i++){
                    ch[i] = ((char)((int)ch[i]^(int)d[i%c]));
                    }
                    jta2.setText(new String(d));
            }
        });
    }
}