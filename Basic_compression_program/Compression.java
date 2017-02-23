// CSE 110 final project -- sample solution

import java.util.*;

public class Compression
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of free blocks: ");
        int free = sc.nextInt();

        int size = 0; // size of the next file to store
        
        while (free > 0 && size > -1)
        {
            System.out.println(free + " free blocks available");
            System.out.print("Enter a file size in bytes, or -1 to exit: ");
            size = sc.nextInt();
            
            if (size == -1)
            {
                break;
            }
            
            int compressedSize = (size * 8) / 10;
            System.out.println("Compressed: " + compressedSize + " bytes");

            int blocks = compressedSize / 512;

            if (compressedSize % 512 != 0)
            {
                blocks++; // account for additional block
            }

            System.out.println(blocks + " blocks required");

            if (blocks > free)
            {
                System.out.println("Not enough free space available");
                free = 0;
            }
            else
            {
                System.out.println("Saved file in " + blocks + " blocks");
                free = free - blocks;
            }
        }
        
        System.out.println("Thank you and goodbye!");
    }
}