//defining an abstract class

abstract class A {
    public abstract void print();

    public void show() {
        System.out.println("Show Method.");
    }
}

class B extends A {
    public void print() {
        System.out.println("In B.");
    }
}

class C {
    int i = 10;

    public void print() {
        System.out.println("In C");
    }

    class Inner {
        public int getNumber() {
            return i;
        }
    }
}

class D {
    int i = 10;

    public void print() {
        System.out.println("In D");
    }

    static class Inner {
        public void print() {
            System.out.println("Static Inner Class.");
        }
    }
}

class Example {
    public void print() {
        System.out.println("In Example Class.");
    }
}

class Example2 extends Example {
    public void print() {
        System.out.println("In Extended Class.");
    }
}

abstract class classA {
    public abstract void print();
}

class Practise {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();
        obj.show();

        C objC = new C();
        objC.print();

        C.Inner objInner = objC.new Inner();
        System.out.println(objInner.getNumber());

        D.Inner objI = new D.Inner();
        objI.print();

        Example ex1 = new Example();
        ex1.print();

        // dynamic method dispatch
        Example exam = new Example2();
        exam.print();

        Example ex2 = new Example2();
        ex2.print();

        Example ex = new Example() {
            public void print() {
                System.out.println("In Anonymous Inner Class.");
            }
        };

        ex.print();

        classA objA = new classA() {
            public void print() {
                System.out.println("In Abstract Implementation using Anonymous Inner Class.");
            }
        };

        objA.print();

    }
}
