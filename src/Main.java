import java.io.*;

public class Main {

    public static void main(String[] args)
    {
        int option = -1;
        int currentDisc = 0;
        Collection myDiscCollection = new Collection();


//        Disc newschool = new Disc("Newschool", "Young Igi", "Ktostam", 1997, 25.50f);
        do
        {
            System.out.println("Current Disc Selected: " + currentDisc);
            System.out.println("=============================================================");
            if(myDiscCollection.discs[currentDisc] == null)
            {
                System.out.println("Selected disc empty.");
            }else
            {
                myDiscCollection.discs[currentDisc].displayDisc();
            }

            System.out.print(" 0 - Add disc\n 1 - Select disc [0-9]\n 2 - Add song [up to 25]\n 3 - Display songs\n 4 - Quit\n Option:  ");
            option = inputOption();

            switch (option)
            {
                case 0:
                {
                    myDiscCollection.addDisc();
                    break;
                }
                case 1:
                {
                    do
                    {
                        System.out.print("Select disc [0-9]: ");
                        currentDisc = inputOption();
                    }while(currentDisc < 0 || currentDisc > 9);
                    break;
                }
                case 2:
                {
                    myDiscCollection.discs[currentDisc].addSong();
                    break;
                }
                case 3:
                {
                    myDiscCollection.discs[currentDisc].displaySongs();
                    break;
                }
                case 4:
                {
                    break;
                }
                default:
                {
                    System.out.println("Unknown option.");
                    break;
                }
            }
            System.out.println();
        }
        while(option != 4);
    }


    private static int inputOption()
    {
        String inputStr = "";
        int inputInt = -1;
        InputStreamReader strumien = new InputStreamReader(System.in);
        BufferedReader bufor = new BufferedReader(strumien);
        do {
            try
            {
                inputStr = bufor.readLine();
                inputInt = Integer.parseInt(inputStr);
            }catch(IOException | NumberFormatException e)
            {
                e.printStackTrace();
                System.out.println("Cannot select such disc.");
            }
        }while(inputInt < 0);
        return inputInt;
    }
}
