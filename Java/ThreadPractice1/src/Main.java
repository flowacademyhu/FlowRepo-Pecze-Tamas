public class Main {
    public static void main(String[] args){
        var t3 = new Counter(2000,0,100,1);
        t3.start();
        var t4 = new Counter(2000,100,200,2);
        t3.start();
        var t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 100; i++) {
                    System.out.println(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }
                }
            }
        });
        var t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 100; i <= 200; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });
/*        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("done.");*/

    }
}