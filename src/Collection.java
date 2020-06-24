import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Collection {
    Disc[] discs = new Disc[10];
    int discsStored = 0;

    public void addDisc()
    {
        if(discsStored < 10)
        {
            String title; String artist; String publisher; int year; float price;
            System.out.println("Adding album number " + (discsStored + 1));
            System.out.print("Enter title: ");
            title = inputString();
            System.out.print("Enter artist: ");
            artist = inputString();
            System.out.print("Enter publisher: ");
            publisher = inputString();
            System.out.print("Enter year of release: ");
            year = inputYear();
            System.out.print("Enter price: ");
            price = inputPrice();
            discs[discsStored] = new Disc(title, artist, publisher, year, price);
            System.out.println("Disc " + discsStored + " successfully added.");
            discsStored++;
        }
        else
        {
            System.out.println("The collection is full of albums!");
        }
    }

    private String inputString()
    {
        String input = "";
        InputStreamReader strumien = new InputStreamReader(System.in);
        BufferedReader bufor = new BufferedReader(strumien);
        do {
            try
            {
                input = bufor.readLine();
            }catch(IOException e)
            {
                e.printStackTrace();
                System.out.println("Incorrect string.");
            }
        }while(input.equals(""));
        return input;
    }

    private int inputYear()
    {
        String strInput = "";
        int intInput = -1;
        InputStreamReader strumien = new InputStreamReader(System.in);
        BufferedReader bufor = new BufferedReader(strumien);
        do {
            try
            {
                strInput = bufor.readLine();
                intInput = Integer.parseInt(strInput);
            }catch(IOException | NumberFormatException e)
            {
                e.printStackTrace();
                System.out.println("Year formatting error.");
            }
        }while(intInput <= 1900);
        return intInput;
    }

    private float inputPrice()
    {
        String strInput = "";
        float floInput = -1.0f;
        InputStreamReader strumien = new InputStreamReader(System.in);
        BufferedReader bufor = new BufferedReader(strumien);
        do {
            try
            {
                strInput = bufor.readLine();
                floInput = Float.parseFloat(strInput);
            }catch(IOException | NumberFormatException e)
            {
                e.printStackTrace();
                System.out.println("Wrong price entered.");
            }
        }while(floInput < 0.0);
        return floInput;
    }
}

