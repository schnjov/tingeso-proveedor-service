package cl.usach.tingeso.proveedorservice.Repositories;
import cl.usach.tingeso.proveedorservice.Entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {
    public List<ProveedorEntity> findByCategoria(String categoria);
    ProveedorEntity findByCodigo(String codigo);
}

