package cl.usach.tingeso.proveedorservice.Services;

import cl.usach.tingeso.proveedorservice.Entities.ProveedorEntity;
import cl.usach.tingeso.proveedorservice.Repositories.ProveedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorService(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    private final static Logger logger = LoggerFactory.getLogger(ProveedorService.class);
    public List<ProveedorEntity> findAll() {
        List<ProveedorEntity> proveedores = proveedorRepository.findAll();
        logger.info(proveedores.toString());
        return proveedorRepository.findAll();
    }

    public ResponseEntity<ProveedorEntity> save(ProveedorEntity proveedorEntity) {
        try {
            if (exist(proveedorEntity.getCodigo()))
                throw new RuntimeException(); // Si se encuentra un proveedor existente con el mismo código, lanza una excepción.
            ProveedorEntity _proveedorEntity = proveedorRepository.save(proveedorEntity); // Si no se encuentra un proveedor existente con el mismo código, guarda el nuevo proveedor en la base de datos.
            return ResponseEntity.created(new URI("/proveedor/save" + _proveedorEntity.getCodigo())).body(_proveedorEntity); // Devuelve una respuesta HTTP 201 (CREATED) con una URI que apunta al recurso recién creado. El cuerpo de la respuesta contiene el objeto proveedor guardado.
        } catch (Exception e) {
            return ResponseEntity.status(400).build(); // Si se produce una excepción al intentar guardar el proveedor, devuelve una respuesta HTTP 400 (BAD REQUEST).
        }
    }

    public ProveedorEntity findByCodigo(String proveedorCodigo) {
        return proveedorRepository.findByCodigo(proveedorCodigo);
    }

    public ProveedorEntity getProveedorByCodigo(String codigoProveedor) {
        return proveedorRepository.findByCodigo(codigoProveedor);
    }

    public Boolean exist(String codigo) {
        return proveedorRepository.existsById(codigo);
    }
}
