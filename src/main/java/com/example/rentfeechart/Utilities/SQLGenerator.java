package com.example.rentfeechart.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Scanner;

public class SQLGenerator {
    public static void createSQL()
    {
        SecureRandom rng = new SecureRandom();

        try(
                Formatter formatter = new Formatter("rentFees.sql");
                )
        {
            for (int i=1; i<=1000; i++)
            {
                int fee = rng.nextInt(3500);
                formatter.format("INSERT INTO rentFees (provinceId, fee) VALUES (%d, %d);%n", rng.nextInt(10)+1, fee);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void readFile()
    {
        try {
            Scanner scanner = new Scanner(new File("rentFees.sql"));

            while(scanner.hasNext())
            {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        readFile();
    }
}
