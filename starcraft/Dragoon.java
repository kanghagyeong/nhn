public class Dragoon extends Unit implements NonFlyable, Attackable {
    @Override
    public void nonFly() {

    }

    @Override
    public void attackable() {

    }

    public Dragoon(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower, tribe, name);
    }
}
