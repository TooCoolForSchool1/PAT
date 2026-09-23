package grade12;

public class JsonConstructorClass2 
{
    
    private String RID, DIS, TIM, RSG;
    private String out2;
    
 public JsonConstructorClass2(String RIDin, String DISin, String TIMin, String RSGin) 
    {
        RID = RIDin;
        DIS = DISin;
        TIM = TIMin;
        RSG = RSGin;
        
    }    
 
 public String getRID() 
    {
        return RID;
    }

    public String getDIS() 
    {
        return DIS;
    }

    public String getTIM() 
    {
        return TIM;
    }

    public String getRSG() 
    {
        return RSG;
    }
    
    

     @Override
    public String toString() 
    {
        out2 = out2 + "Race ID: " + RID + "Race Distance: " + DIS + "\n" + "Race Start Time: "+ TIM + "Grade That Races: " + RSG +"\n" + "\n" ;
        return out2;  
    }
}
