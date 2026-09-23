package grade12;


import java.io.FileNotFoundException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import javax.swing.JOptionPane; 
import org.json.simple.parser.ParseException;

public class JsonArrayClassPAT 
{
            private int Size= 0;
            private String StrJsonArr = "";
            private String StrAdd = "";
            private String StrDelete = "";   
            private String StrSearch = "";   
            private List <Search_Screen> arraysearch = new ArrayList<>();
            private  List<JsonConstructorClass> swimmerslist = new ArrayList<>();
            private  List<JsonConstructorClass2> eventslist = new ArrayList<>();
            private  List<JsonConstructorClass3> resultslist = new ArrayList<>();
            private String out = "";
            
            private String CatCheck1 = "swimmerID";
            private String CatCheck2 = "firstName";
            private String CatCheck3 = "lastName";
            private String CatCheck4 = "grade";
            private String CatCheck5 = "raceID";
            private String CatCheck6 = "distance";
            private String CatCheck7 = "startTime";
            private String CatCheck8 = "gradeR";
            private String CatCheck9 = "finalTime";
            
            public static String Search;
            public static String Catergory;

            public String JsonReadDeclare()
            {
        
        try 
        {
            JSONParser jsonparser = new JSONParser();
            
            JSONObject myfile = (JSONObject) jsonparser.parse(new FileReader("school_swimming_database_json.json"));
        
            
            
            
            JSONArray Swimmers = (JSONArray) myfile.get("swimmers");
            
            
            Size=Swimmers.size();
           
            for (int i = 0; i < Swimmers.size(); i++)
            {
                
               JSONObject swimmer = (JSONObject) Swimmers.get(i);
               
                
               String SID = (String) swimmer.get("swimmerID");
               
               String SFN = (String) swimmer.get("firstName");
               
               String SLN = (String) swimmer.get("lastName");
               
               String SG = String.valueOf(swimmer.get("grade"));
               
               JsonConstructorClass Swim = new JsonConstructorClass(SID, SFN, SLN, SG);
   
               swimmerslist.add(Swim);
               
               
            }

            
            
            
            JSONArray Events = (JSONArray) myfile.get("events");
            
            
            
            for (int t = 0; t < Events.size(); t++) 
            {

                JSONObject event = (JSONObject) Events.get(t);
               
                
               String RID = (String) event.get("raceID");
               
               String DIS = (String) event.get("distance");
               
               String TIM = (String) event.get("startTime");
               
               String RSG = String.valueOf(event.get("gradeR"));

               JsonConstructorClass2 Event = new JsonConstructorClass2(RID, DIS, TIM, RSG);
               
               eventslist.add(Event);
               
               
            }
            
            
            
            
            JSONArray Results = (JSONArray) myfile.get("results");
            
           
            
            for (int j = 0; j < Results.size(); j++) 
            {

               JSONObject results = (JSONObject) Results.get(j);

//               SID = (String) results.get("swimmerID");
//
//               RID = (String) results.get("raceID");
               
               String FTIM = (String) results.get("finalTime");
               
               JsonConstructorClass3 Result = new JsonConstructorClass3(FTIM);
               
               resultslist.add(Result);               

            }
            
            
            Search_Screen SC = new Search_Screen();
            System.out.println("HELLO: "+SC.getSearch());
        } 
        
        catch (FileNotFoundException ex) 
        {
            System.out.println("File Not Found");
        }
        catch (IOException ex)
        {
            System.out.println("IO Error");    
        }
        catch (ParseException ex)
        {
            System.out.println("Cannot Read File");    
        }

  return StrJsonArr;
}
            
public String JsonAddMethod()
{
    String id = Add_Screen.SwimID;
    
    String firstname = Add_Screen.FirstN;
    
    String lastname = Add_Screen.LastN;
    
    String grade = Add_Screen.Grade;

    JsonConstructorClass AddSwimmer = new JsonConstructorClass(id, firstname, lastname, grade);
    swimmerslist.add(AddSwimmer);

    try
    {
        JSONParser jsonparser = new JSONParser();
        JSONObject myfile = (JSONObject) jsonparser.parse(new FileReader("school_swimming_database_json.json"));

        JSONArray Swimmers = (JSONArray) myfile.get("swimmers");

        JSONObject AddSwimmerObj = new JSONObject();
        
        AddSwimmerObj.put("swimmerID", id);
        
        AddSwimmerObj.put("firstName", firstname);
        
        AddSwimmerObj.put("lastName", lastname);
        
        AddSwimmerObj.put("grade", Integer.parseInt(grade));

        Swimmers.add(AddSwimmerObj);

        try (FileWriter file = new FileWriter("school_swimming_database_json.json"))
        {
            file.write(myfile.toJSONString());
            file.flush();
        }

        StrAdd = AddSwimmer.toString();
    }
    
        catch (FileNotFoundException ex) 
        {
            System.out.println("File Not Found");
        }
        catch (IOException ex)
        {
            System.out.println("IO Error");    
        }
        catch (ParseException ex)
        {
            System.out.println("Cannot Read File");    
        }

    return StrAdd;
}
        
