import java.util.*;

public class DotComBust
{
    private GameHelper helper = new GameHelper();
    private ArrayList <DotCom> dotComList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame()
    {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("ваша цель - потопить три \"сайта\".");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Постарайтесь потопить их за минимальное количество ходов");

        for (DotCom dotComToSet : dotComList)
        {
            ArrayList <String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        } //OUT OF LOOP
    } // OUT OF METHOD

    private void startPlaying()
    {
        while (dotComList.isEmpty())
        {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        } // OUT OF LOOP
        finishGame();
    } // OUT OF METHOD

    //TODO: ДОПИСАТЬ НЕДОСТАЮЩУЮ ЧАСТЬ КОДА...
}
