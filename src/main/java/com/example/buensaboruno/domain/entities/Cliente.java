package com.example.buensaboruno.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Audited
public class Cliente extends Base{

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToOne
    private Usuario usuario;
}
