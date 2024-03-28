public class Mutalisk extends Unit implements Flyable, Attackable {
    @Override
    public void fly() {

    }

    @Override
    public void attackable() {

    }

    public Mutalisk(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower,tribe, name);
    }
}
