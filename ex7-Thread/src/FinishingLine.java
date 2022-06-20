import java.time.LocalTime;

public class FinishingLine {

   public FinishingLine()
    {

    }
    public void arrive(Horse h)
    {
        System.out.println("Horse"+":"+h.getId() +" Finish the race at "+LocalTime.now());
    }

}
