import java.util.ArrayList;
import java.util.List;

public class Protos {
 

    public Unit add(int random) {

        if (random == 0) {
        return new Zealot(5, 20, "Protos", "zealot");

        } else if (random == 1) {
         return new Dragoon(3, 15, "Protos", "Dragoon");

        } else {
          return new Scout(5, 10, "Protos", "Scout");

        }

    }

}
