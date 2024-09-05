import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.function.BinaryOperator;

class Video
{
    String videoname;
    boolean checkout;
    int rating;
    Video(String name)
    {
        videoname=name;

    }
    String getName()

    {
        return videoname;
    }
    void docheckOut()
    {
        checkout=true;
    }
    void doReturn()
    {
        checkout=false;
    }
    void receiveRating(int rating)
    {
        this.rating=rating;

    }
    int getRating()
    {
        return rating;
    }
    boolean getCheckout() {
        return checkout;
    }
}
class VideoStore
{
    Video[] store=new Video[10];
    static int i=0;

    void  addVideo(String name)
    {
        Video newVideo=new Video(name);
        store[i]=newVideo;
        i++;
        System.out.println("video added succesfully");
    }
    void doCheckout(String name)
    {
        if(store==null||store.length==0)
        {
            System.out.println("store is empty");
            return;
        }
        for (Video video:store)
        {
            if (video.getName().equals(name))
            {
                video.docheckOut();
            }
            else
                System.out.println("video not found");
        }

    }
    void doReturn(String name)
    {
        for (Video video:store)
        {
            if (video.getName().equals(name))
                video.doReturn();
        }

    }
    void recieveRating(String name,int rating)
    {
        if (store==null||store.length==0)
        {
            System.out.println("store is empty");
            return;
        }
        for (Video video:store)
        {
            if (video.getName().equals(name))
            {
                video.receiveRating(rating);
            }
        }

    }
    void listInventory()
    {
        if (store==null||store.length==0)
        {
            System.out.println("store is empty");
            return;
        }
        System.out.print("video name|");
        System.out.print("checkout status|");
        System.out.print("rating");
        System.out.println("______________________________________________");
        for (int i=0;i<store.length;i++)
        {
            System.out.print("|15%s|"+store[i].videoname);
            System.out.print("|15%s|"+store[i].checkout);
            System.out.print("|15%s|"+store[i].rating);
        }

    }
}
public class VedioLaucher
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        VideoStore videoStore=new VideoStore();
        int choice=0;
        while (choice!=6)
        {
        System.out.println("MAIN MENU");
        System.out.println("==========");
        System.out.println("1.Add videos:");
        System.out.println("2.Check Out video:");
        System.out.println("3.Return Video:");
        System.out.println("4.Receive Rating:");
        System.out.println("5.List Inventory:");
        System.out.println("6.Exit");
        System.out.println("Enter your choice  (1..6):");
        choice=scanner.nextInt();
        scanner.nextLine();
        String string;
            switch (choice)
            {
                case 1:
                   System.out.println("enter the video name you want to add:");
                    string = scanner.nextLine();
                    videoStore.addVideo(string);
                    //1System.out.println("video added successfully");
                    break;
                case 2:
                    System.out.println("enter the vedio name you want to checkout:");
                    string = scanner.nextLine();
                    videoStore.doCheckout(string);
                    break;
                case 3:
                    System.out.println("enter name of the video you want to return:");
                    string = scanner.nextLine();
                    videoStore.doReturn(string);
                    break;
                case 4:
                    int rating;
                    System.out.println("enter the video name you want to rate:");
                    string = scanner.nextLine();
                    System.out.println("enter your rating:");
                    rating = scanner.nextInt();
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.out.println("thanks for visiting our store");
                    break;
                default:
                    System.out.println("sorry invalid options");
            }
        }
    }

}
