import java.io.*;
import java.util.*;

public class GameHelper
{
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int [gridSize];
    private int comCount = 0;

    public String getUserInput (String prompt)
    {
        String inputLine = null;
        System.out.print(prompt + " ");

        try
        {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();

            if (inputLine.length() == 0)
            {
                return null;
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e);
        } // OUT OF TRY-CATCH

        return inputLine.toLowerCase();
    } // OUT OF METHOD

    public ArrayList <String> placeDotCom (int comSize)
    {
        ArrayList <String> alphaCells = new ArrayList<>();
        String [] alphaCoords = new String[comSize];
        String temp = null;
        int [] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount ++;
        int incr = 1;
        if ((comCount % 2) == 1)
        {
            incr = gridLength;
        }

        while (!success & attempts++ < 200)
        {
            location = (int) (Math.random() * gridSize);

            // тестовая строка
            // System.out.print (" пробуем " + location);

            int x = 0;
            success = true;

            while (success && x < comSize)
            {
                if (grid[location] == 0)
                {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize)
                    {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0))
                    {
                        success = false;
                    }
                }
                else
                {
                    // тестовая строка:
                    // System.out.print(" используется " + location);

                    success = false;
                } // OUT OF IF/ELSE
            } // OUT OF INNER LOOP
        } // OUT OF OUTER LOOP

        int x = 0;
        int row = 0;
        int column = 0;
        System.out.println();

        while (x < comSize)
        {
            grid [coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

            // тестовая строка:
            System.out.print (" coord = " + alphaCells.get(x-1));
        } // OUT OF LOOP
        System.out.println("\n");
        return alphaCells;
    } // OUT OF METHOD
} // OUT OF CLASS
