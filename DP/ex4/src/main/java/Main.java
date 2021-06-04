public class Main {
    public static void main(String[] args) {
        AccessLimitInstanceClassThread thread[] = new AccessLimitInstanceClassThread[10];
        for(int i=0;i<10;i++){
            thread[i] = new AccessLimitInstanceClassThread(String.valueOf(i+1));
        }
        for(int i=0;i<10;i++){
            thread[i].start();
        }
    }
}
