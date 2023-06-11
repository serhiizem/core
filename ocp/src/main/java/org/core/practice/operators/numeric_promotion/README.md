### Numeric Promotion Rules

1. If two values have different data types, Java will automatically promote one of the
   values to the larger of the two data types.

2. If one of the values is integral and the other is floating-point, Java will automatically
   promote the integral value to the floating-point value’s data type.

3. Smaller data types, namely, byte, short, and char, are first promoted to int any time
   they’re used with a Java binary arithmetic operator with a variable (as opposed to a
   value), even if neither of the operands is int.

4. After all promotion has occurred and the operands have the same data type, the resulting 
value will have the same data type as its promoted operand


#### Examples:
* What is the data type of x * y?
```
int x = 1;
long y = 33;
var z = x * y;
```

* What is the data type of x * y?
```
double x = 39.21;
float y = 2.1;
var z = x + y;
```

* What is the data type of x * y?
```
short x = 10;
short y = 3;
var z = x * y;
```

* What is the data type of w * x / y?
```
short w = 14;
float x = 13;
double y = 30;
var z = w * x / y;
```