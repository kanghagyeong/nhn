public class Zealot extends Unit implements NonFlyable{
    @Override
    public void nonFly() {

    }



    public Zealot(int attackPower, int defensePower, String tribe, String name) {
        super(attackPower, defensePower,tribe, name);
    }
}
