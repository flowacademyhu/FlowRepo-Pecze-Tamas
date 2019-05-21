public class Counter implements Runnable {
    Integer time;
    Integer MINNUMBER;
    Integer MAXNUMBER;
    Thread t1;
    Integer INCREMENT;
    @Override
    public void run() {
        for(int i = MINNUMBER; i <= MAXNUMBER; i =+ INCREMENT) {
            System.out.println(i);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {

            }
        }
    }


    public Counter(Integer time, Integer MINNUMBER, Integer MAXNUMBER, Integer INCREMENT) {
        this.time = time;
        this.MINNUMBER = MINNUMBER;
        this.MAXNUMBER = MAXNUMBER;
        this.INCREMENT = INCREMENT;
        this.t1 = new Thread(this);
    }
    public void start(){
        this.t1.start();
    }

}
