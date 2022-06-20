import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Calculator extends JFrame implements ActionListener {
    private JPanel myPaneldown;
    private String oprator="";
    private boolean art=false;
    private float calculat;
    private JPanel myPanelup;
    private JButton [] MyButtons;
    List<String> valleft;
    List<String> valright;
    private static String[] Buttonsnames={"Backspace","CE","C","7","8","9","/","sqrt","4","5","6","*","1/x","1","2","3","-","%","0","+/-",".","+","="};
    private JTextField Mathexpression;//3,4,5,8,9,10,13,14,15,18
    private JLabel expression;
   public  Calculator()
   {
       super("Primitive Calculator");
       myPaneldown =new JPanel();
       myPaneldown.setLayout(new GridLayout(4,5));
       myPanelup =new JPanel();
       BorderLayout myBorderLayout = new BorderLayout();
       myBorderLayout.setHgap(20);
       myBorderLayout.setVgap(20);
       myPanelup.setLayout(myBorderLayout);

       expression=new JLabel("" );
       myPanelup.add( Mathexpression=new JTextField(),BorderLayout.NORTH);
       MyButtons =new JButton[23];
       for (int i = 0; i< MyButtons.length; ++i)
       {
           MyButtons[i]=new JButton(Buttonsnames[i]);
           MyButtons[i].addActionListener(this);
           if (i<3)
           {
               if (i==0) {
                   myPanelup.add(MyButtons[i], BorderLayout.WEST);
                   myBorderLayout.setHgap(0);
               }
               if (i==1)
                   myPanelup.add(MyButtons[i],BorderLayout.CENTER);
               if (i==2)
                   myPanelup.add(MyButtons[i],BorderLayout.EAST);

           }
           else
            myPaneldown.add(MyButtons[i]);
       }
       valleft =new ArrayList<String>();
       valright=new ArrayList<String>();
       this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
       this.add(myPanelup);
       this.add(myPaneldown);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.pack();
       this.setVisible(true);


   }
   private String getval(String op)
   {
       String val1="";
       if (op.equals("l")) {
           if (valleft.size() > 0) {
               val1 = valleft.get(0);
               for (int j = 1; j < valleft.size(); ++j) {
                   val1 += valleft.get(j);
               }

           }
       }
       else if (op.equals("r")) {
           if (valright.size() > 0) {
               val1 = valright.get(0);
               for (int j = 1; j < valright.size(); ++j) {
                   val1 += valright.get(j);
               }

           }
       }
       return val1;
   }
   private boolean AddVal(Object op,String P)
   {
       for(int i =0;i<MyButtons.length;++i)
       {
           if (op==MyButtons[i])
           {
               if(op.equals("l")) {
                   valleft.add(Buttonsnames[i]);
                   return true;
               }
               else
               {
                   valright.add(Buttonsnames[i]);
                   return true;
               }

           }
       }
       return false;
   }
   private float Calculat(String op)
   {
       try
       {
           switch (op)
           {
               //"New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full","Waning Gibbous","Third Quarter","Waning Crescent"
               case "-":if (valleft.size() > 0 && valright.size() > 0){calculat -= Float.parseFloat(getval("l"))- Float.parseFloat(getval("r"));}break;
               case "/":if (valleft.size() > 0 && valright.size() > 0){calculat /= Float.parseFloat(getval("l"))/ Float.parseFloat(getval("r"));}break;
               case "*":if (valleft.size() > 0 && valright.size() > 0){calculat *= Float.parseFloat(getval("l"))* Float.parseFloat(getval("r"));}break;
               case "+":if (valleft.size() > 0 && valright.size() > 0){calculat += Float.parseFloat(getval("l"))+Float.parseFloat(getval("r"));}break;
               case "1/":if (valleft.size() > 0 && valright.size() == 0){calculat = 1/Float.parseFloat(getval("l"));}break;
               case "sqrt":if(valleft.size() > 0 && valright.size() ==0){calculat = (float)sqrt((double) Float.parseFloat(getval("l")));}break;
               case "%":if(valleft.size() > 0 && valright.size() ==0){calculat = (float)sqrt((double) Float.parseFloat(getval("l")));}break;
              // case "Waning Crescent":image=new ImageIcon(getClass().getResource("7.jpg"));break;
           }

            calculat = Float.parseFloat(getval(op));
            return calculat;
           //float p=Float.parseFloat("14.5*8");
       }
       catch (Exception IO)
       {
           System.out.println("Error");

       }
       return 0;
   }


    @Override
    public void actionPerformed(ActionEvent e)//3,4,5,8,9,10,13,14,15,18
            //{"Backspace","CE","C","7","8","9","/","sqrt","4","5","6","*","1/x","1","2","3","-","%","0","+/-",".","+","="};
    {       //  0             1  2  3   4   5   6    7     8   9   10  11  12    13  14   15  16 17   18  19    20  21  22
        if(!(e.getSource()==MyButtons[22]||e.getSource()==MyButtons[0]||e.getSource()==MyButtons[1]||e.getSource()==MyButtons[2]||e.getSource()==MyButtons[6]||e.getSource()==MyButtons[7]||e.getSource()==MyButtons[11]||e.getSource()==MyButtons[12]||e.getSource()==MyButtons[16]||e.getSource()==MyButtons[17]||e.getSource()==MyButtons[19]||e.getSource()==MyButtons[20]||e.getSource()==MyButtons[21])&&!art) {
            if (oprator.equals("")) {
                AddVal(e.getSource(), "l");
                Mathexpression.setText(getval("l"));
            }
            else
            {
                AddVal(e.getSource(), "r");
                Mathexpression.setText(getval("l")+oprator+getval("r"));
            }
        }
        if(e.getSource()==MyButtons[0]) {
            boolean i;
            if(!art)
            {
                i=Backspacebutton(valleft);
            }
            else {
                i=Backspacebutton(valright);
            }

                Mathexpression.setText(getval("l")+oprator+getval("r"));
        }
        if(e.getSource()==MyButtons[1]) {
            valleft.removeAll(valleft);
            valright.removeAll(valright);
            oprator="";
            Mathexpression.setText("");

        }
        if(e.getSource()==MyButtons[2]) {
            valleft.removeAll(valleft);
            valright.removeAll(valright);
            oprator="";
            Mathexpression.setText("");
        }

        if(e.getSource()==MyButtons[20])
        {
            if(!valleft.contains(".")&& valleft.size()>0)
            {
                AddVal(e.getSource(),"l");
                Calculat("l");
                Mathexpression.setText(getval("l"));
            }
           else if(!valright.contains(".")&& valright.size()>0)
            {
                AddVal(e.getSource(),"r");
                Calculat("r");
                Mathexpression.setText(getval("l")+oprator+getval("r"));
            }

        }
        if(e.getSource()==MyButtons[11])
        {
            if(!art)
            {
                //AddVal(e.getSource());
                oprator="*";
                Mathexpression.setText(getval("l")+oprator+getval("r"));
            }
        }
        if(e.getSource()==MyButtons[12])
        {

            if(!art)
            {
                if( valleft.size()>0&&valright.size()==0)
                {
                    //AddVal(e.getSource());
                    oprator = "1/";
                    Mathexpression.setText(oprator+getval("l"));
                }
            }
        }
        if(e.getSource()==MyButtons[16])
        {

            if(!art)
            {
                if(valleft.size()>0&&valright.size()==0)
                {
                    //AddVal(e.getSource());
                    oprator = "-";
                    Mathexpression.setText(oprator+getval("l"));
                }
            }
        }
        if(e.getSource()==MyButtons[17])
        {

            if(!art)
            {
                if(valleft.size()>0&&valright.size()==0)
                {
                    //AddVal(e.getSource());
                    oprator = "%";
                    Mathexpression.setText(oprator+getval("l"));
                }
            }
        }
        if(e.getSource()==MyButtons[19])
        {

            if(!art)
            {
                if(valleft.size()>0&&valright.size()==0)
                {
                    //AddVal(e.getSource());
                    oprator = "-";
                    Mathexpression.setText(oprator+getval("l"));
                }
            }

        }

        if(e.getSource()==MyButtons[21]) {

            if (!art) {
                if (valleft.size() > 0 && valright.size() == 0) {
                    //AddVal(e.getSource());
                    oprator = "+";
                    Mathexpression.setText( getval("l")+oprator+getval("r"));
                }
            }

        }
        if(e.getSource()==MyButtons[22]) {

            if (art) {
                if (valleft.size() > 0 && valright.size() >0) {
                    //AddVal(e.getSource());
                    Mathexpression.setText( ""+Calculat(oprator));
                }
            }

        }
    }
    private boolean Backspacebutton(List<String>OP)
    {
        if(OP.size()>0)
        {
            OP.remove(OP.size()-1);
            return true;
        }
        return false;
    }
    public static void main(String [] args)
    {
        new Calculator();
    }

}
