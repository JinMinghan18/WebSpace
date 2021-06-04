import static java.lang.Math.random;

public class AccessLimitInstanceClassThread extends Thread{
    public String threadName = "";

    //构造线程类，赋值
    public AccessLimitInstanceClassThread(String ThreadID){
        this.threadName = ThreadID;
    }
    public AccessLimitInstanceClassThread(){}
    public void run(){
        LimitInstanceClass limitInstanceClass = LimitInstanceClass.getInstance();
        if(limitInstanceClass != null){
            limitInstanceClass.WriteAccessMessage(threadName);

            try {
                Thread.sleep((int)Math.random()*5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            limitInstanceClass.PrintAccessMessage();
            limitInstanceClass.release();

        }

        else{
            while (limitInstanceClass == null){
                System.out.println("thread " + threadName + " is waiting");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                limitInstanceClass = LimitInstanceClass.getInstance();
                if(limitInstanceClass != null){
                    limitInstanceClass.WriteAccessMessage(threadName);

                    try {
                        Thread.sleep((int)Math.random()*5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    limitInstanceClass.PrintAccessMessage();
                    limitInstanceClass.release();

                }
            }
        }
    }
}
