package com.uabc.edu.saad.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Table(name = "TBL_ANIMAL")
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="tipo", nullable=false, length = 225)
    private String tipo;

    @Column(name="raza", nullable= false, length=225)
    private String raza;

    @Column(name="color", nullable=false, length = 225)
    private String color;

    @Column(name="pelaje", nullable=false, length = 225)
    private String pelaje;

    @Column(name = "fecha_nacimiento", nullable=false, length = 225)
    private Date fechanacimiento;

    @Column(name = "vacunas", nullable=false, length = 225)
    private String vacunas;

    public AnimalEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPelaje() {
        return pelaje;
    }

    public void setPelaje(String pelaje) {
        this.pelaje = pelaje;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    @Override
    public String toString() {
        return "AnimalEntity[id=" + id + ",tipo=" + tipo + ",raza=" + raza + ",pelaje=" + pelaje + ",fecha_nacimiento=" + fechanacimiento + ",vacunas=" + vacunas + "]";
    }
}
