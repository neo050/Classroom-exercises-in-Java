import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
     private static int maxthread =4;
     private Executor executor; //= Executors.newFixedThreadExecutor(2)
     //((ExecutorService)executor).shutdown();
     public ThreadPool(int numoftasks)
     {
          executor = Executors.newFixedThreadPool(maxthread);
          for (int i =0;i<numoftasks;++i)
          {
               executor.execute(new CountDown("Task "+i));
          }
          ((ExecutorService) executor).shutdown();
          while(!((ExecutorService) executor).isTerminated())
          {
               try {
                    Thread.sleep(50);


               }
               catch ( InterruptedException o)
               {

               }
        }
          System.out.println("End of work");
     }
     public static void main (String [] args)
     {

               new ThreadPool(6);

     }
}
