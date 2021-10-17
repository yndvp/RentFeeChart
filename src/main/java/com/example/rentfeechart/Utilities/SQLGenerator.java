package com.example.rentfeechart.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class SQLGenerator {

    /**
     * This method creates random fees data that will be connected to each province
     */
    public static void createSQL()
    {
        // The list of numbers to put random number generator
        List<Integer> feesArr = Arrays.asList(1550, 1620, 1960, 1450, 1530, 2480, 1950, 1840, 2070, 2590);

        // Instantiate a random number generator
        SecureRandom rng = new SecureRandom();

        try(
                // Formatter object creates a sql file
                Formatter formatter = new Formatter("rentFees.sql");
                )
        {
            for (int i=1; i<=10; i++)
            {
                for(int j=1; j<=100; j++)
                {
                    int fee = rng.nextInt(feesArr.get(i-1))+1;
                    formatter.format("INSERT INTO rentFees (provinceId, fee) VALUES (%d, %d);%n", i, fee);
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method executes createSQL()
     */
    public static void main(String[] args)
    {
        createSQL();
    }
}
