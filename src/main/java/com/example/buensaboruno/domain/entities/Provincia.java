package com.example.buensaboruno.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class Provincia extends Base {
    private String nombre;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pais_id")
    private Pais pais;

}
