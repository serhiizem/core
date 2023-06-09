* Local variable type inference only applicable to local variables,
meaning that:

```java
public class VarKeyword {
    var tricky = "Hello"; // DOES NOT COMPILE
}
```

* Initial value used to determine the type needs to be part of the same
statement:

```java
class Wrapper {
    public void doesThisCompile(boolean check) {
        var question;
        question = 1;
        var answer;
        if (check) {
            answer = 2;
        } else {
            answer = 3;
        }
        System.out.println(answer);
    }
}
```

* All the types declared on a single line must be the same type and share the same declaration:
```java
class Wrapper {
    public void twoTypes() {
        int a, var b = 3; // DOES NOT COMPILE
        var n = null; // DOES NOT COMPILE
    }
}
```

<br/>

**var is not a reserved word and allowed to be used as an identifier. 
It is considered a reserved type name. A reserved type name means 
it cannot be used to define a type, such as a class, interface, or enum.**