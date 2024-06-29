package com.example.buensaboruno.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class Empresa extends Base{

    private String nombre;
    private String razonSocial;
    private Long cuil;

    @OneToMany(mappedBy = "empresa",cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
//    @ToString.Exclude
//    @Builder.Default
    @Builder.Default
    @JsonIgnore
    private Set<Sucursal> sucursales= new HashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_empresa")
    @NotAudited
    private Set<ImagenEmpresa> imagenes;

}
