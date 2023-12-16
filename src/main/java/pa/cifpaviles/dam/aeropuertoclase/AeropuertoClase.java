package pa.cifpaviles.dam.aeropuertoclase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import pa.cifpaviles.dam.aeropuerto.dto.Aeropuerto;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;
import pa.cifpaviles.dam.aeropuerto.dto.VueloBase;
import pa.cifpaviles.dam.aeropuerto.dto.VueloDiario;
import pa.cifpaviles.dam.aeropuerto.gui.FrmMain;
import pa.cifpaviles.dam.aeropuerto.logica.LogicaNegocio;
import pa.cifpaviles.dam.aeropuerto.logica.ValidationResult;

public class AeropuertoClase {

    public static void main(String[] args) {
        LogicaNegocio.initializeProgram();
        Aeropuerto aeropuertoBase = LogicaNegocio.getAeropuertoBase();
        List<Companya> lista = LogicaNegocio.getAllCompanyas();
        List<Companya> compMadrid = LogicaNegocio.getCompanyasByMunicipio("28079");

        FrmMain main = new FrmMain();

        main.setVisible(
                true);
    }
}
