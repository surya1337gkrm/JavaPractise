# 04. Static

## Static Variables

Inside a class definition, the variables which we create will be Instance variables by default i.e, each variable will have different values based on the instances of the class. In order to maintain same value across different instances of the class, we have to initiate the variable using the **static** word.

Static variables can be accessed/modified uisng the instances of the classes i.e, objects but it isn't advised. We can access the static variables directly using the className as follows.

    class Person {
        static String role;
        int id;
        String name;

        public void print() {
            System.out.println(role + " " + id + " : " + name);
        }
    }

    class Main{
        public static void main(String[] args){
            Person.role = "Student";
            Person p1 = new Person();
            p1.id = 1;
            p1.name = "Surya";

            Person p2 = new Person();
            p2.id = 2;
            p2.name = "Maddy";

            p1.print(); // Student 01 : Surya
            p2.print(); // Student 02 : Maddy
        }
    }

Here, in the class definition of **Person**, **role** is a Static Variable. To initiate the role variable outside the class, we need to use className and initiate the variable.

`Person.role="Student";`<br>

This static variable isn't specific to any instance of the class. Instead, the value of the static variable remains same for all instances of the class. **Changing the static value on one instance of the class, will make the changes for all instances of the class**.

    p1.role="Employee";
    p1.print(); // Employee 01 : Surya
    p2.print(); // Employee 02 : Maddy

## Static Methods

Simillar to the static variables, Inside the class definition we can declare a method as a **static method** using static keyword. And static methods can be called directly using the className.

    class Person {
        static String role="Student";
        int id;
        String name;

        public static void print() {
            System.out.println("Role: "+role);
        }
    }
    class Main{
        public static void main(String[] args){
            Person.print()
        }
    }

In the example, print is a static method which can be called directly on the className.

`Person.print()` // Role: Student

However, static methods cannot have the access to the instance variables directly as instance variables will be created/initialised when the object is instantiated. So, referring to an instance variable will throw an error. **In order to access the instance variables inside the static method, we need to pass the reference to the object created to the static method**.

**Example**

    class Person {
        static String role="Student";
        int id;
        String name;

        public static void print(Person p) {
            System.out.println("Role of "+p.name+" : "+role);
        }
    };

    class Main{
        public static void main(String[] args){
            Person p1=new Person();
            p1.id=1;
            p1.name="Surya";
            Person.print(p1);
        }
    }

## Static Block

### Constructor

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
