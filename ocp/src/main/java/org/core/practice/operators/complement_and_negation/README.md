Simple rule for finding the bitwise complement of a number:
**multiply the value by negative one and subtract one** :
```
int value = 3;
int complement = ~value;
assertThat(complement).isEqualTo(-4);
```

#### Increment and decrement operators

| Operator       | Example | Description                                                     |
|----------------|---------|-----------------------------------------------------------------|
| Pre-increment  | ++a     | Increases the value by one and returns a **_new_** value        |
| Pre-decrement  | --b     | Decreases the value by one and returns a **_new_** value        |
| Post-increment | c++     | Increases the value by one and returns the **_original_** value |
| Post-decrement | d--     | Decreases the value by one and returns the _**original**_ value |
