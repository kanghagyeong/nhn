public class Goliath extends Unit implements NonFlyable,Attackable  {
    @Override
    public void nonFly() {

    }

    @Override
    public void attackable() {

    }

    public Goliath(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower, tribe, name);
    }
}
