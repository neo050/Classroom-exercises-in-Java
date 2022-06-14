import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.InputMismatchException;

public class BoxVolumeArea extends JFrame {
    private final JLabel Width;
    private final JTextField Widthinput;
    private final JLabel Height;
    private final JTextField Heightinput;
    private final JLabel length;
    private final JTextField lengthinput;
    private JPanel buttonAndLabwls;
    private JButton Calculate;
    private final JLabel volume;
    private final JLabel area;


    public BoxVolumeArea() {
        super("Box Volume & Area");
        buttonAndLabwls=new JPanel();
        buttonAndLabwls.setLayout(new BoxLayout(buttonAndLabwls, BoxLayout.LINE_AXIS));
        this.setLayout( new GridLayout(4, 2));
        this.add(Width=new JLabel("Width:              "));
        this.add(Widthinput=new JTextField());
        this.add(Height=new JLabel("Height:              "));
        this.add(Heightinput=new JTextField());
        this.add(length=new JLabel("Length:              "));
        this.add(lengthinput = new JTextField());
        Calculate=new JButton("Calculate");
        volume=new JLabel(" volume");
        area=new JLabel("  area");
        buttonAndLabwls.add(Calculate);
        buttonAndLabwls.add(volume);
        buttonAndLabwls.add(area);
        this.add(  buttonAndLabwls);
        Calculate.addActionListener(new ActionListener() {

            private String Width;
            private String Height;
            private String Length;
            Float result;
            @Override
            public void actionPerformed(ActionEvent e) {
                Width=Widthinput.getText();
                Height=Heightinput.getText();
                Length=lengthinput.getText();
                try {
                    result=Float.parseFloat (Width)*Float.parseFloat (Height)*Float.parseFloat (Length);
                    volume.setText("volume = "+result+" ");
                    result=2*Float.parseFloat (Width)*Float.parseFloat (Length)+2*Float.parseFloat (Height)*Float.parseFloat (Length)+2*Float.parseFloat (Height)*Float.parseFloat (Width);
                    area.setText("area = "+result+" ");
                   pack();
                    Widthinput.setText("");
                    Heightinput.setText("");
                    lengthinput.setText("");
                    pack();
                }catch (Exception O) {
                }



            }
        });
       // this.pack();

        this.setSize(350,115);
        this.setVisible(true);

    }
    public static void main(String[] args) {
        BoxVolumeArea window = new BoxVolumeArea();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

