import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class LunarPhases extends JFrame implements ActionListener {
    private JPanel SelectPhase;
    BufferedImage image1;

    private JLabel SelectPhase1;
    private DisplayPanel drawpanel;
    private static final String[] names = {"New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full","Waning Gibbous","Third Quarter","Waning Crescent"};
    private final JComboBox<String> combo;
    private  ImageIcon image;
    private class DisplayPanel extends JPanel
    {

        private  JLabel phaseIconLabel;
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            phaseIconLabel.setIcon(image);
            pack();
        }
        private DisplayPanel() {
            //image=new ImageIcon(LunarPhases.class.getResource("0.jpg"));
            this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Display Phase"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            this.add( phaseIconLabel = new JLabel());
            phaseIconLabel.setHorizontalAlignment(JLabel.CENTER);
            phaseIconLabel.setVerticalAlignment(JLabel.CENTER);
            phaseIconLabel.setVerticalTextPosition(JLabel.CENTER);
            phaseIconLabel.setHorizontalTextPosition(JLabel.CENTER);
            phaseIconLabel.setIcon(image);
            repaint();
        }



    }

    /*/
        super("Combo Oval");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.add(combo = new JComboBox<>());
        for (String name : names)
            combo.addItem(name);
        combo.addActionListener(this);
        this.add(panel = new DrawPanel());
        this.pack();
        this.setVisible(true);
    /*/

    public LunarPhases()
    {

        super("Lunar Phases");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SelectPhase=new JPanel();
        SelectPhase.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Select Phase"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        //this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Display Phase"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        combo = new JComboBox<String>(names);
        SelectPhase.add(combo);
        combo.addActionListener(this);
        this.add(SelectPhase);
        image=new ImageIcon(getClass().getResource("0.jpg"));
        this.add(drawpanel=new DisplayPanel());
        //combo.setSelectedIndex(0);
        //image=new ImageIcon(LunarPhases.class.getResource("C:\\Users\\neora\\Desktop\\0.png"));
        this.pack();
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==combo)
        {
            switch (combo.getItemAt(combo.getSelectedIndex()))
            {
                //"New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full","Waning Gibbous","Third Quarter","Waning Crescent"
                case "New":image=new ImageIcon(getClass().getResource("0.jpg"));break;
                case "Waxing Crescent":image=new ImageIcon(getClass().getResource("1.jpg"));break;
                case "First Quarter":image=new ImageIcon(getClass().getResource("2.jpg"));break;
                case "Waxing Gibbous":image=new ImageIcon(getClass().getResource("3.jpg"));break;
                case "Full":image=new ImageIcon(getClass().getResource("4.jpg"));break;
                case "Waning Gibbous":image=new ImageIcon(getClass().getResource("5.jpg"));break;
                case "Third Quarter":image=new ImageIcon(getClass().getResource("6.jpg"));break;
                case "Waning Crescent":image=new ImageIcon(getClass().getResource("7.jpg"));break;
            }
            drawpanel.repaint();
        }

    }

    public static void main(String args[])
    {
        new LunarPhases();
    }
}
