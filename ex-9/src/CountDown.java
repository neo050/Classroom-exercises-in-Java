public class CountDown implements Runnable {
    String name;
    public CountDown(String name)
    {
        this.name=name;
    }
    @Override
    public void run() {
        int count=7;
        while (count>=0) {
            System.out.println(this.name + ", count = " + count);
            Thread.yield();
            count-=1;
        }
    }
}
