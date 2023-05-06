# 02. Variables

Whenever we build applications, we will do processing on the data [ from user/ from DB etc.. ]. Data stored ina DB is persistant or permanent storage i.e, data stays there. When we receive data from user, we need to temporarily store the data for processing.

While processing we will store our data in containers called **Variables**. Java is a **strongly typed language**. So, Each container will have a name and type associated to it.

**Defining a Variable**<br>
To Define a variable in java, we need to specify the type first followed by the variable name and use assignment operator(=) to assign a value to the variable.

**Primitive Data Types**<br>

- **Integer**
  - int : 4 Bytes
  - long : 8 Bytes<br>
    When assigning a value to a long variable, we need to add 'l' as suffix to the value.
  - short : 2 Bytes
  - byte : 1 Byte [ Range: -2^7 to 2^7-1 i.e, **-128 to 127** ]
- **Float**
  - Double : 8 Bytes
  - Float: 4 Bytes<br>
    In case of floats, double will be the default data type as it can hold values with more precision compared to floats. floats are recommended when the float value we need to store has lesser precision.<br>
- **Boolean**<br>
  There are no sub-types for boolean type. A boolean variable can only take either of 2 values. **true/false**.
- **Charecters**<br>
  In case of charecters, unlike other programming languages, in java size of charecter is 2 Bytes as java follows Unicode Format.[ ASCII is limited ].<br>
  While assigning a character value to a variable of type character, we need to enclose the value in single quotes.

**Examples**<br>

> `int num=3;`<br>
> Here, num is variable of type integer(int).<br>
>
> `byte by=8;`<br>
> Here, by is variable of type byte.<br>
>
> `short sh=8;`<br>
> Here, sh is variable of type short.<br>
>
> `long l=1337l;`<br>
> Here, l is variable of type long.<br>
>
> `double num=8.1;`<br>
> Here, num is variable of type double.<br>
>
> When we want to store a decimal value in float variable, we will get an errror as by default **java will consider decimal values as double type**. In order to store a decimal value explicitly as a float type, we need to add 'f' at the end of the decimal value.<br>`float grade=4.0f;`<br>
>
> `char c='s';`<br>
> Here, c is a variable of type char.<br>
>
> `boolean b=true;`<br>
> Here, b is a variable of type boolean.<br>

---

## Literals

To store a binary value in int variable, add **0b as prefix** and simillarly, to store hexadecimal values in a int variable, add **0x as prefix**.

    int num1=0b101; //Binary Number
    int num2=0x110; //Hexadecimal Number
    int largeNumber=1_00_00_000 //numbers can be seperated using _(underscore)

**when storing an integer value in double/float, it will be converted to float value automatically**.

    double d=56; //stored as 56.0

**Performing arithimetic operations on charecters is valid**.

    char c='a';
    c++; //result: 'b'

**Assigning 0/1 to a boolean variable results in an error.**

## Type Conversion & Casting

**Type Casting** - Explictly converting a variable of one type to another

Storing a variable of type int into a byte type variable isn't allowed by default i.e, larger sized variable can't be stored into smaller sized variables. But, we can cast them to the targetted variable type and store the value.[ Reverse is possible ]

    byte b=127;
    int i=12;

    // b=i; will fail. as i has bigger range and javac doesn't allow this operation.
    //in order to store i value in b, we need to cast i to byte type.

    b=(byte)i;

**Type Conversion** - Simillarly, storing lesser size variable data to higher sized variable is possible by default and value will be converted to the targetted type implicitly.

    byte b=127;
    int i =12;
    i=b; //possible

**Converting a float/double value to integer type** will result in losing the precision value[ decimal value ]

    double d=56.89;
    int i =(int) d; // i will be 56.

**When an value is typecasted to byte** and if the value isn't in the range of byte [ -128 to 127 ] then the modulo operation will be performed between value and the range and result will be stored.

    byte b=127;
    int i=257;
    b=(byte)i; //bcoz i isn't in the range of byte
    //257%256 will be stored. as total range of byte is 256 [ -128 to 127 ]

## Logical Operators

    && - And
    || - Or
    ! - Not

In the case of **Or**, result will be _True_ when any one of two variables is True.So, when the first variable is True, **Short Circuit OR** will not check for the second variable.<br>

    boolean result=(a<b) || (c>d);

Here, if (a<b) output is True, then second part will not checked.

Simillarly, In the case of **And**, result will be _False_ when any one of two variables is False.So, when the first variable is False, **Short Circuit And** will not check for the second variable.<br>

    boolean result=(a<b) && (c>d);

Here, if (a<b) output is False, then second part will not checked.

## Conditional Statements

[ Skipped documentation for **if, if-else, if-else-if** ]

**Ternary Operator**
[ Simillar to JS]<br>

    (condition)? <if condition is true> : <if condition is false>

**Switch case**<br>

    switch(c){
        case 'a':
            System.out.println('a');
            break;
        case 'b':
            System.out.println('b');
            break;
        default:
            System.out.println('Default');
    }

if there arent any break statements for each case; when the case is matched, rest of the cases will be continued.<br>
If none of the cases are matched, default case will be executed.
