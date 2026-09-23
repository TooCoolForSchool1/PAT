
package grade12;


public class Admin 
{
    private String User;
    private String Pass;
    private String out = "";

    public Admin(String Userin, String Passin) 
    {
        User = Userin;
        Pass = Passin;
    }

    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }

    
    
    @Override
    public String toString() 
    {
        out = out + "Username: " + User + "\n" + "Password: "+ Pass + "\n" + "\n";
        return out; 
    }
    
    
}
