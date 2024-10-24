import java.util.*;

public class Theater {
    private String location;
    private int SeatingCapacity;

    private DatabaseOperation db = new DatabaseOperation();

    public void insertTheater(String location,int SeatingCapacity){
        this.location = location;
        this.SeatingCapacity = SeatingCapacity;
        String sql = "INSERT INTO theaters (location, SeatingCapacity) VALUES (?,?)";
        Object[] values = {location,SeatingCapacity};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected>0)
            System.out.println("Theater inserted successfully");
        else
            System.out.println("Something went wrong.Theater not inserted.");
    }

    public void showTheaters(){
        String sql = "SELECT * from theaters";
        List<Map<String,Object>> theaters = db.getRecords(sql);
        for (Map<String, Object> theater : theaters) {
            System.out.println("Theater ID: " + theater.get("TheatreID"));
            System.out.println("Location: " + theater.get("location"));
            System.out.println("Seating Capacity: " + theater.get("SeatingCapacity"));
            System.out.println("-----------------------------");
            
        }

    }
}
