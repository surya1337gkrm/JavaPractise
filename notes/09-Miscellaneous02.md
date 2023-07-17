# 09. Miscellaneous - Part 02

### Final Keyword

We can use **final keyword** to declare variables,classes & methods.

#### Variables declared using Final keyword

**Variables declared using final keyword will be treated as constants** in java. We cannot modify the value of the variable once initialized.

    class Main{
        public static void main(String[] args){
            final int a=10;
            a=11;

            System.out.println(a);
        }
    }

Above example throws an error. `a is a constant` and we cannot re-assign values to it.

#### Classes declared using Final Keyword

**Classes declared with final keyword cannot be inherited**. Trying to inherit the class declared with final keyword will throw an error.

    final class A{
        public void print(){
            System.out.println("In A.");
        }
    }

    //throws an error
    class B extends A{
        // class implementation
    }

#### Methods declared using Final Keyword

**Methods declared using final keyword will be protected from overriding in the child class**.

    class A2 {
        final public void print() {
            System.out.println("in A2.");
        }
    }

    class B extends A2{
        //throws an error
        public void print(){

        }
    }

Cannot override print method in class B which inherited class A2.

### Wrapper Classes

There will be cases where we need to use only Objects like when we deal with **Collection class**. In java primitive data types like int,double,byte etc aren't objects. But java provides Wrapper classes which we can use to declare primitive data types.

int -> Integer<br>
double -> Double<br>
char -> Charecter<br>

`Integer i =new Integer(3);` Here, we are taking a primitive value and storing in an object. This is called **Boxing**. [ :warning: This syntax is deprecated. ]

We can directly assign primitive values to the wrapper class objects as follows.
`Integer i =3;` This is automatically converts the value to the wrapper class object and this is called as **Autoboxing**.

Simillarly to convert the wrapper class object to primitive value we can call few methods defined on the wrapper class as follows.

    Double i =3.0;
    double d= i.doubleValue();

    Integer num = 3;
    int n=num.intValue();

Using these methods to convert the wrapper class object valuie to primitive value is called as **Unboxing**. Simillarly, we can directly assign Wrapper class object value to a primitive data type variable and the conversion will be done automatically and this is called as **Auto Unboxing**.

    Integer num = 3;
    int n=num.intValue();

There are multiple methods defined on the wrapper class objects.

**Example**<br>

    class Main{
        public static void main(String[] args){
            String s="12";
            System.out.println(Integer.parseInt(s)); //12
        }
    }

We can call `parseInt` method on Integer wrapper class to convert a string to an integer. If the string can't be converted to an integer, then it will throw an error.
