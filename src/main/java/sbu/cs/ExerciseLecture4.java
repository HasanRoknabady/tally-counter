package sbu.cs;

public class ExerciseLecture4 {

    /*
     *   implement a function that returns factorial of given n
     *   lecture 4 page 15
     */
    public long factorial(int n)
    {
        long fac = 1;
        while (n > 0)
        {
            fac *= n;
            n--;
        }
        return fac;
    }

    /*
     *   implement a function that return nth number of fibonacci series
     *   the series -> 1, 1, 2, 3, 5, 8, ...
     *   lecture 4 page 19
     */
    public long fibonacci(int n)
    {
        long fib1 = 1, fib2 = 1;

        if (n == 1 || n == 2)
        {
            return 1;
        }

        long temp = 0, fib = 0;
        for (int i = 2; i < n; i++)
        {
            temp = fib1;
            fib1 = fib2;
            fib2 = temp;
            fib2 = temp + fib1;

        }
        return fib2;
    }

    /*
     *   implement a function that return reverse of a given word
     *   lecture 4 page 19
     */
    public String reverse(String word)
    {
        String reverse = "";
        int length = word.length();
        for (int i = length - 1; i >= 0; i--)
        {
            reverse = reverse + word.charAt(i);
        }
        return reverse;
    }

    /*
     *   implement a function that returns true if the given line is
     *   palindrome and false if it is not palindrome.
     *   palindrome is like 'wow', 'never odd or even', 'Wow'
     *   lecture 4 page 19
     */
    public boolean isPalindrome(String line)
    {
        char tempStart = line.charAt(0);
        char tempEnd = line.charAt(line.length() - 1);
        if (Character.toLowerCase(tempEnd) == Character.toLowerCase(tempStart))
        {
            return true;
        }
        else
            return false;
    }

    /*
     *   implement a function which computes the dot plot of 2 given
     *   string. dot plot of hello and ali is:
     *       h e l l o
     *   h   *
     *   e     *
     *   l       * *
     *   l       * *
     *   o           *
     *   lecture 4 page 26
     */
    public char[][] dotPlot(String str1, String str2)
    {
        char[][] plot = new char[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++)
        {
            for (int j = 0; j < str2.length(); j++)
            {
                if (str1.charAt(i) == str2.charAt(j))
                {
                    plot[i][j] = '*';
                }
                else
                    plot[i][j] = ' ';
            }

        }

        return plot;


    }
}
