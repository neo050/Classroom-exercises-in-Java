import java.time.LocalTime;

public class FinishingLine {
    private Object loock;
    private static Object loock1=new Object();;
    private int numintherace=0;
    private Horse thewinner;
    private static FinishingLine singel=null;
   private FinishingLine()
    {
        loock=new Object();

    }
    public static FinishingLine getInstance()
    {
        if(singel==null) {
            synchronized (loock1) {
                if (singel == null)
                    return singel = new FinishingLine();
                else
                    return singel;
            }
        }
        else
            return singel;
    }
    public void arrive(Horse h)
    {
        synchronized (loock) {
            numintherace += 1;
            if (numintherace == 1)
                thewinner = h;
            System.out.println(h.getId()+" Finish the race on the spot:"+numintherace +" Finish the race at "+LocalTime.now());
        }

    }
    public Horse getWinner()
    {
        return thewinner;
    }


}
