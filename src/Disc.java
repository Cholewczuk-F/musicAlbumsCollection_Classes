import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Disc
{
    String title;
    String artist;
    String publisher;
    int year;
    float price;
    Song[] songs = new Song[25];
    int songsStored = 0;

    public Disc(String title, String artist, String publisher, int year, float price)
    {
        this.title = title;
        this.artist = artist;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
    }


    public void addSong()
    {
        if(songsStored < 25)
        {
            String songTitle; String songPerformer; int duration;
            System.out.println("Song nr. " + (songsStored + 1));
            System.out.print("Enter title: ");
            songTitle = inputString();
            System.out.print("Enter performer: ");
            songPerformer = inputString();
            System.out.print("Enter song duration in [s]: ");
            duration = inputDuration();
            songs[songsStored] = new Song(songTitle, songPerformer, duration);
            songsStored++;
        }
        else
        {
            System.out.println("The album is full of songs. (25)");
        }
    }

    public void displaySongs()
    {
        if(songsStored > 0)
        {
            System.out.print("======================================\n Songs: \n");
            for(int i = 0; i < songsStored; i++)
            {
                System.out.println("Song no. " + (i + 1) + "    Title: " + songs[i].title + "   Performer: " + songs[i].performer + "   Duration: " + songs[i].duration/60 + "m " + songs[i].duration%60 + "s.") ;
            }
        }else
        {
            System.out.println("No songs to be displayed.");
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
                System.out.println("String incorrect.");
            }
        }while(input.equals(""));
        return input;
    }

    private int inputDuration()
    {
        String input = "";
        int inputInt = -1;
        InputStreamReader strumien = new InputStreamReader(System.in);
        BufferedReader bufor = new BufferedReader(strumien);
        do {
            try
            {
                input = bufor.readLine();
                inputInt = Integer.parseInt(input);
            }catch(IOException | NumberFormatException e)
            {
                e.printStackTrace();
                System.out.println("Time cannot be negative.");
            }
        }while(inputInt <= 0);
        return inputInt;
    }

    public void displayDisc()
    {
        System.out.println(" Title: " + title + "   No. Songs: " + songsStored);
        System.out.println(" Artist: " + artist);
        System.out.println(" Publisher: " + publisher);
        System.out.println(" Year of release: " + year);
        System.out.println(" Price: " + price);
    }
}
