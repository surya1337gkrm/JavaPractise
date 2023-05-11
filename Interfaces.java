interface CalcInterface {
    int pid = 1337;

    int add(int a, int b);

    int sub(int a, int b);
}

class Calculator implements CalcInterface {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

interface A {
    void print();
}

interface B extends A {
    void printInt(int a);
}

class S implements B {
    public void print() {
        System.out.println("In S.");
    }

    public void printInt(int a) {
        System.out.println(a);
    }
}

interface X {
    String getString();
}

interface Y {
    void setString(String str);
}

class NewString implements X, Y {
    private String str;

    public void setString(String str) {
        this.str = str;
    }

    public String getString() {
        return str;
    }
}

class Interfaces {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int res = calc.add(1, 2);
        System.out.println(res);
        System.out.println(CalcInterface.pid);

        CalcInterface c = new Calculator();

        S sample = new S();
        sample.print();
        sample.printInt(1337);

        A obj = new S();
        obj.print();

        // obj.printInt(); //Error

        B obj2 = new S();
        obj2.print();
        obj2.printInt(1336);

        NewString n = new NewString();
        n.setString("Surya");
        System.out.println(n.getString());
    }
}
