import calc.*;

class SampleExtended extends Calc {
    public void print() {
        System.out.println("Sample Extended :" + pid);
    }
}

final class A {
    public void print() {
        System.out.println("In A.");
    }
}

class A2 {
    final public void print() {
        System.out.println("in A2.");

        
    }
}

class B extends A2 {
    // Cannot ovverride
    // public void print(){

    // }
}

// class declared with final keyword cannot be inherited.
// class B extends A{

// }

class Main {
    public static void main(String[] args) {
        AdvCalc cal = new AdvCalc();
        int res1 = cal.add(1, 2);
        int res2 = cal.mul(1, 2);
        System.out.println(res1 + " " + res2);

        // Calc c = new Calc();
        // System.out.println(c.pid);

        Sample s = new Sample();
        s.print();

        SampleExtended se = new SampleExtended();
        se.print();
    }
}
