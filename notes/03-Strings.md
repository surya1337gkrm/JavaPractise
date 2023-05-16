# 03. Strings

String is a **Collection of characters** enclosed with double quotes. By default strings are immutable in Java. String isn't a primitive data types in Java.

We will define a string using **String** keyword followed by a variable name to store the string. Here, we are referring to **String** class to declare a string unlike other data types like int,double etc..

`String str="Surya";`

We can also use object syntax to create the string. `String str=new String("Surya");` is a valid syntax to create a string.

When we create a string, string will be created inside the heap memory and variable name and memory address of the string in the heap will be stored inside the stack. Inside heap, there's a special memory area called **String Constant Pool**. When we are creating a new string, string value will be stored in this memory area and memory address will be referred in the stack. JVM will search this memory area whenever a new string is being created. if there's a same value present in the memory address, instead of creating new string JVM will store the address of previous vlaue in the stack. So, **Two strings with same value will be referencing the same memory address**.

    String s1="Surya";
    String s2="Surya";

    System.out.println(s1==s2); //true

If we are concatating the string s1 with "Hello", this will not modify s1. Instead, String concatenation will be done and result string will be stored in new memory address. **If we are assigning the result string to the same variable, reference to the previous memory address will be removed from the stack and new memory address will be stored**. And, previous string value in the heap memory will be **garbage collected**.

    String s1="Surya";
    s1="Hello "+s1;
    
We can use **concat** method on the string to concat a string to the exisiting string. As strings are immutable, concatating a string will not change the original string.Instead, A new string will be created in the heap memory with the concated string. 

    String s = "Surya";
    s.concat(" Venkatesh");
    System.out.println(s); // Surya
    
 In the above example, printing s will still print **Surya** as after concating as s will unmodified, s will still refer to the original value. But the new string value will be in the heap memory. In order to access new value we need to store it in a variable as follows.
 
    String s = "Surya";
    String a= s.concat(" Venkatesh");
    System.out.println(a); // Surya Venkatesh
    
**charAt** method on a string returns the character at the index specified. 

**join** method can be used to join multiple strings into one string.
`String.join(delimiter,StringArray)`

    String[] arr ={"Surya","Venkatesh","vijjana"};
    String name = String.join(" ",arr);
    System.out.println(name); // Surya Venkatesh Vijjana
        
        
## StringBuffer and StringBuilder

In order to create a mutable string, we can use StringBuilder/StringBuffer. [ **Note: StringBuffers are Thread safe whereas StringBuilders aren't thread safe**. ]<br>

When initiated a StringBuffer without any input string to start with, it will return a buffer of size 16 bytes. Whenever we create a string, it requires continous memory to store the characters. So, if we don't have an access to the continous memory when trying to modify the string we created using StringBuffer, modification will not be possible.<BR>

To avoid this situation, **StringBuffer allocates default size of 16 Bytes**. And if we initiates the StringBuffer with a default string, then default capacity of the StringBuffer will be **length of the string + 16 Bytes**.

    StringBuffer sb=new StringBuffer();
    System.out.println(sb.capacity()); //16

    //initiating StringBuffer with a default string
    StringBuffer sb2=new StringBuffer("Surya");
    System.out.println(sb2.capacity()); //21

calling length method on the StringBuffer object returns the length of the string stored.
`sb.length()` //5<br>

Use append method to append a string to the existing StringBuffer object.

    sb.append(" Venkatesh");
    System.out.println(sb); //Surya Venkatesh

Calling .toString() method on the StringBuffer buffer converts the buffer to a string and returns the string.

`System.out.println(sb.toString());`<br>

To insert a string at a specified index, we can use **insert** method.

     sb.insert(0,"Vijjana ");
     System.out.println(sb); //Vijjana Surya Venkatesh
