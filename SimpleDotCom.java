public class SimpleDotCom
{
    int [] locationCells;
    int numOfHits = 0;

    public void setLocationCells (int [] locs)
    {
        locationCells = locs;
    } // out of method

    public String checkYourself (String stringGuess)
    {
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";

        for (int cell : locationCells)
        {
            if (guess == cell)
            {
                result = "Попал";
                numOfHits++;
                break;
            } // out of if
        } // out of loop

        if (numOfHits == locationCells.length)
        {
            result = "Потопил";
        } // out of if

        System.out.println(result);
        return result;
    } // out of method
} // out of class
