One area where the exam writers will try to trip you up is if statements without braces
({})
```java
if (hourOfDay < 11)
    System.out.println("Good Morning");
    morningGreetingCount++;
```
It will execute the print statement only if the condition is
met, but it will always execute the increment operation