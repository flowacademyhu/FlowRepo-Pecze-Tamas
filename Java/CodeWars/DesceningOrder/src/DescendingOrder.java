public class DescendingOrder {
    public static int sortDesc(final int num) {
        int[] temp = {15000};
        for(int i=0; i<Integer.valueOf(num); i++){
            for(int j=0; j<i-1; j++) {
                if(num < temp){
                    temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                }
            }
            return num;
        }
    }
    public void test_01() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }
}