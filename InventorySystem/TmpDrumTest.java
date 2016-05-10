// ClassName........: TmpDrumTest.java
// Developed By.....: Andrew Clelland
// Week.............: Week 5
// Date Created.....: 8/18/2015
// Purpose..........: Class for testing drum storage team project


import java.util.ArrayList;
import java.util.Scanner;

public class TmpDrumTest 
{
    public static void main (String [] args) throws TmpDrumFormat
    {
        int option = 0;
        String vMaterial;
        String vSerial;
        Scanner input = new Scanner(System.in);
        ArrayList<TmpDrum> display = new ArrayList<TmpDrum>();   
        ReadWrite callMethod = new ReadWrite();
        System.out.println("Welcome to the Drum Management System\n");
        
        
        while(true)
        {   
            System.out.println("Please select an option: \n" + "1 - Next Drum ID\n" + "2 - Search Drum ID\n" + "3 - Previous Drum ID\n" + "4 - Add Drum ID\n" + "5 - Delet Drum ID\n" + "6 - Save List\n" + "7 - Exit Program\n");

            option = input.nextInt();
            System.out.println();
            
            if (option == 1)
            {
                callMethod.nextRecord();
                callMethod.drumRead();
                System.out.println();
            }
            else if (option == 2)
            {
                callMethod.searchRecord();
                callMethod.drumRead();
                System.out.println();
            }
            else if (option == 3)    
            {
                callMethod.prevousRecord();
                callMethod.drumRead();
                System.out.println();
            }
            else if (option == 4)
            {
                callMethod.addToList();
                callMethod.drumWrite();
                System.out.println();
            }
            else if (option == 5)
            {                
                callMethod.removeFromList();
                System.out.println();
            }
            else if (option == 6)
            {
                callMethod.writeToFile();
                System.out.println();
            }
            else if (option == 7)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid selection");
            }
            option++;
            System.out.println();
        }
        
    }

}
