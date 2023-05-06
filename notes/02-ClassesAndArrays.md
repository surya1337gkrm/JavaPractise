# 03. Classes And Arrays

## Classes

Everything in java should be enclosed **inside a class.**

**Class** is a blueprint or design whereas an **Object** is an instance of the class.

Classes contain **Properties** and **Methods**. In order to access the methods on a class object, those methods should be prefixed with **public** keyowrd followed by the return type of the method. **if the method doesn't return anything, then return type should be _void_**.

Classes can be created in seperate files and imported in our main file or we can create the class in the same file.

**Example**<br>

    class Calculator{
        //a is a class property
        int a=10;

        //add is method which returns an int
        public int add(int n1,int n2){
            return n1+n2;
        }
    }

In order to access property or method of Calculator class, **We need to create an instance of the class i.e, Object**. To declare the object, Speicify the class followed the varialble name. Intialize the class instance using **new** key word followed by the class Name as follows.

    class Main{
        public static void Main(String[] a){
            Calculator calc=new Calculator();

            //Now we can access properties & Methods defined in Calculator class
            //Using the Object we created.

            int res=calc.add(1,2);
            System.out.println(res); //4
            System.out.println(calc.a); //10
        }
    }

We can create multiple instances of a class and each instance of the class are different to each other. So, changing the property of one instance will not effect another instance of class.

    class Main{
        public static void Main(String[] a){
            Calculator calc=new Calculator();
            Calculator calc2=new Calculator();

            //modifying the value of a for calc object
            calc.a=100;
            System.out.println(calc.a); //100
            System.out.println(calc2.a); //10
        }
    }

## Method Overloading

Inside the class definition, we can define multiple methods with same name but with different input parameters [ can be different number of params or diff type of params ].

    class Calculator{
        //a is a class property
        int a=10;

        //add is method which returns an int
        //Method 01
        public int add(int n1,int n2){
            return n1+n2;
        }

        //Method 02
        public int add(int n1,int n2, int n3){
            return n1+n2+n3;
        }
    }

    class Main{
        public static void Main(String[] a){
            Calculator calc=new Calculator();

            int res=calc.add(1,2); //calls Method 01
            int res2=calc.add(1,2,3); // calls Method 02
        }
    }

Respective Method will be called based on the arguments provided.

## Arrays

Arrays is a collection of simillar typed data. **Arrays has fixed size** in Java. Arrays are referential data type. [ Variable name and reference to the memory address in heap will be stored in the stack ]. To declare an array, speicify the data type the array holds followed by **[]** notation.

**Example**: `int[] arr` //declared an empty array.

To initialize the array, values need to be assigned using **{ }** syntax. Size of the array will be determined based on the numbers of values passed.<br>
`int[] arr = {1,2,3};`

**Another way to declare an array**<br>

`int[] arr = new int[10];`<br>
Array **arr** will be declared and initialised with all zero values and size of the array will be **10**.

    Array declarations can be done in 2 ways
    int arr[] and int[] arr - both are valid.

    But when multiple variables are declared and int a[],b syntax is used:
    a will be of type array of ints where b will be an int

        int[] arr1, arr2; //arr1 & arr2 are arrays of ints.
        int arr3[], arr4; //arr3 is an array of ints & arr4 is an int.


**We can iterate through the array in 2 Ways**.

    //Method 01 - Using for loop & array length property
    for (int idx = 0; idx < arr.length; idx++) {
            System.out.println(arr[idx]);
        }

    //Method 02 : Enhanced For Loop
    for(int num : arr){
        System.out.println(num);
    }

## Multidimensional Arrays

Syntax for Multidimensional Arrays[ 2D Array ]
`int multiArr[][] = new int[3][4];`

Use two loops to iterate through the array. one foor loop to iterate through arrays in array of arrays and another for loop to iterate through elements of each array.

    for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(multiArr[row][col] + " ");
            }
            System.out.println();
        }

        // Enhanced For Loop
        for (int[] arrI : multiArr) {
            for (int num : arrI) {
                System.out.print(num);
            }
            System.out.println();
        }


Simillarly, if we want to create a 3D Array. `int[][][] arr=new int[2][3][4];` creates a 3D array.

## Jagged Arrays

In Multi-dimensional arrays, if the arrays are of different size are stored in the multi dimensional array then those arrays are called **Jagged Arrays**. To define a jagged array, we will the same syntax we used to create a multi dimensional array. But, we will not mention the inner arrays size. Instead, we have to manually assign the arrays as below.

    class Main {
        public static void main(String[] args) {
            int[][] arr=new int[3][];
            arr[0]=new int[3];
            arr[1]=new int[4];
            arr[2]=new int[2];


            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[row].length; col++) {
                    System.out.print(arr[row][col] + " ");
                }
                System.out.println();
            }
            System.out.print("Enhanced for loop\n");
            for (int[] arrI : arr) {
                for (int num : arrI) {
                    System.out.print(num+" ");
                }
                System.out.println();
            }
        }
    }

## Array of Objects

We can create an array of objects just like how we created arrays of primitive types.

    class Student{
        String name;
        int id;
    }
    class Main{
        public static void main(String[] args){
            //creating multiple objects
            Student s1=new Student();
            s1.name="Surya";
            s1.id=1337;

            Student s2=new Student();
            s2.name="Maddy";
            s2.id=1338;

            //creating an array of objects
            Student[] students = new Student[2];

            students[0]=s1;
            students[1]=s2;

            for(Student student:students){
                System.out.print(student.name+" ");
            } //Surya Maddy
        }
    }
