class A extends Thread {
    public void run() {
        System.out.println("Hi");
    }
}

class NewException extends Exception {
    public NewException(String str) {
        super(str);
    }
}

public class Exceptions {

    void func1() {
        int i = 0;
        int j = 0;
        j = 18 / i;
        System.out.println("J Value: " + j);
    }

    void func2() throws ArithmeticException {
        func1();
    }

    public static void main(String[] args) {
        // Compile Time Error
        // System.out.Println("Hi");

        int a = 1;
        float f = 2.2f;

        int sum = a + (int) f;
        System.out.println(sum);

        float sumD = a + f;
        System.out.println(sumD);

        // int i=0;
        // int j=2/i;

        // System.out.println(j);
        int i = 3;
        int j = 0;
        int[] arr = { 1, 2, 3, 4, 5 };
        String s = "";
        try {
            j = 2 / i;
            if (j == 0) {
                throw new ArithmeticException("J value should not be 0.");
            }
            System.out.println(arr[4]);
            System.out.println(s.length());

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
            j = 2 / 1;
        } catch (NullPointerException e) {
            System.out.println("Error: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println(j);

        int num = 19;
        int b = 0;
        try {
            b = 18 / num;
            if (b == 0) {
                throw new NewException("B shouldn't be 0.");
            }
        } catch (NewException e) {
            System.out.println("Error: " + e);
        }

        catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println(b);
        }

        Exceptions e = new Exceptions();
        try {
            e.func2();
        } catch (Exception ex) {
            System.out.println("Propagated Error : " + ex);
        }

        A obj = new A();
        obj.start();

    }
}