public class Scout extends Unit implements Flyable, Attackable {
    @Override
    public void fly() {

    }

    @Override
    public void attackable() {

    }

    public Scout(int attackPower, int defensePower,String tribe,String name) {
        super(attackPower, defensePower, tribe, name);
    }
}
