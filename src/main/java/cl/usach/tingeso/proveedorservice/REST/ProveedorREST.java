package cl.usach.tingeso.proveedorservice.REST;

import cl.usach.tingeso.proveedorservice.Entities.ProveedorEntity;
import cl.usach.tingeso.proveedorservice.Services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin("*")
public class ProveedorREST {
    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorEntity>> getAll(){
        List<ProveedorEntity> proveedores = proveedorService.findAll();
        if (proveedores.isEmpty()){
            return ResponseEntity.noContent().build();
        }else
            return ResponseEntity.ok().body(proveedores);
    }

    @PostMapping
    public ResponseEntity<ProveedorEntity> save(@RequestBody ProveedorEntity proveedor){
        return proveedorService.save(proveedor);
    }

    @GetMapping("/exist/{codigo}")
    public ResponseEntity<Boolean> exist(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok().body(proveedorService.exist(codigo));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProveedorEntity> getByCodigo(@PathVariable("codigo") String codigo){
        return proveedorService.getByCodigo(codigo);
    }

}