import java.util.ArrayList;
import java.util.List;

public class Location 
{
  
    private String Name;
    private String Address;
    
    private ArrayList<Object> scheduleHolder = new ArrayList<Object>(3);

    public Location(String name, String address)
    {
        Name = name;
        Address = address;
    }

   
}
