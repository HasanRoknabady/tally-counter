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
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < randomString.length(); k++)
        {
            char ch1 = randomString.charAt(k);
            if ( (ch1 >= 'a' && ch1 <= 'z') && (length > 0) )
            {
                r.append(ch1);
                length--;
            }
        }

        // return the resultant string
        return r.toString();
    }

    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */
    public String strongPassword(int length) throws
    Exception {

        if(length < 3)
        {
            throw new
                    RuntimeException();
        }

        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, Charset.forName("UTF-8"));
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();
        Random rand = new Random();
        //////////////////////////////////////////////////
        int RAND_INT = rand.nextInt(10);
        char Special_Character = '@';
        char FIX = 'a';
        //from the generated random String into the result
        r.append(Special_Character);
        r.append(RAND_INT);
        r.append(FIX);
        for (int i = 0; i < randomString.length(); i++)
        {
            char ch3 = randomString.charAt(i);
            if ( ((ch3 >= 'a' && ch3 <= 'z') || (ch3 >= 'A' && ch3 <= 'Z') ||
                    (ch3 >= '0' && ch3 <= '9') )  && (length > 3) && (ch3 != '|') )
            {
                r.append(ch3);
                length--;
            }
        }
        // return the resultant string
        return r.toString();




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
        long temp = 0;
        boolean test = true;
        if (n == 1)
        {
            return true;
        }
          else
            {
               for (int i = 0; i <= 1000; i++)
                {
                   temp = fib1;
                   fib1 = fib2;
                   fib2 = temp;
                   fib2 = temp + fib1;

                   if (fib2 == n)
                   {
                    return true;
                   }
                   if (fib2 != n && i == 1000)
                   {
                    test = false;
                   }
                }

               if (test == true)
               {
                   return true;
               }
               else
                   return false;


            }




    }

}
