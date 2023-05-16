import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {

        // Method 01 : Using System.in
        // int b = 0;
        // try {
        // System.out.print("Enter: ");
        // b = System.in.read();
        // } catch (Exception e) {
        // System.out.println("Error: " + e);
        // }
        // System.out.println(b);

        // String s = "";
        // BufferedReader br = null;
        // try {
        //     br = new BufferedReader(new InputStreamReader(System.in));
        //     System.out.print("Enter: ");
        //     s = br.readLine();

        // } catch (Exception e) {
        //     System.out.println("Error: " + e);
        // } finally {
        //     try {
        //         br.close();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }
        // System.out.println((s)); // might throw an exception if the string cannot be converted to an
                                 // integer

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter: ");
        // String str = sc.nextLine();
        // sc.close();
        // System.out.println("Scanner Text: "+str);

        try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
            String str = b.readLine();
            System.out.println(Integer.parseInt(str));
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
