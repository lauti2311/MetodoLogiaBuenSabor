package com.example.buensaboruno.business.service.Imp;


import com.example.buensaboruno.business.service.Base.BaseServiceImpl;
import com.example.buensaboruno.business.service.FacturaService;
import com.example.buensaboruno.domain.entities.Factura;
import com.example.buensaboruno.repositories.FacturaRepository;
import org.springframework.stereotype.Service;


@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

}
