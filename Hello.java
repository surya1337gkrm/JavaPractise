
class Calculator {

    // class property
    int a = 10;

    public int add(int n1, int n2) {
        return n1 + n2;
    }

    // method overloading
    public int add(int n1, double n2) {
        return n1 + (int) n2;
    }
}

class Hello {
    public static void main(String[] a) {
        System.out.println("Hello world");
        char c = 'a';
        c++;
        System.out.println(c);
        byte b = 127;
        System.out.println(b);
        int i = 258;
        b = (byte) i;
        System.out.println(b); // 258%256=2

        if (b != 0) {
            System.out.println("True");
        }

        switch (b) {
            case 2:
                System.out.println("True Byte");
                break;
            default:
                System.out.println("Default");
                break;

        }

        Calculator calc = new Calculator();
        int res = calc.add(1, 2);
        System.out.println(res);

        Calculator calc2 = new Calculator();
        int res2 = calc2.add(1, 21.2);
        // modifying the property value on on instance of the class will not effect the
        // another instance of th same class

        calc.a = 100;
        System.out.println(res2);
        System.out.println(calc.a);
        System.out.println(calc2.a);

        int[] arr = { 1, 2, 3 };
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.println(arr[idx]);
        }

        // array declarations can be done as follows : int a[] and int[] a both are
        // valid.
        // but when multiple variables are declared and int a[],b syntax is used: a will
        // be or type array of ints where b will be an int
        int[] arr1, arr2;
        int arr3[], arr4;

        // arrays have fixed size in java
        // in order to declare an array [ without initialization ]

        int[] arr5 = new int[40];
        System.out.println(arr5.length);

        int multiArr[][] = new int[3][4];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                multiArr[row][col] = row + col;
            }
        }

        for (int row = 0; row < 3; row++) {
            System.out.println("Row: " + (row + 1) + " ");
            for (int col = 0; col < 4; col++) {
                System.out.print(multiArr[row][col] + " ");
            }
            System.out.println();
        }

        // For Loop : Type 2
        System.out.print("For Loop\n");
        for (int[] arrI : multiArr) {
            for (int num : arrI) {
                System.out.print(num);
            }
            System.out.println();
        }

        int[] arrT={11,12,13};
        for(int num:arrT){
            System.out.println(num);
        }
    }
}
