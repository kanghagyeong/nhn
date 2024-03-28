public class Zergling extends Unit implements NonFlyable {
    @Override
    public void nonFly() {

    }

    

    public Zergling(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower,tribe, name);
    }
}
