package com.project.crochetpersonal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hookId;
    private double size;
    private String style;
    private String material;
    private double cost;
    private boolean isTunisian;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hook hook = (Hook) o;
        return hookId == hook.hookId && Double.compare(size, hook.size) == 0 && Double.compare(cost, hook.cost) == 0 && isTunisian == hook.isTunisian && Objects.equals(style, hook.style) && Objects.equals(material, hook.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hookId, size, style, material, cost, isTunisian);
    }

    @Override
    public String toString() {
        return "Hook{" +
                "hookId=" + hookId +
                ", size=" + size +
                ", style='" + style + '\'' +
                ", material='" + material + '\'' +
                ", cost=" + cost +
                ", isTunisian=" + isTunisian +
                '}';
    }
}
