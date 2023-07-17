# Introduction

- To Run java in local machine we need jdk [ Java Development Kit ]<br>
  Prefer LTS[ Long Term Support ] version.

  To check if java is installed and available to use,<br>
  run **java --version** and **javac --version** in command prompt/terminal.

  if there are errors, we need to add environment variables.

  copy path to bin folder [ **C://Program Files/java/jdk-17/bin** ] and add to system path variables.

- To run code in shell environment, run **jshell** command in terminal
  that opens a shell where you can run java code.

  Code that runs in shell not necessarily works in code environment.

  **Example**

  `System.out.println("Hello World")`

  This works in jshell but will not work in the code environment.

---

**Java is Platform independent** i.e, java code will run on any machine until it has JVM [ Java Virtual Machine ] Installed.

JVM can only understand bytecode. So, the java code which we write should be compiled to a byte code using java compiler.

    Java Code -> Compiler -> ByteCode -> JVM [ runs the byte code ]

---

In the Application context, we need specify the first file to the jvm. This first file need to have a **main method**. Execution will be started from this first file we specify. JVM will look for a main method in this first file with a specific signature i.e, with all required params and types. Our code will not work without this signature.

    class Hello {
        public static void main(String a[]){
            System.out.println("Hello world");
        }
    }

Java is Object Oriented and everything needs to be a object. We need to wrap our code with a class [ Classname & filename is same ].

**In Order to run the code, run the following commands.<br>**

> - Compile the code<br> >`javac Hello.java`<br>
>   This command will compile the code to bytecode and creates a bytefile with **.class** extension.
>
> - Run the code.<br> >`java Hello`<br>
>   This command will execute the code and prints the 'Hello World' text to the console.

---

Whenever we run some code, it runs in the Java Runtime Environment[JRE] which will be provided by the JDK. JVM along with few libraries(lib) forms the JRE.

javac (or compiler ) is only for development purposes. In order to run our code in any other machines, those machines need to have JRE/JVM Installed on them.
