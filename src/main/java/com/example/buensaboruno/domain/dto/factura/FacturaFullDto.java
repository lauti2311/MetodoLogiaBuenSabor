package com.example.buensaboruno.domain.dto.factura;

import com.example.buensaboruno.domain.dto.BaseDto;
import com.example.buensaboruno.domain.enums.FormaPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FacturaFullDto extends BaseDto {
    private LocalDate fechaFcturacion;
    private Integer mpPaymentId;
    private Integer mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private Double totalVenta;

}
