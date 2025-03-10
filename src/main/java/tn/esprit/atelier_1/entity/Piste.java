package tn.esprit.atelier_1.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.atelier_1.enums.Color;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "pistes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String namePiste;
    @Enumerated(EnumType.STRING)
    private Color color;
    private int length;
    private int slope;
    @ManyToMany
    @JsonIgnore
    private Set<Skier> skiers;
}
