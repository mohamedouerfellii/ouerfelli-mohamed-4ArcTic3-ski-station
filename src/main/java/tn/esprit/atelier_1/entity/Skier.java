package tn.esprit.atelier_1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "skiers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkier;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;
    @ManyToMany(mappedBy = "skiers", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Piste> pistes;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Subscription subscription;
    @OneToMany(mappedBy = "skier")
    private Set<Registration> registrations;
}
