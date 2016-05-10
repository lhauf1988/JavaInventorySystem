// ClassName........: TmpDrum.java
// Developed By.....: Andrew Clelland
// Week.............: Week 5
// Date Created.....: 8/18/2015
// Purpose..........: Class for drum object file for drum storage team project

//allows for the object to be entered into file
import java.io.Serializable;

public class TmpDrum implements Serializable
{
    //sets the acceptable values of the material entered
    enum CATEGORY {Cotton, Oil, Water};
    // Attributes of class
    private String drumSerial;
    private CATEGORY material;
    private double weight;
    private String status = "empty";
    
    public TmpDrum ()   // Default Constructor due to no arguments
    {
        
    }
    public TmpDrum (String pDrumSerial, CATEGORY pMaterial, double pWeight, String pStatus)// overloaded constructor due to multiple arguments
    {
        this.drumSerial = pDrumSerial;
        this.material = pMaterial;
        this.weight = pWeight;
        this.status = pStatus;
    }
    
    // Set Method
    //
    public void setDrumSerial (String pDrumSerial)
    {
        this.drumSerial = pDrumSerial;
    }
    //verifies that only the selected options are entered for the material
    public void setMaterial (CATEGORY pMaterial)
    {        
        try
        {
            pMaterial = material;
        }
        catch (Exception err)
        {
            System.err.println("Please choose one of these options: Water, Oil, or Cotton");
            return;
        }
        this.material = pMaterial;
    }
    //checks that the drum is not overfilled using custom exception
    public void setWeight (double pWeight) throws TmpDrumFormat
    {
        try 
        {
            this.weight = pWeight;
            throw new TmpDrumFormat(pWeight);
        }
        catch (TmpDrumFormat e)
        {
            System.out.println(e.getMessage());
            throw new TmpDrumFormat(pWeight);
        }
        finally
        {
        this.weight = pWeight;
        }
        
    }
    //auto sets the status of the drum depending on the weight entered.
    public void setStatus (String pStatus)
    {
        if (this.weight > 0 && this.weight < 30)
            pStatus = "in progress";
        if (this.weight == 30)
            pStatus = "full";
        else
            pStatus = "empty";
        
        this.status = pStatus;
    }
    
    // Get Method
    //
    public String getDrumSerial ()
    {
        return this.drumSerial;
    } 
    public CATEGORY getMaterial ()
    {
        return this.material;
    }
    public double getWeight ()
    {
        return this.weight;
    }
    public String getStatus ()
    {
        return this.status;
    } 
    
    public String displayDrum ()
	{
		return("\nDrum ID: \f" + this.drumSerial + "\nMaterial: \f" + this.material + "\nKg: \f" + this.weight + "\n" + this.status) ;
	}
    
}
