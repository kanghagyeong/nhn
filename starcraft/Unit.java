public class Unit {
    int attackPower;
    int defensePower;
    String tribe;
    String name;

    public Unit(int attackPower, int defensePower, String tribe, String name) {
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.tribe = tribe;
        this.name = name;
    }

    public void attack(Unit you) {
        you.setDefensePower( you.getDefensePower() - getAttackPower());
    
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    @Override
    public String toString() {
        return name + "(현재 방어력 : " + defensePower + " )";
    }
}
