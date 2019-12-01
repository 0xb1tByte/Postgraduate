#### Purpose: 
- a simple java program that calculates the **Modular Exponentiation** (in terms of loop)

#### WHY!: 
- Because the mathematicians people -crypto people in specific- ask us to calculate it by hand, BUT we are programmers and lazy, so we automate it! 

#### Output: 
![alt text](https://raw.githubusercontent.com/0xb1tByte/Postgraduate/master/Cryptography/Assignments/Modular%20Exponentiation/output.png)

#### Current issues (Trying to fix it): 
- **Please NOTE**: Since the program relies on **Math.pow()**, you will get accurate results only when the number of digits (results from **Math.pow**) is less than **18 Digits**, 
- **WHY this kind of error is happening ?**
  Because **Math.pow** is using **double** variable to store the results, and this type cannot accommodate digits equal or more than 18 digits (Check the below screenshot for more details)

![alt text](https://raw.githubusercontent.com/0xb1tByte/Postgraduate/master/Cryptography/Assignments/Modular%20Exponentiation/error.png)
