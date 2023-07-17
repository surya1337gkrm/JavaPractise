# 06. Encapsulation

We can hide our data / methods implementation outside of the class. So no one can access them. Anyone can access them only them using other public methods defined in the class.

Variables/ Methods declared as **private** cannot be accessed from outside the class. But **inside the class definition those variables & methods can be accessed by any methods defined**.

    class Sample{
        private int data=10;

        private int returnData(){
            return data;
        }

        public int getData(){
            int d=returnData();
            return d;
        }
    }

    class HelloWorld {
        public static void main(String[] args) {
            Sample s=new Sample();
            System.out.println(s.getData());
        }
    }

In the above example, trying to access **private variable data** and **private method returnData()** on the new object created will throw an error. Since, we can access all private variables and private methods inside the class definition, **getData()** method has access to data & returnData() method. We can use getData() method on the new objevct we created.

In order to set the data for the private variable, we will define **getter and setter** methods in the class definition. It's the convention to define the methods that set the private variable value prefixed with **set** word and simillarly, methods we use to get the value of private variables with **get** word.

    class Sample{
        private int data;

        public void setData(int d){
            data=d;
        }

        public int getData(){
            return data;
        }
    }

    class HelloWorld {
        public static void main(String[] args) {
            Sample s=new Sample();
            s.setData(1337);
            System.out.println(s.getData()); //1337
        }
    }

**setData method** takes input value and sets the value of the private variable data to the value provided. **getData method** returns the value of the private variable.

In the previous example, in the setter method if the parameter name is same as the private variable then we will get an unexpected issue when we call the getter method.

    class Sample{
            private int data;

            public void setData(int data){
                data=data;
            }

            public int getData(){
                return data;
            }
        }

    class HelloWorld {
        public static void main(String[] args) {
            Sample s=new Sample();
            s.setData(1337);
            System.out.println(s.getData()); //0
        }
    }

In this example, if we use same variable name as the private variable then compiler thinks that data we are referring on the right side of the assignment is same as the private variable. Since, it is not initialised yet value will be **0** and that will be copied to the data again i.e, it will assign it's own value. To avoid this issue, we use **this keyword**.

**this** refers to the current object. Adn we can refer all the properties of the object using **this** keyword. To fix the previous problem, while assigning the value we got from the arguments passed to the setData method, assign the value from the data parameter to the **this.data**. Here we are specifically referring to the instance variable data defined in the class using **this keyword**.

    public void setData(int data){
                this.data=data;
    }
