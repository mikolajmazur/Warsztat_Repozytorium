package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import javax.persistence.Entity;

@Entity
public class FoodProduct extends Product {
    private Integer calories;

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
