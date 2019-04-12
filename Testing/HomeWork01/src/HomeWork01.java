
public class HomeWork01 {
    public int k;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int z;
    public void main(String... args) {

        System.out.println("k:" + k + " z:" + z);
        int sumofsum = sum(k,z);
        System.out.println("Sum:" + sumofsum);
        if (k < z) {
            System.out.println("first number is bigger then the second...");
        } else if (k > z){
            System.out.println("first number is bigger then the second...");
        } else {
            System.out.println("they are equal...");
        }
    }
    public int sum (int a, int b) {
        return a+b;
    }

}
