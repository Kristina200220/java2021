import java.util.Scanner;
//C2 = 0 +
//C3 = 2 2
//C5 = 3 +
//C7 = 6 double

public class Lab1 {
    private static double r;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("a:");
            double a = in.nextDouble();
            System.out.print("n:");
            double n = in.nextDouble();
            if(n <= a) throw new Exception("n must be greater than a");
            System.out.print("b:");
            double b = in.nextDouble();
            System.out.print("m:");
            double m = in.nextDouble();
            if(m <= b) throw new Exception("m must be greater than b");
            for (double i = a; i <= n; i++) {
                for (double j = b; j <= m; j++) {
                    if(i == 2) throw new Exception("division by zero");
                    r = r + ( i + j ) / ( i + 2 );
                }
            }
            System.out.print("\nResult = " + r);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
