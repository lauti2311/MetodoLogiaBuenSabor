package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.enums.Rol;
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
public class Usuario extends Base{
    private String auth0Id;
    private String username;
    private String email;

    @Enumerated(EnumType.ORDINAL)
    private Rol rol;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

}
