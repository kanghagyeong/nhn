public class Hydralisk extends Unit implements NonFlyable, Attackable{
    @Override
    public void nonFly() {

    }

    @Override
    public void attackable() {

    }

    public Hydralisk(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower, tribe, name);
    }
}
