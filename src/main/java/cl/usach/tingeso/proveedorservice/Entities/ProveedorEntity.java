package cl.usach.tingeso.proveedorservice.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorEntity {
    @Id
    @Column(name = "proveedor_codigo", nullable = false)
    private String codigo;
    private String nombre;
    private String categoria;
    private Boolean afectoARetencion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getAfectoARetencion() {
        return afectoARetencion;
    }

    public void setAfectoARetencion(Boolean afectoARetencion) {
        this.afectoARetencion = afectoARetencion;
    }
}
