### General notes

* Draw references to objects in heap if required to determine when object
is eligible for garbage collection
    ```
    1: public class Scope {
    2: public static void main(String[] args) {
    3:    String one, two;
    4:    one = new String("a");
    5:    two = new String("b");
    6:    one = two;
    7:    String three = one;
    8:    one = null;
    9: } }
    ```

* Track the line numbers where variable goes into a scope,
and goes out of scope (local variables, method parameters,
instance variables, class variables)