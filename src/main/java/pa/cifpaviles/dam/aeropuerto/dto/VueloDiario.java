package pa.cifpaviles.dam.aeropuerto.dto;

import java.util.Date;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;

public class VueloDiario {
    private String codigoVueloBase;
    private Date fechaVuelo;
    private Date horaSalida;
    private Date horaLlegada;
    private int numeroPlazasOcupadas;
    private float precioVuelo;
    private VueloBase vueloBase;

    public VueloDiario() {
    }

    public VueloDiario(String codigoVueloBase, Date fechaVuelo, Date horaSalida, Date horaLlegada, int numeroPlazasOcupadas, float precioVuelo, VueloBase vueloBase) {
        this.codigoVueloBase = codigoVueloBase;
        this.fechaVuelo = fechaVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.numeroPlazasOcupadas = numeroPlazasOcupadas;
        this.precioVuelo = precioVuelo;
        this.vueloBase = vueloBase;
    }

    public VueloDiario(Date fechaVuelo, Date horaSalida, Date horaLlegada, int numeroPlazasOcupadas, float precioVuelo, VueloBase vueloBase) {
        this.fechaVuelo = fechaVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.numeroPlazasOcupadas = numeroPlazasOcupadas;
        this.precioVuelo = precioVuelo;
        this.vueloBase = vueloBase;
    }

    public String getCodigoVueloBase() {
        return codigoVueloBase;
    }

    public void setCodigoVueloBase(String codigoVueloBase) {
        this.codigoVueloBase = codigoVueloBase;
        this.vueloBase = LogicaNegocio.getVueloBaseByCodigo(codigoVueloBase);
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getNumeroPlazasOcupadas() {
        return numeroPlazasOcupadas;
    }

    public void setNumeroPlazasOcupadas(int numeroPlazasOcupadas) {
        this.numeroPlazasOcupadas = numeroPlazasOcupadas;
    }

    public float getPrecioVuelo() {
        return precioVuelo;
    }

    public void setPrecioVuelo(float precioVuelo) {
        this.precioVuelo = precioVuelo;
    }

    public VueloBase getVueloBase() {
        return vueloBase;
    }

    public void setVueloBase(VueloBase vueloBase) {
        this.vueloBase = vueloBase;
        this.codigoVueloBase = vueloBase.getCodigoVuelo();
    } 
    
    
}
