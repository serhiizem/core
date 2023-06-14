### Casting values

Casting primitives is required any time you are going 
from a larger numerical data type to a smaller numerical data type, 
or converting from a floating-point number to an integral value
```
int fish = (int) 1.0;
short bird = (short) 1921222; // Stored as 20678
int mammal = (int) 9f;

int b = (int) 4134144141512323414L;
byte c = (byte) 123L;
```

However, it is necessary to be aware of the following corner cases:
```
long reptile = (long)192301398193810323; // DOES NOT COMPILE
```
This code does not compile because value is interpreted as int
and is out of range

The compiler doesn’t require casting when
working with literal values that fit into the data type.
For instance:
```
byte hat = 1;
byte gloves = 7 * 10;
short scarf = 5;
short boots = 2 + 1;
```

### Casting variables
```
short boots = 2 + hat; // DOES NOT COMPILE
byte gloves = 7 * 100; // DOES NOT COMPILE
```

The first statement does not compile because hat is a variable, 
not a value, and both operands are automatically promoted to int. 
When working with values, the compiler had enough information 
to determine the writer’s intent. When working with variables, though, 
there is ambiguity about how to proceed, so the compiler reports an error. 

The second expression does not compile because 700 triggers 
an overflow for byte, which has a maximum value of 127.