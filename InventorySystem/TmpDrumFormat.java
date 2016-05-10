// ClassName........: TmpDrumFormat.java
// Developed By.....: Andrew Clelland
// Week.............: Week 5
// Date Created.....: 8/18/2015
// Purpose..........: Class for exceptions for drum storage team project

public class TmpDrumFormat extends Exception
{
    private double number;

	public TmpDrumFormat (double pNumber)
	{
		number = pNumber;
	}

        @Override
	public String getMessage ()
	{
		if (this.number > 30)
			return ("\nDrums can only hold up to 30Kg."); 
                else if (this.number < 0)
                        return("\nDurms can not hold less then 0Kg");
		else
			return ("");
	}
    
}
