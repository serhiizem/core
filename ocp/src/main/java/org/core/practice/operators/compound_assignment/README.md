### Compound assignment operator performs automatic casts

```
long goat = 10;
int sheep = 5;
sheep *= goat
```
The compound operator will first cast sheep to 
a long, apply the multiplication of two long values,
and then cast the result to an int