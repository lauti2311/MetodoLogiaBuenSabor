package com.example.buensaboruno.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
//@Audited
public class Categoria extends Base {

    @Column(nullable = false)
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @OneToMany(mappedBy = "categoriaPadre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_padre_id")
    @JsonBackReference(value = "categoria_categoriaPadre")
    private Categoria categoriaPadre;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + getId() +
                ", denominacion='" + denominacion + '\'' +
                ", sucursales=" + sucursalesToString() +
                ", articulos=" + articulosToString() +
                ", subCategorias=" + subCategoriasToString() +
                ", categoriaPadre=" + (categoriaPadre != null ? categoriaPadre.getId() : "null") +
                '}';
    }

    private String sucursalesToString() {
        if (sucursales == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (Sucursal sucursal : sucursales) {
            sb.append(sucursal.getId()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private String articulosToString() {
        if (articulos == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (Articulo articulo : articulos) {
            sb.append(articulo.getId()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private String subCategoriasToString() {
        if (subCategorias == null) return "null";
        StringBuilder sb = new StringBuilder("[");
        for (Categoria subCategoria : subCategorias) {
            sb.append(subCategoria.getId()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
