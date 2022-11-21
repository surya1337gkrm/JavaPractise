import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int age=30;
        //byte takes 1 byte, short takes 2 bytes and int takes 4 bytes
        byte age=30;
        //by default a number will be inferred as an integer
        //to avoid the errors, add L/l at the end of the number
        long views=1_234_234_345_22L;
        //add f/F at the end of float value as by default it will be inferred as a double(8 Bytes)
        float price=10.99f;
        char letter='S';
        //reference types
        Date now=new Date();
        String str="Hello Surya";
        //arrays
        int[] arr1=new int[5];
        arr1[0]=1;
        //if values are known
        int[] arr2={1,2,3,4,5};
        System.out.println("length of the Array: "+ Array.getLength(arr2));
        System.out.println("Length: "+arr2.length);
        System.out.println(Arrays.toString(arr2));

        //multidimensional arrays
        int[][] mArr1=new int[2][3];
        mArr1[0][0]=1;
        System.out.println(mArr1[0][0]);
        System.out.println(Arrays.deepToString(mArr1));

        System.out.println(now);

        //to declare a variable as constant, use final keyword
        final float PI = 3.14f;
        System.out.println(PI);

        //arithmetic operations
        int x=2;
        //int y=x++ will copy x value to y first and then increments x
        //int y=++x will increment x value first and then copies the incremented value.
        int y=3;
        System.out.println(y/x); //returns integer value
        //if we need float division cast the values
        System.out.println((float)y/(float)x);

        //casting numbers
        int a=10;
        double b=10.0;
        int c=a+(int)b;
        System.out.println(c);

        //Math library : round,ceil,random etc
        System.out.println(Math.round(2.223));
        System.out.println(Math.round(Math.random()*100));

        //Formatting Numbers
        String priceN=NumberFormat.getCurrencyInstance().format(1_234_456);
        String nPercent=NumberFormat.getPercentInstance().format(0.23);
        System.out.println(priceN);
        System.out.println(nPercent);

        //Use Scanner Class to read data from the console.
        Scanner scanner = new Scanner(System.in);
        //println displays the content and adds a new line
        //where print displays the content and continue in same line.
        System.out.print("Name: ");
        String name=scanner.nextLine().trim();
        System.out.println("The Name is : "+name);

    }
}