import java.sql.Time;
import java.time.LocalTime;

public class HorsesRace {
    public static void main(String []args )
    {
        FinishingLine f=new FinishingLine();
        Thread mythread[]=new Thread[10];
      for (int i =0 ;i<mythread.length;++i)
      {
          mythread[i]=new Thread(new Horse("Horse "+i,f,200));
      }
        System.out.println("The race is start in:"+LocalTime.now());
      for (Thread OP:mythread)
          OP.start();

        for(Thread op: mythread)
      {
          try
          {
              op.join();
          }
          catch ( InterruptedException k)
          {
              ///nothing
          }
      }
      System.out.println("The race is over in:"+LocalTime.now());

    }

}
