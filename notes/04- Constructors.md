# 04. Constructors

Each class will have a constructor method which will have same name as the class name. We can use the constructor block to initialize the values whenever an instance of the class is created.

**Constructor method will be called first whenever a class is invoked**. Constructor method will not return anything.

    class Person {
        static String role="Student";
        int id;
        String name;

        public Person(){
            System.out.println("Constructor");
            id=1337;
            name="Surya";
        }

        public static void print(Person p) {
            System.out.println("Role of "+p.name+" : "+role);
        }
    };

    class Main{
        public static void main(String[] args){
            Person p1=new Person();
            Person.print(p1);
        }
    }

In the above example code, **Constructor function will be invoked immediately when the Person class in invoked**.

If the **constructor method is declared as private method using private keyword, then we cannot create an instance of the class**. Trying to create an object will throw an error. This pattern will be used when we only want to use **static methods on the class in our code wihtout creating any objects**.

    class Person {
        static String role="Student";
        int id;
        String name;

        private Person(){
            System.out.println("Constructor");
            id=1337;
            name="Surya";
        }

        public static void print() {
            System.out.println(role);
        }
    };

    class Main{
        public static void main(String[] args){
            Person.print();
        }
    }

In the above example, we are only using static method print on the Person class without creating an object.

## Parameterized Constructor

At the moment, we are only hardcoding the values of the instance variables in the constructor method. We can take dynamic values when we initiate the new instance of the class using **Parameterized Constructor**.

    class Person {
        int id;
        String name;

        public Person(){
            id=1337;
            name="Surya";
        }

        public void print() {
            System.out.println(id+". "+name);
        }
    };

    class Main{
        public static void main(String[] args){
            Person p1=new Person();
            p1.print();
        }
    }

In the above example, we are hardcoding values for both **id and name** instance variables inside the constructor method.

    class Person {
        int id;
        String name;

        public Person(int n,String s){
            id=n;
            name=s;
        }

        public void print() {
            System.out.println(id+". "+name);
        }
    };

    class Main{
        public static void main(String[] args){
            Person p1=new Person(1,"Surya Venkatesh");
            p1.print();
        }
    }

Here, we are using parameterized constructor method that takes a int & a String variables are parameters. When initiating a object we need to pass these data or else it will throw an error.

## Constructor Overloading

We can have multiple implementations of the constructor defintions inside the class definition just like **Method Overloading**. Based on the arguments passed while creating the objects, related constructor method will be called.

    class Person {
        int id;
        String name;

        public Person(){
            id=1337;
        }

        public Person(int n,String s){
            id=n;
            name=s;
        }

        public void print() {
            System.out.println(id+". "+name);
        }
    };

    class Main{
        public static void main(String[] args){
            Person p1=new Person();
            p1.print(); //1337. null
            p1.name="Surya";
            p1.print(); //1337. Surya

            Person p2=new Person(1,"Maddy");
            p2.print(); // 1. Maddy
        }
    }

We have two constructor methods defined inside the class definition. When the first object **p1 is created**, No arguments is passed which will call first implementation of the constructor method. Inside the first implementation, name isn't initialized so **default value will be null**. When **Object p2 is created** with 2 arguments, second implementation of the constructor method is called.

First implementation without the paramaters is generally called as **Default Constructor**. If the constructor method isn't explicitly defined inside the class, **At the compilation this default constructor is created and variables are initialized to null values**.
