
package com.example.buensaboruno.business.service.Imp;

import com.example.buensaboruno.business.service.IAuthService;
import com.example.buensaboruno.business.service.JWTUtilityService;
import com.example.buensaboruno.config.security.LoginDTO;
import com.example.buensaboruno.config.security.ResponseDTO;
import com.example.buensaboruno.config.security.UserValidation;
import com.example.buensaboruno.domain.dto.domicilio.DomicilioFullDto;
import com.example.buensaboruno.domain.entities.Cliente;
import com.example.buensaboruno.domain.entities.Domicilio;
import com.example.buensaboruno.domain.entities.Empleado;

import com.example.buensaboruno.repositories.ClienteRepository;
import com.example.buensaboruno.repositories.DomicilioRepository;
import com.example.buensaboruno.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private JWTUtilityService jwtUtilityService;

    @Autowired
    private UserValidation userValidation;

    @Override
    public HashMap<String, String> login(LoginDTO login) throws Exception {
        HashMap<String, String> jwt = new HashMap<>();
        try {
            Optional<Empleado> optionalEmpleado = empleadoRepository.findByEmail(login.getEmail());

            if (optionalEmpleado.isPresent()) {
                Empleado empleado = optionalEmpleado.get();
                if (verifyPassword(login.getClave(), empleado.getClave())) {
                    jwt.put("jwt", jwtUtilityService.generateJWT(empleado.getId(), empleado.getTipoEmpleado().name()));
                } else {
                    jwt.put("error", "Credenciales incorrectas");
                }
            } else {
                jwt.put("error", "Empleado no encontrado");
            }

            return jwt;
        } catch (Exception e) {
            jwt.put("error", "Error durante el login: " + e.getMessage());
            return jwt;
        }
    }

    @Override
    public ResponseDTO register(Empleado empleado) throws Exception {
        try {
            ResponseDTO response = userValidation.validate(empleado);

            if (response.getNumOfErrors() > 0) {
                return response;
            }

            Optional<Empleado> existingEmpleado = empleadoRepository.findByEmail(empleado.getEmail());

            if (existingEmpleado.isPresent()) {
                response.setNumOfErrors(1);
                response.setMessage("Empleado ya registrado");
                return response;
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            empleado.setClave(encoder.encode(empleado.getClave()));
            empleadoRepository.save(empleado);
            response.setMessage("Empleado registrado exitosamente");

            return response;

        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }

    @Override
    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }


    public HashMap<String, String> loginCliente(LoginDTO login) throws Exception {
        HashMap<String, String> jwt = new HashMap<>();
        try {
            Optional<Cliente> optionalCliente = clienteRepository.findByEmail(login.getEmail());

            if (optionalCliente.isPresent()) {
                Cliente cliente = optionalCliente.get();
                if (verifyPassword(login.getClave(), cliente.getClave())) {
                    jwt.put("jwt", jwtUtilityService.generateJWT(cliente.getId(), "CLIENTE"));
                } else {
                    jwt.put("error", "Credenciales incorrectas");
                }
            } else {
                jwt.put("error", "Cliente no encontrado");
            }

            return jwt;
        } catch (Exception e) {
            jwt.put("error", "Error durante el login: " + e.getMessage());
            return jwt;
        }
    }


    @Transactional
    public ResponseDTO registerCliente(Cliente cliente) throws Exception {
        try {
            ResponseDTO response = userValidation.validateCliente(cliente);

            if (response.getNumOfErrors() > 0) {
                return response;
            }

            Optional<Cliente> existingCliente = clienteRepository.findByEmail(cliente.getEmail());

            if (existingCliente.isPresent()) {
                response.setNumOfErrors(1);
                response.setMessage("Cliente ya registrado");
                return response;
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            cliente.setClave(encoder.encode(cliente.getClave()));

            // Guardar los domicilios nuevos
            for (Domicilio domicilio : cliente.getDomicilios()) {
                // Asignar un ID nulo o 0 si es necesario para crear un domicilio nuevo
                domicilio.setId(null); // O domicilio.setId(0L); dependiendo de cómo manejes los IDs
                domicilioRepository.save(domicilio);
            }

            // Guardar el cliente y sus domicilios asociados
            clienteRepository.save(cliente);
            response.setMessage("Cliente registrado exitosamente");

            return response;

        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    @Transactional
    public ResponseDTO agregarDomiciliosACliente(Long clienteId, Set<DomicilioFullDto> nuevosDomicilios) {
        try {
            ResponseDTO response = new ResponseDTO();

            Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);

            if (!optionalCliente.isPresent()) {
                response.setNumOfErrors(1);
                response.setMessage("Cliente no encontrado");
                return response;
            }

            Cliente cliente = optionalCliente.get();

            for (DomicilioFullDto domicilioDto : nuevosDomicilios) {
                Domicilio domicilio = new Domicilio();
                domicilio.setCalle(domicilioDto.getCalle());
                domicilio.setNumero(domicilioDto.getNumero());
                domicilio.setCp(domicilioDto.getCp());
                domicilio.setPiso(domicilioDto.getPiso());
                domicilio.setNroDpto(domicilioDto.getNroDpto());
                domicilio.setLocalidad(domicilioDto.getLocalidad().toEntity()); // Asumiendo que tienes un método para convertir LocalidadFullDto a Localidad

                domicilio.getClientes().add(cliente); // Asociar el domicilio al cliente
                domicilioRepository.save(domicilio);
                cliente.getDomicilios().add(domicilio); // Asociar el cliente al domicilio
            }

            // Guardar el cliente actualizado
            clienteRepository.save(cliente);
            response.setMessage("Domicilios agregados exitosamente");

            return response;

        } catch (Exception e) {
            throw new RuntimeException("Error al agregar domicilios: " + e.getMessage());
        }
    }


    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
