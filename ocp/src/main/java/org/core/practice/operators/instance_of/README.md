* instanceof operator can only be used with compatible types:
```
public void open(Number key) {
    if (key instanceOf String) { // DOES NOT COMPILE
        println(key);
    }
}
```
* `var result = null instanceof null;` DOES NOT COMPILE 
