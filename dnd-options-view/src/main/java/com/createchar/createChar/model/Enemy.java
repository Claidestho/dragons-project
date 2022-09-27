package com.createchar.createChar.model;

public class Enemy {
    private String name;
    private String type;
    private int attackPower;
    private int healthPoints;

    // Getters / Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    // Constructors


    public Enemy() {
    }

    public Enemy(String name, String type, int attackPower, int healthPoints) {
        this.name = name;
        this.type = type;
        this.attackPower = attackPower;
        this.healthPoints = healthPoints;
    }
}