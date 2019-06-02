public class Main {
    public static void main(String[] args) throws InterruptedException {
        var t1 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        var t2 = new Thread(() -> {
           for (int i = 0; i<= 10; i+=2) {
               System.out.println(i);
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        t1.start();
        t2.start();
        /*t1.join();
        t2.join();*/
    }
}
