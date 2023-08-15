package com.bezkoder.springjwt.models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Offre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String pays;
    @Enumerated(EnumType.STRING)
    private TypeExcursion TypeEx;
    @ManyToMany(mappedBy = "offres")
    private Set<User> users = new HashSet<>();
}

