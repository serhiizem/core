* A float requires the letter f or F following the number so Java knows it is a float.
  **_Without an f or F, Java interprets a decimal value as a double._**


* A long requires the letter l or L following the number so Java knows it is a long.
  **_Without an l or L, Java interprets a number without a decimal point as an int in most
  scenarios._** 

  In the following example, the **number listed is bigger than what fits in
  an int** `long max = 3123456789; // DOES NOT COMPILE`

  
* short is signed, which means it splits its range across the positive and negative integers. 
Alternatively, char is unsigned, which means its range is strictly positive, including 0

