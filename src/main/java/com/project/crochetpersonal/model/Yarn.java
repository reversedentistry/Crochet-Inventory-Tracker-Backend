package com.project.crochetpersonal.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor // ^^Lombok
@Entity
public class Yarn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String color;
    private String material;
    private double cost;
    private boolean usedUp;
    private boolean isTunisian;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Yarn yarn = (Yarn) o;
        return id == yarn.id && Double.compare(cost, yarn.cost) == 0 && usedUp == yarn.usedUp && isTunisian == yarn.isTunisian && Objects.equals(color, yarn.color) && Objects.equals(material, yarn.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, material, cost, usedUp, isTunisian);
    }

    @Override
    public String toString() {
        return "Yarn{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", cost=" + cost +
                ", usedUp=" + usedUp +
                ", isTunisian=" + isTunisian +
                '}';
    }
}
