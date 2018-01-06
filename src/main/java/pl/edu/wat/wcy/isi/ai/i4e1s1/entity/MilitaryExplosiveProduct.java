package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import javax.persistence.Entity;

@Entity
public class MilitaryExplosiveProduct extends Product {
    private double explosionRange;

    public double getExplosionRange() {
        return explosionRange;
    }

    public void setExplosionRange(double explosionRange) {
        this.explosionRange = explosionRange;
    }
}
