### Order of initialization rules:

* **Fields and instance initializer blocks are run in the order in which they appear in the file.**
* **The constructor runs after all fields and instance initializer blocks have run**  

<br/>
For example, we can not refer to a variable that has not yet been defined:

```
{{ System.out.println(name); } // Does not compile
private String name = "Fluffy";
```

