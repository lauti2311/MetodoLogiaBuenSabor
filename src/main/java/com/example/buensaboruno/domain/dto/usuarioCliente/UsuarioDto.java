package com.example.buensaboruno.domain.dto.usuarioCliente;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto extends BaseDto {
    private String username;
    private String email;
    private String password;
    private Rol rol;
    private EmpleadoShortDto empleado;

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class EmpleadoShortDto {
        private Rol tipoEmpleado;
        private SucursalShortDto sucursal;


    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class SucursalShortDto {
        private Long id;
    }
}




