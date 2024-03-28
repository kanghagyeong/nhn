import java.util.ArrayList;
import java.util.List;

public class Zerg {
    

    public Unit add(int random) {
        if (random == 0) {
        return new Zergling(2, 2, "Zerg","zergling");
            
        } else if (random == 1) {
            return new Hydralisk(3, 7, "Zerg","Hydralisk");
            
        } else {
            return new Mutalisk(2, 8, "Zerg","Mutalisk");

        }
    
        
    }
}
