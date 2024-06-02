package com.example.buensaboruno.domain.dto.domicilio;


import com.example.buensaboruno.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DomicilioShortDto extends BaseDto {
    private String calle;
    private Integer cp;
}
