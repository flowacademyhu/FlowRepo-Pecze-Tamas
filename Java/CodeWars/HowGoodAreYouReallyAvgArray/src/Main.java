public class Main {
    public static void main(String[] args) {
        System.out.println(method(new int[] {2,3}, 5));
    }

    private static boolean method(int[] classPoints, int yourPoints) {
        int sum = 0;
        for(int i = 0; i < classPoints.length; i++) {
            sum+=classPoints[i];
        }
        sum+=yourPoints;
        double avg = sum/(classPoints.length +1);
        if(avg < yourPoints) {
            return true;
        } else {
            return false;
        }
    }
}
