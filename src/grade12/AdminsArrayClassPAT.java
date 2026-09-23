package grade12;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AdminsArrayClassPAT 
{   
    private String AdminL = "";
    public static Admin AdminArr[] = new Admin[50];
    private String line;
    private int Size= 0;
    
   public String AdminLog()
{

    try 
                
            {
                Scanner myline = new Scanner(new File("Admins.txt"));
                line = myline.nextLine();
                
                while (myline.hasNext()) 
                {    
            line= myline.nextLine();
            
            Scanner delim = new Scanner(line).useDelimiter(",");
                
            String User =  delim.next();
    
            String Pass =  delim.next();
    
                
                    AdminArr[Size] = new Admin(User, Pass);
                    Size++;
                    
                }
            }
 catch (FileNotFoundException e) 
            
            {
                 System.out.println("File not found"); 
            }
    
    
    return AdminL;
}

    @Override
    public String toString() 
    {
    
        for (int i = 0; i < Size; i++) 
    {
        AdminL = AdminL + "\n" + AdminArr[i].toString();
    }
        return "ArrayClassPAT{" + '}';
    }
  
}
