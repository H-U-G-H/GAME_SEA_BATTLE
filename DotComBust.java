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

        System.out.println("Ваша цель - потопить три \"сайта\".");
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
        while (!dotComList.isEmpty())
        {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        } // OUT OF LOOP
        finishGame();
    } // OUT OF METHOD

    private void checkUserGuess(String userGuess)
    {
        numOfGuesses ++;
        String result = "Мимо";

        for (DotCom dotComToTest : dotComList)
        {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал"))
            {
                break;
            }
            if (result.equals("Потопил"))
            {
                dotComList.remove(dotComToTest);
                break;
            } // OUT OF IF
        } // OUT OF LOOP
        System.out.println(result);
    } // OUT OF METHOD

    private void finishGame()
    {
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18)
        {
            System.out.println("Это заняло у Вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как Ваши вложения утонули.");
        }
        else
        {
            System.out.println("Это заняло у Вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг Ваших вложений.");
        } // OUT OF IF/ELSE
    } // OUT OF METHOD

    public static void main(String[] args)
    {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
