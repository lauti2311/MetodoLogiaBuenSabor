package com.example.buensaboruno.domain.dto.empleado;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoFullDto extends BaseDto {
    private Rol tipoEmpleado;

}
