package com.example.buensaboruno.domain.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ImagenCliente extends Base{
    private String name;

    private String url;
}
