package model.vo;

import java.io.Serializable;

public class Snack implements Serializable {
    private String name;
    private int hungerBoost;
    private int count;

    public Snack(String name, int hungerBoost) {
        this.name = name;
        this.hungerBoost = hungerBoost;
    }

    public Snack(String name, int hungerBoost, int affectionBoost, int count) {
        this.name = name;
        this.hungerBoost = hungerBoost;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getHungerBoost() {
        return hungerBoost;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }
  
    public String toString() {
        return name + " (배고픔 증가: " + hungerBoost + ")";
    }
}