       public String JsonDeleteMethod(String SwimIDdelete, String SwimFNdelete, String SwimLNdelete, String SwimGdelete)
{
    try
    {
        JSONParser jsonparser = new JSONParser();
        JSONObject myfile = (JSONObject) jsonparser.parse(new FileReader("school_swimming_database_json.json"));

        JSONArray Swimmers = (JSONArray) myfile.get("swimmers");

        boolean Found = false;
        
        for (int i = 0; i < Swimmers.size(); i++)
        {
            
            JSONObject swimmer = (JSONObject) Swimmers.get(i);
            
            String SwimID = (String) swimmer.get("swimmerID");
            
            String SwimFN = (String) swimmer.get("firstName");
            
            String SwimLN = (String) swimmer.get("lastName");
            
            String SwimGrade = (String) swimmer.get("SwimGdelete");
            

            if (SwimID.equals(SwimIDdelete) && SwimFN.equals(SwimFNdelete) && SwimLN.equals(SwimLNdelete) && SwimGrade.equals(SwimGdelete))
            {
                Swimmers.remove(i);
                Found = true;
                break;
            }
        }

        if (!Found)
        {
            StrDelete = "No Swimmer found with ID: " + SwimIDdelete;
            return StrDelete;
        }

        try (FileWriter file = new FileWriter("school_swimming_database_json.json"))
        {
            file.write(myfile.toJSONString());
        }

        
        for (int i = 0; i < swimmerslist.size(); i++)
            
            {
            if (swimmerslist.get(i).getSID().equals(SwimIDdelete))
            {
                
            swimmerslist.remove(i);
            break;
            
            }
        }
        
       
        StrDelete = "Deleted Swimmer- " + "Swimmer ID" + SwimIDdelete;
    }
        
        catch (FileNotFoundException ex) 
        {
            System.out.println("File Not Found");
        }
        catch (IOException ex)
        {
            System.out.println("IO Error");    
        }
        catch (ParseException ex)
        {
            System.out.println("Cannot Read File");    
        }
    
    return StrDelete;
}
       
       public String JsonSearchMethod(String searchin, String catin)
       {
          Search = searchin;
          Catergory = catin;
        
        if (Catergory.equals("Swimmer ID")) 
        {
            Catergory = CatCheck1;
            StringArray = (ArrayList<String>) swimmerslist;
            
            
            
            //JACP.JsonReadDeclare();
            
            //jTextArea1.setText(JACP.JsonReadDeclare());
            
        }
        
        if (Catergory.equals("Swimmer First Name")) 
        {
            Catergory = CatCheck2;
            //ComboValid = true;
            System.out.println();
        }
        
        if (Catergory.equals("Swimmer Last Name")) 
        {
            Catergory = CatCheck3;
            //ComboValid = true;
            System.out.println();
        }
        
        if (Catergory.equals("Swimmer Grade")) 
        {
            Catergory = CatCheck4;
            //ComboValid = true;
            System.out.println();
        }
        
        if (Catergory.equals("Race ID")) 
        {
            Catergory = CatCheck5;
            //ComboValid = true;
            System.out.println();
        }
        
        if (Catergory.equals("Race Distance")) 
        {
            Catergory = CatCheck6;
            //ComboValid = true;
            System.out.println();
        }
        
        if (Catergory.equals("Race Start Time")) 
        {
            Catergory = CatCheck7;
            //ComboValid = true;
            
        }
        
        if (Catergory.equals("Race Grade")) 
        {
            Catergory = CatCheck8;
            //ComboValid = true;
            System.out.println();
        }
        
        if (Catergory.equals("Swimmer Final Results")) 
        {
            Catergory = CatCheck9;
            //ComboValid = true;
            System.out.println();
        
        }
           for (int i = 0; i < ; i++) 
           {
               StrSearch = StrSearch + "";
           }
           return StrSearch;
       }

       
     @Override
    public String toString()
    {//change this
    
 out = "";
    for (JsonConstructorClass swimmer : swimmerslist) 
    {
        out = out + swimmer.toString();
    }
    return out;
    
    }
    
     
}

