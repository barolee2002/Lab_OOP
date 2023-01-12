import java.util.Scanner;
public class AddTwoMatric {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        int width,height;
        System.out.print("enter width: ");
        width = enter.nextInt();
        System.out.print("enter height: ");
        height = enter.nextInt();
        int[][] arr1 = new int[height][width],
        arr2 = new int[height][width],
        arr3 = new int[height][width];
        System.out.println("enter array 1 :");
        for(int i = 0; i < height; i++ ) {
            for(int j = 0;j < width; j++) {
                System.out.print("enter arr1[" + i +"]" + "[" + j +"] : ");
                arr1[i][j] = enter.nextInt();
            }
        }
        System.out.println("enter array 2 :");
        for(int i = 0; i < height; i++ ) {
            for(int j = 0;j < width; j++) {
                System.out.print("enter arr2[" + i +"]" + "[" + j +"] : ");
                arr2[i][j] = enter.nextInt();
            }
        }
        for(int i = 0; i < height; i++ ) {
            for(int j = 0;j < width; j++) {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        System.out.println("total two array :");
        for(int i = 0; i < height; i++ ) {
            for(int j = 0;j < width; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.print("\n");
        }
        enter.close();
    }
}
