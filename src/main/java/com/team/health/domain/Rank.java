package com.team.health.domain;

public enum Rank {
    BRONZE(1), // 1
    SILVER(2), // 2
    GOLD(3),  // 3
    PLATINUM(4), // 4
    DIA(5); // 5

    private final int id;

    Rank(int id) {
        this.id = id;
    }

    public int getValue(){
        return id;
    }
}
