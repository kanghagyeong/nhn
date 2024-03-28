public class Terran {
    

    public Unit add(int random) {

        if (random == 0) {
           return new Marine(3, 10, "Terran", "Marine");
        } else if (random == 1) {
            return new Goliath(5, 10, "Terran", "Goliath");
        } else {
          return new Valkyrie(4, 12, "Terran", "Valkyrie");

        }

    }

}
