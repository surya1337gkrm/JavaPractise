# 11. Interfaces

We can use interfaces to define a design that can be used to define a class. **Interfaces are like a Abstract class but with only abstract methods**. By default all methods defined in the interface will be of type **public abstract** so we don't have to specially mention those keywords while declaring the methods in the interface.

Instead of using **extends** we have to use **implements** when we want a class to be implemented using interface we defined.

:bangbang: Classes implementing the interface must implement all the methods included in the interface or we will get an error.

    interface CalcInterface {
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

    class Interfaces {
        public static void main(String[] args) {

            Calculator calc = new Calculator();
            int res=calc.add(1,2);
            System.out.println(res);
        }
    }

Simillar to a class, we can have variables defined inside an Interface. By default, all variables defined inside the interface will be of type **public final static**. Interfaces cannot be used to create objects like class so they don't have any memory allocated in the heap memory. Since we can't initiate an interface, all the variables declared inside the interface has to be constants and accessible on the interface so the variables will be of type **public, static and final**.

    interface CalcInterface {
        int pid = 1337;

        int add(int a, int b);

        int sub(int a, int b);
    }

    class Interfaces {
        public static void main(String[] args) {
            System.out.println(CalcInterface.pid); // 1337
        }
    }

We can declare a variable of type interface we defined and assign the object of the class which implements the interface as follows.

`CalcInterface c = new Calculator();` Here c is of type CalcInterface where as we can assign the Calculator object as Calculator class implements calcInterface.

### Interface inheriting another Interface

An interface can inherit another interface. Methods defined on parent interface will be available in the child interface. A class implementing the child interface should implement methods defined in both parent and child interfaces.

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

    class Interfaces {
        public static void main(String[] args) {

            S sample = new S();
            sample.print(); // In S.
            sample.printInt(1337); // 1337
        }
    }

In the above example, we can create a variable of **type A** and assign the object of class S. Eventhough S has both print and printInt methods defined, Interface A has only print method defined. So Variable of type A will have only access to print method. If we need to access printInt method then we need to create a variable of type B and assign the object to it.

:bangbang: Since B extends Interface A, variable of type B which has object of class S will have access to both methods.

    A obj=new S();
    obj.print(); // In S.

    // obj.printInt(); //Error

    B obj2=new S();
    obj2.print(); // In S.
    obj2.printInt(1336); //1336

### Inheriting Multiple Interfaces

Unlike classes, Interfaces helps us to simulate multiple inheritance. We can implement multiple interfaces when defining a class.

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
            NewString n = new NewString();
            n.setString("Surya");
            System.out.println(n.getString()); // Surya
        }
    }

There are three types of Interfaces.

- Normal Interface
- Functional Interface
- Marker Interface

In Normal Interface, we can have as many methods declared as possible. Where as in Functional Interface, we can have only one method declared. Functional Interfaces is also called as **Single Abstract Method [SAM]**. A **Marker Interface** is an interface without any methods (or an empty interface).
