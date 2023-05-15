# 14. Exceptions

There are three type of errors.

- Compile Time Errors
- Logical Errors
- Runtime Errors

### Compile Time Errors

**Compile time errors** usually occurs when there are errors in the syntax. These errors can be identified by compiler at the time of compilation. Usually fixing the compile time errors is easy as they occur bcoz of syntax errors. Most of IDE's show these errors even before compiling and provided right syntaxt too.

`System.out.Println("Hi");` This line will throw an error as there's no method name Println. If we compile the code we will get an error saying There's no method with the name specified. In order to fix the error, we need to use **println** instead of Println .

### Logical Errors

**Logical Errors** occurs when the logic/code we wrote isn't working as we intended. The code compiles and executes but the expected result/outputs might differ. In order fix these kind of errors we need to debug and find the cause for the unexpected behaviour.

**Example**

    int a =1;
    float f = 2.2f;

    int sum = a+(int)f;
    System.out.println(sum); //3

Lets say, the expected operation is to add 1 with 2.2 and the result should be 3.2. Because we are explicitly converting the f value to int and storing the sum in an int variable instead of 3.2, we got 3 as the result. In order to fix this issue instead of converting f to int and storing sum in a int variable, we can just add both numbers and store the result in the float variable.

    float sumD = a + f;
    System.out.println(sumD); //3.2

### Runtime Errors

Errors which occur during program execution(run-time) after successful compilation are called Run-time errors. These types of error are hard to find as the compiler doesn’t point to the line at which the error occurs.

    int i=0;
    int j=2/i;

    System.out.println(j);

The above example compiles but when we try to run the code, we will get an error.

    Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Exceptions.main(Exceptions.java:16)

When there are runtime errors, Java runtime will throw exceptions which we need to handle. In the above code, there's a possibility for the divisor to be 0 which will result in an error. **Whenever there's an exception, the code execution stops and the next code will not be executed**.

In order to avoid these situations, we have to the code which has critical lines i.e, which might cause an error [ exception ] in try-catch blocks. Whenever there's an exception in our code, try block will stop the execution and throws the exception to the catch block.

**Catch block receives a param of type Exception which will have the imformation about the error thrown by the try block**. Having a try-catch block will help us to proceed to continue with executing the next line of code.

    int i = 0;
    int j = 0;
    try {
        j = 2 / i;
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }

    System.out.println(j);

**Output**

    Error: java.lang.ArithmeticException: / by zero
    0

Instead of having a single catch block, we can have multiple catch blocks. Each catch block can lookup for a specific Exception type. Whenever this particular exception was thrown, related catch block will be invoked and code inside that catch block will be executed.

**There is heirarchy we need to follow while using catch blocks**. Since. Exception is Super class to all type of exceptions, Any type of exception can be catched by the catch block which has Exception type param. So, **Other Exception types catch blocks** should be defined first and last catch block should have **Exception type** which acts as a default case.

    int i = 0;
    int j = 0;
    try {
        j = 2 / i;
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }catch(ArithmeticException e){

    }

Above code will throw an error as any exception thrown by the try block will be catched by the first catch block with Exception type param. So, there's no possibility to reach the next catch block.

    int i = 2;
    int j = 0;
    int[] arr = { 1, 2, 3, 4, 5 };
    String s = null;
    try {
        j = 2 / i;
        System.out.println(arr[4]);
        System.out.println(s.length());

    } catch (NullPointerException e) {
        System.out.println("Error: " + e);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Error: " + e);
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }

    System.out.println(j);

- if i=0, ArtithimeticException will be thrown by try block. As we don't have a catch block looking for ArithimeticException, final catch block will be invoked.

- If string s is null, NullPointerException catch block will be invoked.
- If we are trying to print arr[5] value, then ArrayIndexOutOfBoundsException catch block will be invoked.

If we want to manually throw an error, we can use **throw keyword** to throw an exception from the try block.

    int i = 3;
    int j = 0;

    try {
        j = 2 / i;
        if (j == 0) {
            throw new ArithmeticException();
        }
    } catch (ArithmeticException e) {
        System.out.println("Error: " + e); // Error: java.lang.ArithmeticException
    }

If we want to print a custom error message, we can pass the error message when we are throwing an exception as follows.

    int i = 3;
    int j = 0;

    try {
        j = 2 / i;
        if (j == 0) {
            throw new ArithmeticException("J value should not be Zero");
        }
    } catch (ArithmeticException e) {
        System.out.println("Error: " + e); // Error: java.lang.ArithmeticException: J value should not be 0.
        j=2/1;
    }

    System.out.println(j); //2

**When we define a try block**, it isn't mandatory to define a catch block but if we don't define anything after try block we will get an error. Either we need to add a catch block / we need to define a **finally block** after a try block. **finally block will be executed irrespective of having an exception case or not**.

    int num = 1;
    int b = 0;
    try {
        b = 18 / num;
    } catch (Exception e) {
        System.out.println("Error: " + e);
    } finally {
        System.out.println(b); // 18
    }

Because there's no error, finally block is executed.

if `num =0`<br>

    int num = 0;
    int b = 0;
    try {
        b = 18 / num;
    } catch (Exception e) {
        System.out.println("Error: " + e);
    } finally {
        System.out.println(b); // 18
    }

**Output**

    Error: java.lang.ArithmeticException: / by zero
    0

Catch block executed first followed by the finally block.

## Custom Exceptions

We can create our own exceptions in java. To create a custom exception we have to define a class which **extends Exception class**.

    class NewException extends Exception {
    }

    public class Exceptions{
        public static void main(String[] args){

            int num = 19;
            int b = 0;
            try {
                b = 18 / num;
                if (b == 0) {
                    throw new NewException();
                }
            } catch (NewException e) {
                System.out.println("Error: " + e);
            }
        }
    }

In the above code, when there's an exception, Only Exception name will be returned. If we want to print a custom exception message we need to pass a exception message as a string while invoking custom Exception class. In order to pass a string while invoking, we need to define constructor method that takes a string as a parameter.

    class NewException extends Exception {
        public NewException(String str){

        }
    }

Just declaring the constructor method will not work. We need to pass this string to the Exception class constructor method which accepts a string. As we discussed earlier, we can use **super** method to call the constructor method of the super class.

    class NewException extends Exception {
        public NewException(String str){
            super(str);
        }
    }

    public class Exceptions{
        public static void main(String[] args){

            int num = 19;
            int b = 0;
            try {
                b = 18 / num;
                if (b == 0) {
                    throw new NewException("b should not be 0.");
                }
            } catch (NewException e) {
                System.out.println("Error: " + e); // Error: b should not be 0.
            }
        }
    }

## Ducking Exceptions

If we have a method and there's a critical line and If we don't handle the exceptions using try-catch block, then the exception will be propagates to the method which calls this method. We can use **throws keyword** to the method to indicate the method we invoked might throw the exception specified.

    public class Exceptions {

        void func1() {
            int i = 1;
            int j = 0;
            j = 18 / i;
            System.out.println("J Value: "+j);
        }

        void func2() throws ArithmeticException {
            func1();
        }

        .....

    }

func2() method calls func1() method. using throws keyword we specified that func1 might throw an ArithimeticException. And in the main method, when func2 is called, we can use try-catch block to handle the exceptions.

    Exceptions e = new Exceptions();
    try {
        e.func2();
    } catch (Exception ex) {
        System.out.println("Propagated Error : " + ex); // Propagated Error : java.lang.ArithmeticException: / by zero
    }
