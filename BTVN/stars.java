import java.util.Scanner;
public class stars {
    public static void main(String[] args) {
        int n;
        Scanner enter = new Scanner(System.in);
        n = enter.nextInt();
        for(int i = 0; i < n ; i++) {
            for(int j = 0;j < n-i; j++ ) {
                System.out.print(" ");
            }
            for(int j = 0;j < 2*i+1; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
        enter.close();

    }
}
