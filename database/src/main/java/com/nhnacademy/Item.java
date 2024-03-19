package com.nhnacademy;

public class Item {
    String id;
    String model;
    int hp;
    int defensePower;
    int attackPower;
    int moveSpeed;
    int attackSpeed;

    public Item(String id, String model, int hp, int defensePower, int attackPower, int moveSpeed, int attackSpeed) {
        this.id = id;
        this.hp = hp;
        this.defensePower = defensePower;
        this.attackPower = attackPower;
        this.moveSpeed = moveSpeed;
        this.attackSpeed = attackSpeed;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getHp() {
        return hp;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }


    
}
