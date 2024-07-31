package com.example.buensaboruno.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@Audited
public class PromocionDetalle extends Base{
    private int cantidad;

    @ManyToOne
    private Articulo articulo;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "promocion_id")
//    private Promocion promocion;
}
