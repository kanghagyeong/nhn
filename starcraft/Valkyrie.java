public class Valkyrie extends Unit implements Flyable, Attackable {
   
   
    @Override
    public void fly() {

    }

    @Override
    public void attackable() {

    }

    
    public Valkyrie(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower,tribe, name);
    }
}
