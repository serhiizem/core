* The conditional operators, often called short-circuit operators, 
are nearly identical to the logical operators, & and |, except that 
the right side of the expression may never be evaluated 
if the final result can be determined by the left side of the expression
    ```
    if (duck != null & duck.getAge() < 5) { // Could throw a NPE
     // Do something
    }
    ```
  
* Do not quite understand the following example TBH.
Does the short-circuit nature of logical conditional 
operator override the operator precedence rules ??..
  ```
  int age = 25;
  if (age >= 25 || --age <= 24) {
      // do nothing
  }
  assertThat(age).isEqualTo(25);
  ```