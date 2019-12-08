#### Purpose: 
a simple java program that automates some operations in **Modular** , the program has the below functions: 
##### 1 - For Large Number (BigInteger)
- ModularExponentForBigInteger()
- ModularExponentForBigIntegerLoop()
- multiplyModP()
- ModularMultiplicativeInverseForBigInteger()
##### 2- For Small Numbers (int)
- ModularExponent()
- ModularExponentLoop()

#### WHY!: 
- Because the mathematicians people -crypto people in specific- ask us to calculate it by hand, BUT we are programmers and lazy, so we automate it! 

#### Output: 
![alt text](https://raw.githubusercontent.com/0xb1tByte/Postgraduate/master/Cryptography/Assignments/Modular%20Exponentiation/output1.png)

#### Current issues: Fixed :white_check_mark:
- **Please NOTE**: Since the program relies on **Math.pow()**, you will get accurate results only when the number of digits (results from **Math.pow**) is less than **18 Digits**, 
- **WHY this kind of error is happening ?**
  Because **Math.pow** is using **double** variable to store the results, and this type cannot accommodate digits equal or more than 18 digits (Check the below screenshot for more details)

![alt text](https://raw.githubusercontent.com/0xb1tByte/Postgraduate/master/Cryptography/Assignments/Modular%20Exponentiation/error.png)

#### Final Note and Output: 
- For **SMALL** numbers you can use : **ModularExponent()** or **ModularExponentLoop** 
- For **Large** numbers you can use : **ModularExponentForBigInteger** 

![alt text](https://raw.githubusercontent.com/0xb1tByte/Postgraduate/master/Cryptography/Assignments/Modular%20Exponentiation/outputUpdated.png)
