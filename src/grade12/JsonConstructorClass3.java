package grade12;

public class JsonConstructorClass3 
{
    
    private String FTIM;
    private String out3;
    
     public JsonConstructorClass3(String FTIMin) 
    {
        FTIM = FTIMin;
    }
     
     public String getFTIM() 
    {
        return FTIM;
    }
     
      @Override
    public String toString() 
    {
        out3 = out3 + "Swimmer Result Time: " + FTIM + "\n" + "\n";
        return out3; 
    }
}
