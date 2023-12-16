package pa.cifpaviles.dam.aeropuerto.dto;

import java.util.Date;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;

public class VueloBase {
    private String codigoVuelo;
    private int numeroPlazas;
    private Date horaSalida;
    private Date horaLlegada;
    private String diasOperacion;
    private String codigoAeropuertoDestino;
    private String codigoAeropuertoOrigen;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;

    public VueloBase() {
    }

    public VueloBase(String codigoVuelo, int numeroPlazas, Date horaSalida, Date horaLlegada, String diasOperacion, String codigoAeropuertoOrigen, String codigoAeropuertoDestino) {
        this.codigoVuelo = codigoVuelo;
        this.numeroPlazas = numeroPlazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOperacion = diasOperacion;
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo; 
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
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

    public String getDiasOperacion() {
        return diasOperacion;
    }

    public void setDiasOperacion(String diasOperacion) {
        this.diasOperacion = diasOperacion;
    }

    public String getCodigoAeropuertoDestino() {
        return codigoAeropuertoDestino;
    }

    public void setCodigoAeropuertoDestino(String codigoAeropuertoDestino) {
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
        this.aeropuertoDestino = LogicaNegocio.getAeropuertoByCodigoIATA(codigoAeropuertoDestino);
    }

    public String getCodigoAeropuertoOrigen() {
        this.aeropuertoOrigen = LogicaNegocio.getAeropuertoByCodigoIATA(codigoAeropuertoOrigen);
        return codigoAeropuertoOrigen;
    }

    public void setCodigoAeropuertoOrigen(String codigoAeropuertoOrigen) {
        this.codigoAeropuertoOrigen = codigoAeropuertoOrigen;
        this.aeropuertoOrigen = LogicaNegocio.getAeropuertoByCodigoIATA(codigoAeropuertoOrigen);
    }

    public Aeropuerto getAeropuertoOrigen() {
        this.codigoAeropuertoOrigen = aeropuertoOrigen.getCodigoIATA();
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.codigoAeropuertoOrigen = aeropuertoOrigen.getCodigoIATA();
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
        this.codigoAeropuertoDestino = aeropuertoDestino.getCodigoIATA(); 
    }  
}
