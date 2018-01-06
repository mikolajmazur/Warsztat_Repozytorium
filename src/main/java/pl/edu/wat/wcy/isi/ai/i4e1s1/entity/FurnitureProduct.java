package pl.edu.wat.wcy.isi.ai.i4e1s1.entity;

import javax.persistence.Entity;

@Entity
public class FurnitureProduct extends Product {
    private String material;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
