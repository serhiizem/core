* One area where the exam writers will try to trip you up is if statements without braces
  ({})
    ```java
    if (hourOfDay < 11)
        System.out.println("Good Morning");
        morningGreetingCount++;
    ```
  
* It will execute the print statement only if the condition is
  met, but it will always execute the increment operation

    Another common way the exam may try to lead you astray is by providing code where the
    boolean expression inside the if statement is not actually a boolean expression. For
    example, take a look at the following lines of code:
    ```
    int hourOfDay = 1;
    if (hourOfDay) { // DOES NOT COMPILE
       ...
    }
    ```