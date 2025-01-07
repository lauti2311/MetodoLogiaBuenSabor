package com.example.buensaboruno.domain.dto.empleado;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpleadoFullDto extends BaseDto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String clave;
    private LocalDate fechaNacimiento;
    private Rol tipoEmpleado;

}
