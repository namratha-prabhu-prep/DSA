package recursion;

public class Gcd {
    public int gcd(int a, int b) {
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        System.out.println(gcd.gcd(28, 20));

    }
}
