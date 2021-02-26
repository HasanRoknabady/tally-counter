package sbu.cs;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.RandomAccess;

public class ExerciseLecture5 {

    /*
     *   implement a function to create a random password with
     *   given length using lower case letters
     *   lecture 5 page 14
     */
    public String weakPassword(int length)
    {
        Random random = new Random();
        int acsNum = 0, i = 0, numAlf = 26;
        StringBuilder builder = new StringBuilder();

        while (i < length)
        {
            acsNum = random.nextInt(26) + 97;
            builder.append((char) acsNum);
            i++;
        }
        String outPutPass = builder.toString();
        return outPutPass;
    }

    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */
    /////////////////////////////////////////////////////////////
    /*
    public String strongPassword(int length) throws Exception
    {
        if(length < 3)
        {
            throw new IllegalValueException();
        }
        Random rand = new Random();
        StringBuilder tempPassword = new StringBuilder(weakPassword(length));
        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
        int quantityOfDigits = rand.nextInt(length) + 1;
        for (int i = 0; i < quantityOfDigits; i++)
        {
            int randomI = rand.nextInt((length - 1) / 2);
            int randomDigit = rand.nextInt(10);
            tempPassword.setCharAt(randomI,digits[randomDigit]);
        }
        char[] specialCharacters = {'?','<','>','@','!','#','$','%','^','&','*','(',')','-','_','=','/','.','~','`'};
        int quantityOfSpecialCharacters = rand.nextInt(length) + 1;
        for (int i = 0; i < quantityOfSpecialCharacters; i++)
        {
            int randomI = rand.nextInt((length - 1) / 2) + (length - 1) / 2;
            int randomSpecialCharacter = rand.nextInt(20);
            tempPassword.setCharAt(randomI,specialCharacters[randomSpecialCharacter]);
        }
        return tempPassword.toString();
    }
    ////////////////////////////////////////////////////////////////
     */
    public String strongPassword(int length) throws
    Exception {

        if(length < 3)
        {
            throw new
                    RuntimeException();
        }
        Random random = new Random();
        String specialsChar = "+_()@#$%^&*~!";
        StringBuilder builder = new StringBuilder();
        int randInt = 0, i = 0;
        while (i < length)
        {
            if (i % 3 == 2)
            {
                randInt = random.nextInt(26) + 97;
                builder.append((char) randInt);
            }
            if (i % 3 == 1)
            {
                randInt = random.nextInt(13);
                builder.append(specialsChar.charAt(randInt % 10));
            }
            if (i % 3 == 0)
            {
                randInt = random.nextInt(13);
                builder.append(specialsChar.charAt(randInt % 13));
            }
        }
        return builder.toString();
    }

    /*
     *   implement a function that checks if a integer is a fibobin number
     *   integer n is fibobin is there exist an i where:
     *       n = fib(i) + bin(fib(i))
     *   where fib(i) is the ith fibonacci number and bin(i) is the number
     *   of ones in binary format
     *   lecture 5 page 17
     */
    public boolean isFiboBin(int n)
    {
        long fib1 = 1, fib2 = 1;
        long temp = 0, temp2 = 0, garb = 0;
        long bineryOfNum = 0;

        boolean test = true, testIsFibobinOrNot = false;
     // dedicate that n is a fibobin if is return true else return false
            while (test)
            {

                //this for get fibnum
                if (n > 2)
                {
                    temp = fib2;
                    fib2 = fib1;
                    fib1 = temp;
                    fib2 = fib1 + fib2;
                }
                temp2 = fib2;
                // this method can find binery of fibNum and ...
                while (temp2 != 0)
                {
                    garb = temp2 % 2;
                    if (garb == 1)
                    {
                        bineryOfNum += 1;
                    }
                    temp2 /= 2;
                }
                //check if is fibobin or not
                if (fib2 + bineryOfNum == n)
                {
                    test = false;
                    testIsFibobinOrNot = true;
                }
                if (fib2 + bineryOfNum > n)
                {
                    test = false;
                    testIsFibobinOrNot = false;
                }
                // for another loop defin
                bineryOfNum = 0;

            }
            return testIsFibobinOrNot;


    }




  }


