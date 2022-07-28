import java.util.ArrayList;

public class DotCom
{
    private ArrayList <String> locationCells;

    public void setLocationCells (ArrayList <String> loc)
    {
        locationCells = loc;
    }

    public String checkYourself (String userInput)
    {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index > 0)
        {
            locationCells.remove(index);
            if (locationCells.isEmpty())
            {
                result = "Потопил";
            }
            else
            {
                result = "Попал";
            } // OUT OF INNER IF/ELSE
        } // OUT OF OUTER IF
        return result;
    } // OUT OF METHOD
} // OUT OF CLASS
