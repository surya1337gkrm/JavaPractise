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
