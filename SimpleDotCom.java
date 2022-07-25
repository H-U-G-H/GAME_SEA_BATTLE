public class SimpleDotCom
{
    int [] locationCells;
    int numOfHits = 0;

    public void setLocationCells (int [] locs)
    {
        locationCells = locs;
    } // OUT OF METHOD

    public String checkYourself (String stringGuess)
    {
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";

        for (int cell : locationCells)
        {
            if (guess == cell)
            {
                result = "Попал";
                numOfHits ++ ;
                break;
            } // OUT OF IF
        } // OUT OF LOOP

        if (numOfHits == locationCells.length)
        {
            result = "Потопил";
        } // OUT OF IF

        System.out.println(result);
        return result;
    } // OUT OF METHOD
} // OUT OF CLASS
