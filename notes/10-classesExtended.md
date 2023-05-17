# 10. Abstract & Inner Classes

We can just define a class with methods we want to include in the class but don't define them. Anyone who wants to use the class can write their own implementation for those methods when the class and methods are declared as **Abstract**.

- When a method is defined as Abstract, then the **class should be declared as abstract too**.
- Method should be declared but not defined. [ don't include {} after the method declaration ]
- **We cannot create objects of the abstract class directly**. If we want to create an object of an abstract class, we have to **inherit the abstract class and should define the abstract method and use this child class to create the object**.

    abstract class A {
    public abstract void print();
    }

    class B extends A {
    public void print() {
    System.out.println("In B.");
    }
    }

    class Practise {
    public static void main(String[] args) {
    A obj = new B();
    obj.print();
    }
    }

A is an abstract class with a abstract method print declared in it. In order to create an object of class A, we need to create a child class of class A and must define the abstract method in it or else it will throw an error.

:heavy_exclamation_mark: **An abstract class can contain abstract methods, methods or both combined**. If abstract class has both abstract method and normal method, child class must define abstract class and can have access to the other methods defined in the abstract class.

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

## Inner Class

We can nest classes i.e, we can define a class inside a class. **Inner class will have access to the outer class variables & methods**. To create an object of inner class first we need to create an object of the outer class and then create a new object of inner class using the outer class object.

**inner class type will be \<inner class name>.\<outer class name>**

When compiled, in addition to outer class file, another class file will be generated with following format. `<Outer class Name>$<Inner class Name>.class`

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

    class Practise {
        public static void main(String[] args) {
            C objC = new C();
            objC.print(); // In C

            C.Inner objInner = objC.new Inner();
            System.out.println(objInner.getNumber()); //10
        }
    }

class C has an inner class named **Inner** which has access to `variable i and method print`. A method named `getNumber` is defined inside the Inner class. In order to access the getNumber method we need to create the object for inner class.

To create the object of **Inner class**, we created Outer class ( class C ) object first. Inner class object will bee of type `C.Inner` and using Outer class object (objC) we have initiated a object of outer class [ `objC.new Inner()` ].

When compiled in addition to C.class file, **C$Inner.class** will be created.

### Static Inner Class

If the inner class is defined using **static keyword**, then instead of creating an object of outer class to access inner class, we can directly create inner class object using Outer class just like how we access static methods defined inside a class.

:heavy_exclamation_mark: We cannot access variables / methods which aren't static defined in outer class inside the static inner class.

    class D {
        int i=10;
        public void print() {
            System.out.println("In D");
        }

        static class Inner {
            public void print() {
                System.out.println("Static Inner Class.");
            }
        }
    }

    class Practise {
        public static void main(String[] args) {
            D.Inner objI = new D.Inner();
            objI.print(); // Static Inner Class
        }
    }

### Anonymous Inner Class

When we want to override a method defined in the parent class, we have to create a new class and override the method in the child class. If we only use this new child class only once, instead of creating a new class we can use **Anonymous Inner Classes**.

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

    class Practise{
        public static void main(String[] args){

            Example ex1 = new Example();
            ex1.print(); // In Example Class

            // dynamic method dispatch [ Upcasting ]
            // here creating an object of Example2 and assigning to type Example.
            //Since the method is overrided, Example type refers to the overrided method.

            Example exam = new Example2();
            exam.print(); // In Extended Class

            Example ex2 = new Example2();
            ex2.print(); // In Extended Class.
        }
    }

This is how we usually override the method of the parent class. Example is the parent class and Example2 is the child class.

Instead of creating new class, we can use Anonymous Inner Class to override the parent class methods. **In order to define Anonymous Inner Class, after defining an object of the parent class add { } and write the override implementation as follows**.

    Example ex = new Example() {
            public void print() {
                System.out.println("In Anonymous Inner Class.");
            }
        };

    ex.print(); // In Anonymous Class

Here, `ex` is an object of **type Anonymous Inner class defined on Example class**.

### Abstract and Anonymous Inner Class

Instead of creating a new child class to implement the abstract method of the abstract class, we can use **Anonymous Inner Class**.

    abstract class classA {
        public abstract void print();
    }

    class Practise {
        public static void main(String[] args) {

            classA objA = new classA() {
            public void print() {
                System.out.println("In Abstract Implementation using Anonymous Inner Class.");
            }
        };

        objA.print();  // In Abstract Implementation using Anonymous Inner Class.
        }
    }

:bangbang: We cannot create an object of Abstract class but here we aren't creating the object of abstract class. Here `objA` refers to the Anonymous Inner class.
