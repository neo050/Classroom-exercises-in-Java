import java.util.Random;
public class Horse implements Runnable{
    private  int distanse;
    private Random rand;
    private String id;
    private FinishingLine f;
    public Horse(String id, FinishingLine f, int distanse)
    {
        this.id=id;
        this.f=f;
        this.distanse=distanse;
        rand = new Random();
    }
    @Override
    public void run()
    {

        while (distanse>0)
        {
            distanse-=  rand.nextInt(1,11);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException OP)
            {

            }

        }

        f.arrive(this);

    }
    public String getId()
    {
        return id;
    }



}
