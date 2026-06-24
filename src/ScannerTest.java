import java.awt.font.NumericShaper;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] arr = line.split(" ");
        int[] nums = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }

        for(int num : nums){
            System.out.println(num);
        }
    }
}
