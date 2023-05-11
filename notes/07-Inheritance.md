# 07. Inheritance

When we have a class with few methods defined in it, and if we want to inherit all those methods in another class, we can use **Inheritance**. In simple terms, **we can create new classes based on the existing classes and extend them by defining our own properties and methods on it**.

Suppose we have a **class A** and if we want to create a **class B** that has all methoda and properties of class A we need to use **extends keyword** while defining class B as follows.

    class A{
        int a=10;
        public void print(){
            System.out.println("in A. a: "+a);
        }
    }

    class B extends A{
        public void printB(){
            System.out.println("in B. a: "+a);
        }

    }

    class Main {
        public static void main(String[] args) {

            B b=new B();
            b.print(); // in A. a: 10
            b.printB(); // in B. a: 10

        }
    }

**Class B** extends **Class A** i.e, class B will have access to **print method** of class A and **variables declared** inside class A.

## Multi-Level Inheritance

We can also inherit from multiple classes in heirarchial order.

    class A{
        int a=10;
        public void print(){
            System.out.println("in A. a: "+a);
        }
    }

    class B extends A{
        public void printB(){
            System.out.println("in B. a: "+a);
        }
    }

    class C extends B{
        int a=101;
        public void printC(){
            System.out.println("in C. a: "+a);
        }
    }


    class Main {
        public static void main(String[] args) {

            C c=new C();
            c.print();  // in A. a: 10
            c.printB(); // in B. a: 10
            c.printC(); // in C. a: 101

        }
    }

**Class B extends class A and Class C extends Class B** i.e, B has all the properties and methods defined in class A and we are inheriting all methods and properties of class B [ that also included properties we inherited from class A ] into class C. This type of inheritance from multiple levels is called as **Multilevel Inheritance**.

There's an another inheritance concept called **Multiple Inheritance** i.e, inheriting from multiple classes into one. In multilevel inheritance, we are inheriting from multiple classes but there's a difference as we are inheriting in heirarchy. From A->B->C.

Where as in multiple inheritance, we need to inherit from different classes at once. And in java **Multiple Inheritance isn't allowed** due to ambiguity error. In simple terms, if there is a same method defined in both classes, the class which inherits both classes will have an issue when it has to choose the method either from 2 classes.

**Example**<br>

    //This isn't a vlaid code in java. But consider this an example.
    class A{
        public void print(){
            // Implementation
        }
    }

    class B{
        public void print(){
            // Implementation
        }
    }

    class C extends A,B{

    }

In the above code, if we have a class C that extends both A & B, and if we need to call print method in class C, it can't decide which print method it needs to refer. This is called as **Ambiguity issue**. In order to avoid this problem, **Multiple Inheritance isn't supported in Java**.

## This & Super Method

When a class inherits from another class, class which inherits is called as **Child class / Sub class** and the class which is inherited is called as **Parent class / Super class**. Each class constructor defaultly calls a special method called **super method**. If it's not called explicitly, it will be included during the compile time.

When **super method** is called, Constructor method of the super/parent class is called.

    class A{
        public A(){
            System.out.println("In A.");
        }
    }

    class B extends A{
        public B(){
            System.out.println("In B.");
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B();
        }
    }

**Output**

    In A.
    In B.

When the Object b is initiated, constructor method of Class B will be called first. And then **super method** will be called [ even if it's not explicitly called in the constructor method ]. So, Constructor method of class A is called.

if **Constructor Method is overloaded**, in order to call the parameterized constructor of the parent class, we can pass the arguments that the parent constructor requires to the super method.

    class A{
        public A(){
            System.out.println("In A.");
        }

        public A(int a){
            System.out.println("Parameterized Constructor.");
        }
    }

    class B extends A{
        public B(){
            super(1);
            System.out.println("In B.");
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B();
        }
    }

**Output**

    Parameterized Constructor.
    In B.

Simillar example with calling the parameterized constructor.

    class A{
        public A(){
            System.out.println("In A.");
        }

        public A(int a){
            System.out.println("Parameterized Constructor A.");
        }
    }

    class B extends A{
        public B(){
            super();
            System.out.println("In B.");
        }

        public B(int b){
            super(2);
            System.out.println("Parameterized Constructor B.");
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B(1);
        }
    }

**Output**

    Parameterized Constructor A.
    Parameterized Constructor B.

**Call to Super Method should be the first statement inside the constructor method**.

In parent class, if we want to call both constructor methods we can use **this keyword**. As **this refers to the current object**, using this as a method, will call the constructor method of the current class.

    class A{
        public A(){
            System.out.println("In A.");
        }

        public A(int a){
            this();
            System.out.println("Parameterized Constructor A.");
        }
    }

    class B extends A{
        public B(){
            super();
            System.out.println("In B.");
        }

        public B(int b){
            super(2);
            System.out.println("Parameterized Constructor B.");
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B(1);
        }
    }

**Output**

    In A.
    Parameterized Constructor A.
    Parameterized Constructor B.

## Method Overriding

When we inherited a class, we can override the methods defined on the parent class. We can implement the same method in the child class.

    class A{
        public void print(){
            System.out.println("In A.");
        }
    }

    class B extends A{
        public void print(){
            System.out.println("In B.");
        }
    }

    class Main{
        public static void main(String[] args){
            B b=new B();
            b.print(); //In B.
        }
    }

**Class B** has access to method print but the method was overrided in class B.
