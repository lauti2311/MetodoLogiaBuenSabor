package com.example.buensaboruno.domain.entities;

import com.example.buensaboruno.domain.enums.Rol;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Rol rol;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

}
