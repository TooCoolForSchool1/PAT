
package grade12;
import java.util.List;

public class JsonConstructorClass 
{
    private String SID, SFN, SLN, SG;
    private String out;
    private List <String> swimmerslist;

    public JsonConstructorClass(String SIDin, String SFNin, String SLNin, String SGin) 
    {
        
        SID = SIDin;
        SFN = SFNin;
        SLN = SLNin;
        SG = SGin;
        
        
    }

    public String getSID() 
    {
        return SID;
    }

    public String getSFN() 
    {
        return SFN;
    }

    public String getSLN() 
    {
        return SLN;
    }

    public String getSG() 
    {
        return SG;
    }

    @Override
    public String toString() 
    {
        out = out + "Swimmer ID: " + SID + "Swimmer First Name: " + SFN + "\n" + "Swimmer Last Name: "+ SLN + "Swimmer's Grade: " + SG +"\n" + "\n" ;
        return out; 
    }
            
    
    
}
