package sbu.cs;

import javax.swing.*;
import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseLecture6
{

    /*
     *   implement a function that takes an array of int and return sum of
     *   elements at even positions
     *   lecture 6 page  16
     */
    public long calculateEvenSum(int[] arr)
    {
        long sum1 = 0;
        for (int i = 0; i < arr.length; i += 2)
        {
            sum1 += arr[i];
        }
        return sum1;
    }

    /*
     *   implement a function that takes an array of int and return that
     *   array in reverse order
     *   lecture 6 page 16
     */
    public int[] reverseArray(int[] arr)
    {
        for(int i = 0; i < (arr.length) / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    /*
     *   implement a function that calculate product of two 2-dim matrices
     *   lecture 6 page 21
     */
    public double[][] matrixProduct(double[][] m1, double[][] m2) throws
            RuntimeException
        {


            if(m2.length != m1[0].length)
            {
                throw new
                        RuntimeException();
            }

        double[][] m3 = new double[m1.length][m2[0].length];

            for (int row = 0; row < m3.length; row++)
            {
                for (int col = 0; col < m3[row].length; col++)
                {
                    m3[row][col] = multiplyMatricesCell(m1, m2, row, col);
                }
            }

            return m3;

    }

    double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) throws RuntimeException
    {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++)
        {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }



    /////////////////////////////////////////////////////////////////////////////////
    /*
     *   implement a function that return array list of array list of string
     *   from a 2-dim string array
     *   lecture 6 page 30
     */
    public List<List<String>> arrayToList(String[][] names)
    {
         //conver 2D string to 2D List function
        List<List<String>> nameList = new ArrayList<>();

        for (int i = 0; i < names.length; i++)
        {
            ArrayList<String> wordListMaking = new ArrayList<>();
            for (int j = 0; j < names[0].length; j++)
            {
                wordListMaking.add(names[i][j]);
            }
            nameList.add(wordListMaking);
        }
        return nameList;
    }

    /*
     *   implement a function that return a list of prime factor of integer n
     *   in ascending order
     *   lecture 6 page 30
     */
    public List<Integer> primeFactors(int n)
    {
        List<Integer> primeList = new ArrayList<Integer>();
        for (int i = 2; i <= n ; i++)
        {
            while (n % i == 0)
            {
                primeList.add(i);
                n = n / i;
            }
        }
        for (int i = 0; i < primeList.size() -1; i++)
        {
            if (primeList.get(i).equals(primeList.get(i + 1)))
            {
                primeList.remove(i + 1);
                i--; // to look at the same index again!
            }
        }

        return primeList;
    }

    /*
     *   implement a function that return a list of words in a given string
     *   lecture 6 page 30
     */
    public List<String> extractWord(String line)
    {
        List<String> words = new ArrayList<>();
        String[] list = line.split(" ");
        for (int i = 0; i < list.length; i++)
        {
            String temp = list[i].replaceAll("[^a-zA-Z]", "");
            words.add(temp);
        }

       return words;
    }
}
