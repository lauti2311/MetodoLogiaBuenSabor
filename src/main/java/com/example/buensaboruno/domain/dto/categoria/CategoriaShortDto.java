package com.example.buensaboruno.domain.dto.categoria;



import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaShortDto extends BaseDto {
    private String denominacion;
    private boolean esInsumo;
}
