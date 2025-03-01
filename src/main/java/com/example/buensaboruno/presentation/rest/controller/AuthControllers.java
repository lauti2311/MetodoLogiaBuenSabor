package com.example.buensaboruno.presentation.rest.controller;

import com.example.buensaboruno.business.service.IAuthService;
import com.example.buensaboruno.business.service.JWTUtilityService;
import com.example.buensaboruno.config.security.LoginDTO;
import com.example.buensaboruno.config.security.ResponseDTO;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.domain.entities.Empleado;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthControllers {

    private final IAuthService authService;
    private final JWTUtilityService jwtUtilityService;

    @Autowired
    public AuthControllers(IAuthService authService, JWTUtilityService jwtUtilityService) {
        this.authService = authService;
        this.jwtUtilityService = jwtUtilityService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody Empleado empleado) {
        try {
            ResponseDTO response = authService.register(empleado);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseDTO errorResponse = new ResponseDTO();
            errorResponse.setMessage("Error during registration: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> login(@RequestBody LoginDTO loginRequest) {
        try {
            HashMap<String, String> loginResponse = authService.login(loginRequest);
            if (loginResponse != null && loginResponse.containsKey("jwt")) {
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(loginResponse != null ? loginResponse : new HashMap<>(), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error during login: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/currentEmpleado")
    public ResponseEntity<?> getCurrentUser(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String token = authorizationHeader.replace("Bearer ", "");
            JWTClaimsSet claimsSet = jwtUtilityService.parseJWT(token);
            Long empleadoId = Long.parseLong(claimsSet.getSubject());

            Empleado empleado = authService.getEmpleadoById(empleadoId);
            if (empleado == null) {
                return ResponseEntity.status(404).body("Empleado no encontrado");
            }

            return ResponseEntity.ok(empleado);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el empleado: " + e.getMessage());
        }
    }

    @PostMapping("/registerCliente")
    public ResponseEntity<ResponseDTO> registerCliente(@RequestBody Cliente cliente) {
        try {
            ResponseDTO response = authService.registerCliente(cliente);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseDTO errorResponse = new ResponseDTO();
            errorResponse.setMessage("Error during registration: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/loginCliente")
    public ResponseEntity<HashMap<String, String>> loginCliente(@RequestBody LoginDTO loginRequest) {
        try {
            HashMap<String, String> loginResponse = authService.loginCliente(loginRequest);
            if (loginResponse != null && loginResponse.containsKey("jwt")) {
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(loginResponse != null ? loginResponse : new HashMap<>(), HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            HashMap<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error during login: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/currentCliente")
    public ResponseEntity<?> getCurrentCliente(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            String token = authorizationHeader.replace("Bearer ", "");
            JWTClaimsSet claimsSet = jwtUtilityService.parseJWT(token);
            Long clienteId = Long.parseLong(claimsSet.getSubject());

            Cliente cliente = authService.getClienteById(clienteId);
            if (cliente == null) {
                return ResponseEntity.status(404).body("Cliente no encontrado");
            }

            return ResponseEntity.ok(cliente);

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener el cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{clienteId}/domicilios")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ResponseDTO> agregarDomiciliosACliente(@PathVariable Long clienteId, @RequestBody Set<DomicilioFullDto> nuevosDomicilios) {
        try {
            ResponseDTO response = authService.agregarDomiciliosACliente(clienteId, nuevosDomicilios);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseDTO errorResponse = new ResponseDTO();
            errorResponse.setMessage("Error durante la actualización: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
