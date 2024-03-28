public class Marine extends Unit implements NonFlyable {

    @Override
    public void nonFly() {

    }

    public Marine(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower,tribe, name);
    }
}
