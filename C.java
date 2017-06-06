class SampleDemo implements Runnable {

    private Thread t;
    private String threadName;

    SampleDemo (String threadName){
        this.threadName = threadName;
    }

    public void run()
    {
        while (true)
            System.out.print(threadName);
    }

    public void start ()
    {
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class C {

    public static void main(String args[]) {

        SampleDemo A = new SampleDemo( "A");
        SampleDemo B = new SampleDemo( "B");

        try{
            int x = 4/ 0;
        }catch(Exception e){
            System.out.print("afun");
        }finally {
            System.out.print("dfun");
        }


    }
}