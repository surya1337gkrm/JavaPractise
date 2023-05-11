# 08. Miscellaneous

## Packages

When our application grows, we need organize the code files in an order. We can split our code to multiple files to organize them. Splitting each class to a seperate .java file and declare them as a **Package**. Packages are simply directories in java.

On top of the class file, we need to declare this file as a package using package keyword as follows. when we declare a package those class files should be moved to the directory with the package name.

if the package we declared is **test**, we should move our class files to the **test directory**. if there are sub-directories, package name should have the root directory followed by the sub directory joined by a period(.)

`package calc; // directory calc -> class files` <br>
`package test.utils; // root directory test -> utils -> class files`

_When we have class file in the same directory/package, we don't need to declare them using Public keyword_

Now we can import these packages into our code using **import** keyword. if we wan't to import all files in the package we can use `*` or we can import the class which we want to use in our code.

**Example**

**calc/Calc.java**

    package calc;
    public class Calc {
        public int add(int a, int b) {
            return a + b;
        }

        public int sub(int a, int b) {
            return a - b;
        }
    }

**calc/AdvCalc.java**

    package calc;
    public class AdvCalc extends Calc {
        public int mul(int a, int b) {
            return a * b;
        }

        public int div(int a, int b) {
            return a / b;
        }
    }

Importing the package in the mail file. <br>
**Main.java**

    import calc.Calc;
    import calc.AdvCalc;

    class Main {
        public static void main(String[] args) {
            AdvCalc cal = new AdvCalc();
            int res1 = cal.add(1, 2);
            int res2 = cal.mul(1, 2);
            System.out.println(res1 + " " + res2);
        }
    }

In the above example, we are importing classes individually from the package. Instead we can use \* syntax and import all classes from the package.

    import calc.*; //import everything from calc package

    class Main {
        public static void main(String[] args) {
            AdvCalc cal = new AdvCalc();
            int res1 = cal.add(1, 2);
            int res2 = cal.mul(1, 2);
            System.out.println(res1 + " " + res2);
        }
    }

Generally, when we are developing a library our package names shoule be unique. For local development we can name our packages as we like. But when deploying our application and creating libraries for public use, it's advised that our package names are unique.

Generally, we use reversed domain name as our package name. Suppose, our domain name is **example.com**, then we declare our package as **com.example**.

## Access Modifiers

There are 4 types of access modifiers in java. **Public, Private, Protected and Default**.

### Public

If we need to access a property or method defined of a class, by default we cannot access those properties / methods. Properties/Methods declared using public keyword can be accessed from anywhere. [ Same class / Package / Inherited classes ]

**calc/Calc.java**

    package calc;
    public class Calc {
        public int pid =1337;
    }

**Main.java**

    import calc.*;

    class Main {
        public static void main(String[] args) {
            Calc c = new Calc();
            System.out.println(c.pid); //1337
        }
    }

### Private

Properties / Methods declared using **Private keyword** can be accessed only from the same class. We will not access to those properties and methods outside of the class.

    class A{
        private int p=1;
    }

    class B extends A{
        public void print(){
            System.out.println(p);
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B();
            b.print();
        }
    }

Above code throws an error as p is declared using private and we cannot access it outside of the class it is defined.

    class A{
        int p=1;
    }

    class B extends A{
        private void print(){
            System.out.println(p);
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B();
            b.print();
        }
    }

Simillarly this code throws an error as print method is declared as a private method and we cannot access it outside the class it's defined.

### Default

When a access modifier isn't specified, **Default** access modifier will be present. When a property / method is defined using default access modifier it can be accessed in the same package.

**calc/Calc.java**

    package calc;
    public class Calc {
        int pid =1337;
    }

Declared variable `pid` with default access modifier.

**calc/Sample.java**

    package calc;

    public class Sample {
        public void print() {
            Calc c = new Calc();
            System.out.println("Default: "+c.pid);
        }
    }

Accessed the pid variable on Calc class. It is possible as variables/methods declared using default access modifiers can be accessed in the same package. Sample is present in the same package (calc).

**Main.java**

    import calc.*;

    class Main {
        public static void main(String[] args) {
            Sample  s=new Sample();
            s.print(); // Default: 1337
        }
    }

### Protected

If properties / Methods declared using **Protected**, then they will be visible and can be accessed in the **same package and in the classes that inherits the class in which they are defined**.

**calc/Calc.java**

    package calc;
    public class Calc {
        protected int pid =1337;
    }

**Main.java**

    import calc.*;

    class Main {
        public static void main(String[] args) {
            Calc c = new Calc();
            System.out.println(c.pid);
        }
    }

This code will throw an error as `pid` is protected and can only be accessed either from the same package or in the classes that extends `Calc` class.

**calc/Sample.java**

    package calc;

    public class Sample {
        public void print() {
            Calc c = new Calc();
            System.out.println("Default: "+c.pid); //Default : 1337
        }
    }

This works as Sample class belongs to same package as Calc class.

**Main.java**

This works because SampleExtended class extends/inherits Calc class.

    import calc.*;

    class SampleExtended extends Calc {
        public void print() {
            System.out.println("Sample Extended :"+pid);
        }
    }

    class Main {
        public static void main(String[] args) {
            SampleExtended se = new SampleExtended();
            se.print(); // Sample Extended : 1337
        }
    }
