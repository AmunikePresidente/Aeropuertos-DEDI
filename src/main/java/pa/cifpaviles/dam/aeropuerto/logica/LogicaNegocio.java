/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.cifpaviles.dam.aeropuerto.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import javax.swing.text.EditorKit;
import javax.xml.stream.events.Comment;
import pa.cifpaviles.dam.aeropuerto.dto.Aeropuerto;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;
import pa.cifpaviles.dam.aeropuerto.dto.Municipio;
import pa.cifpaviles.dam.aeropuerto.dto.VueloBase;
import pa.cifpaviles.dam.aeropuerto.dto.VueloDiario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

public class LogicaNegocio {

    //Inicializacion de variables
    public static void initializeProgram() {
        initializeMunicipios();
        initializeAeropuerto();
        initializeCompanyas();
        initializeVuelosBase();
        initializeVuelosDiario();
        String rutaCSV = "src/main/resources/vuelos_base.csv";
        List<VueloBase> vuelosCargados = leerCSVVuelosBase(rutaCSV);
    }
    private static List<Municipio> lstMunicipios = new ArrayList<>();

    private static void initializeMunicipios() {
        String rutaArchivoCSV = "src/main/resources/Municipios.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); // Asumiendo que el CSV está separado por comas
                if (partes.length >= 2) {
                    String codigo = partes[0];
                    String nombre = partes[1];
                    lstMunicipios.add(new Municipio(codigo, nombre));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Municipio> getAllMunicipios() {
        return lstMunicipios;
    }

    //<editor-fold desc="Lógica de aeropuertos"> 
    public static void initializeAeropuerto() {
        addAeropuerto(new Aeropuerto("ABC", "Aeropuerto de Albacete", "02003"));
        addAeropuerto(new Aeropuerto("OVD", "Aeropuerto de Asturias", "33016"));
        addAeropuerto(new Aeropuerto("LEN", "Aeropuerto de León", "24189"));
        addAeropuerto(new Aeropuerto("OSL", "Aeropuerto de Oslo-Gardermoen", "00000"));
    }

    private static void initializeVuelosDiario() {
        String rutaArchivoCSV = "src/main/resources/vuelos_diarios.csv";
        List<VueloDiario> vuelosDiarios = leerCsvVuelosDiarios();

        for (VueloDiario vueloDiario : vuelosDiarios) {
            addVueloDiario(vueloDiario);
        }
    }

    private static List<Aeropuerto> lstAeropuertos = new ArrayList<Aeropuerto>();

    /**
     * Añade un aeropuerto a su colección
     *
     * @param aero
     */
    public static ValidationResult addAeropuerto(Aeropuerto aero) {
        ValidationResult retValue = new ValidationResult(true, "");
        Aeropuerto aux = getAeropuertoByCodigoIATA(aero.getCodigoIATA());
        if (aux == null) {
            lstAeropuertos.add(aero);
        } else {
            retValue = new ValidationResult(false, "El código IATA del aeropuerto ya existe.No se añadirá a la lista.");
        }
        return retValue;
    }

    public static List<Aeropuerto> getAllAeropuertos() {
        return lstAeropuertos;
    }

    public static Aeropuerto getAeropuertoByCodigoIATA(String codigoIATA) {

        for (Aeropuerto a : lstAeropuertos) {
            if (a.getCodigoIATA().equals(codigoIATA)) {
                return a;
            }
        }
        return null;
    }

    public static Aeropuerto getAeropuertoBase() {
        return getAeropuertoByCodigoIATA("OVD");
    }

    //</editor-fold>
    //<editor-fold desc="Lógica de compañias">
    private static List<Companya> lstCompanyas = new ArrayList<Companya>();

    private static void initializeCompanyas() {
        String rutaArchivoCSV = "src/main/resources/companyas.csv";
        List<Companya> companyas = leerCSVCompanyas(rutaArchivoCSV);

        for (Companya companya : companyas) {
            addCompanya(companya);
        }
    }

    private static void initializeVuelosBase() {
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        List<VueloBase> vuelosBase = leerCSVVuelosBase(rutaArchivoCSV);

        for (VueloBase vueloBase : vuelosBase) {
            addVueloBase(vueloBase);
        }
    }

    public static List<Companya> getAllCompanyas() {
        return lstCompanyas;
    }

    public static Companya getCompanyaByPrefijo(int prefijo) {
        for (Companya c : lstCompanyas) {
            if (c.getPrefijo() == prefijo) {
                return c;
            }
        }
        return null;
    }

    public static Companya getCompanyaByCodigo(String codigo) {
        Optional<Companya> optValorSalida = lstCompanyas.stream()
                .filter(value -> value.getCodigo().equals(codigo))
                .findFirst();
        if (optValorSalida.isPresent()) {
            return optValorSalida.get();
        } else {
            return null;
        }
    }

    public static List<Companya> getCompanyasByMunicipio(String municipio) {
        return lstCompanyas.stream()
                .filter(value -> value.getMunicipio().equals(municipio))
                .toList();
    }

    public static ValidationResult addCompanya(Companya newComp) {
        ValidationResult retValue = new ValidationResult(true, "");
        Companya aux = getCompanyaByCodigo(newComp.getCodigo());
        if (aux == null) {
            lstCompanyas.add(newComp);
            generarCSVCompanyas(lstCompanyas);
        } else {
            retValue = new ValidationResult(false, "El código de la compañia ya existe.No se añadirá a la lista.");
        }
        return retValue;
    }

    public static void updateCompanyaByCodigo(String codigo, Companya newComp) {
        String rutaArchivoCSV = "src/main/resources/companyas.csv";
        List<Companya> companyas = leerCSVCompanyas(rutaArchivoCSV);

        // Buscar y actualizar la compañía
        for (Companya companya : companyas) {
            if (companya.getCodigo().equals(codigo)) {
                companya.setPrefijo(newComp.getPrefijo());
                companya.setNombre(newComp.getNombre());
                companya.setDireccion(newComp.getDireccion());
                companya.setMunicipio(newComp.getMunicipio());
                companya.setTelefonoPasajeros(newComp.getTelefonoPasajeros());
                companya.setTelefonoInformacion(newComp.getTelefonoInformacion());
                break;
            }
        }

        // Sobrescribir el archivo CSV con la lista actualizada
        generarCSVCompanyas(companyas);
    }

    public static ValidationResult eliminarCompanya(String codigo) {
        ValidationResult retValue = new ValidationResult(true, "");
        Companya aux = getCompanyaByCodigo(codigo);
        if (aux != null) {
            lstCompanyas.remove(aux);
            generarCSVCompanyas(lstCompanyas); // Guarda los cambios en el CSV después de eliminar
        } else {
            retValue = new ValidationResult(false, "El código de la compañía no existe.");
        }
        return retValue;
    }

    public static void generarCSVCompanyas(List<Companya> companyas) {
        String rutaArchivoCSV = "src/main/resources/companyas.csv";

        try (FileWriter writer = new FileWriter(rutaArchivoCSV)) {
            // Escribir la cabecera del CSV
            writer.append("Prefijo,Código,Nombre,Dirección,Municipio,Teléfono Pasajeros,Teléfono Información\n");

            // Escribir los datos de cada compañía
            for (Companya companya : companyas) {
                writer.append(String.format("%d,%s,%s,%s,%s,%s,%s\n",
                        companya.getPrefijo(),
                        companya.getCodigo(),
                        companya.getNombre(),
                        companya.getDireccion(),
                        companya.getMunicipio(),
                        companya.getTelefonoPasajeros(),
                        companya.getTelefonoInformacion()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Companya> leerCSVCompanyas(String rutaArchivo) {
        List<Companya> companyas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Omitir la cabecera del CSV

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                // Asegúrate de que partes tiene la cantidad correcta de elementos
                if (partes.length == 7) {
                    int prefijo = Integer.parseInt(partes[0]);
                    String codigo = partes[1];
                    String nombre = partes[2];
                    String direccion = partes[3];
                    String municipio = partes[4];
                    String telefonoPasajeros = partes[5];
                    String telefonoInformacion = partes[6];

                    Companya companya = new Companya(prefijo, codigo, nombre, direccion, municipio, telefonoPasajeros, telefonoInformacion);
                    companyas.add(companya);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return companyas;
    }

    // </editor-fold>
    //<editor-fold desc="Lógica de vuelos base">  
    private static List<VueloBase> lstVuelosBase = new ArrayList<VueloBase>();

    public static List<VueloBase> getAllVuelosBase() {
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        return leerCSVVuelosBase(rutaArchivoCSV);
    }

    public static ValidationResult addVueloBase(VueloBase vuelo) {
        ValidationResult retValue = new ValidationResult(true, "");
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        List<VueloBase> vuelos = leerCSVVuelosBase(rutaArchivoCSV);

        // Verificar si el vuelo ya existe
        boolean existe = vuelos.stream()
                .anyMatch(v -> v.getCodigoVuelo().equals(vuelo.getCodigoVuelo()));

        if (!existe) {
            vuelos.add(vuelo); // Añadir el nuevo vuelo a la lista

            // Reescribir el archivo CSV con la lista actualizada
            generarCSVVueloBase(vuelos); // Asegúrate de que este método reescribe todo el archivo CSV
        } else {
            retValue = new ValidationResult(false, "El vuelo base ya existe. No se añadirá a la lista.");
        }

        return retValue;
    }

    public static VueloBase getVueloBaseByCodigo(String codigo) {
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        List<VueloBase> todosLosVuelos = leerCSVVuelosBase(rutaArchivoCSV);

        return todosLosVuelos.stream()
                .filter(vuelo -> vuelo.getCodigoVuelo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static List<VueloBase> getVueloBasesByFecha(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
        String diaSemanaCad = "";
        switch (diaSemana) {
            case Calendar.SUNDAY:
                diaSemanaCad = "D";
                break;
            case Calendar.MONDAY:
                diaSemanaCad = "L";
                break;
            case Calendar.TUESDAY:
                diaSemanaCad = "M";
                break;
            case Calendar.WEDNESDAY:
                diaSemanaCad = "X";
                break;
            case Calendar.THURSDAY:
                diaSemanaCad = "J";
                break;
            case Calendar.FRIDAY:
                diaSemanaCad = "V";
                break;
            case Calendar.SATURDAY:
                diaSemanaCad = "S";
                break;
            default:
                diaSemanaCad = "";
        }
        return getVueloBaseByDiaSemana(diaSemanaCad);
    }

    public static List<VueloBase> getVueloBaseByDiaSemana(String diaSemana) {
        List<VueloBase> lstVueloByDiaSemana = (List<VueloBase>) lstVuelosBase.stream()
                .filter(v -> v.getDiasOperacion()
                .contains(diaSemana))
                .toList();
        return lstVueloByDiaSemana;
    }

    public static List<VueloBase> getVueloBaseByAeropuertoOrigen(String codigoIATA) {
        //List<VueloBase> lstVuelosByAeropuertoOrigen
        return lstVuelosBase.stream()
                .filter(v -> v.getCodigoAeropuertoOrigen().equals(codigoIATA))
                .toList();
    }

    public static List<VueloBase> getVueloBaseByAeropuretoDestino(String codigoIATA) {
        return lstVuelosBase.stream()
                .filter(v -> v.getCodigoAeropuertoDestino().equals(codigoIATA))
                .toList();
    }

    public static void updateVueloBaseByCodigo(String codigo, VueloBase newVuelo) {
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        List<VueloBase> vuelos = leerCSVVuelosBase(rutaArchivoCSV);

        // Encontrar el índice del vuelo a actualizar
        int index = -1;
        for (int i = 0; i < vuelos.size(); i++) {
            if (vuelos.get(i).getCodigoVuelo().equals(codigo)) {
                index = i;
                break;
            }
        }

        // Actualizar el vuelo si se encuentra
        if (index != -1) {
            vuelos.set(index, newVuelo);
            generarCSVVueloBase(vuelos); // Actualizar el archivo CSV
        } else {
            // Opcional: Manejar el caso de que el vuelo no exista
            System.out.println("Vuelo no encontrado para actualizar.");
        }
    }

    public static void deleteVueloBaseByCodigo(String codigo) {
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        List<VueloBase> vuelos = leerCSVVuelosBase(rutaArchivoCSV);

        List<VueloBase> remainingVuelos = vuelos.stream()
                .filter(vuelo -> !vuelo.getCodigoVuelo().equals(codigo))
                .collect(Collectors.toList());

        generarCSVVueloBase(remainingVuelos);  // Método que reescribe todo el archivo CSV
    }

    public static void generarCSVVueloBase(List<VueloBase> vuelos) {
        String rutaArchivoCSV = "src/main/resources/vuelos_base.csv";
        File file = new File(rutaArchivoCSV);

        try (FileWriter writer = new FileWriter(file)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            // Escribir la cabecera del CSV
            writer.append("Código Vuelo,Num. Plazas,Hora Salida,Hora Llegada,Días Operación,Código Aeropuerto Origen,Código Aeropuerto Destino\n");

            // Escribir los datos de cada vuelo
            for (VueloBase vuelo : vuelos) {
                writer.append(String.format("%s,%d,%s,%s,%s,%s,%s\n",
                        vuelo.getCodigoVuelo(),
                        vuelo.getNumeroPlazas(),
                        dateFormat.format(vuelo.getHoraSalida()),
                        dateFormat.format(vuelo.getHoraLlegada()),
                        vuelo.getDiasOperacion(),
                        vuelo.getCodigoAeropuertoOrigen(),
                        vuelo.getCodigoAeropuertoDestino()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<VueloBase> leerCSVVuelosBase(String rutaArchivo) {
        List<VueloBase> vuelos = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Omitir la cabecera del CSV

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                // Asegúrate de que partes tiene la cantidad correcta de elementos
                if (partes.length == 7) {
                    VueloBase vuelo = new VueloBase();
                    vuelo.setCodigoVuelo(partes[0]);
                    vuelo.setNumeroPlazas(Integer.parseInt(partes[1]));
                    vuelo.setHoraSalida(dateFormat.parse(partes[2]));
                    vuelo.setHoraLlegada(dateFormat.parse(partes[3]));
                    vuelo.setDiasOperacion(partes[4]);
                    vuelo.setCodigoAeropuertoOrigen(partes[5]);
                    vuelo.setCodigoAeropuertoDestino(partes[6]);

                    vuelos.add(vuelo);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return vuelos;
    }

    public static boolean validarDatosVueloDiario(String codigoVueloBase, Date horaSalida, Date horaLlegada) {
        VueloBase vueloBase = LogicaNegocio.getVueloBaseByCodigo(codigoVueloBase);
        if (vueloBase == null) {
            return false; // No existe un VueloBase con ese código
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String horaSalidaBase = dateFormat.format(vueloBase.getHoraSalida());
        String horaLlegadaBase = dateFormat.format(vueloBase.getHoraLlegada());
        String horaSalidaDiario = dateFormat.format(horaSalida);
        String horaLlegadaDiario = dateFormat.format(horaLlegada);

        return horaSalidaBase.equals(horaSalidaDiario) && horaLlegadaBase.equals(horaLlegadaDiario);
    }

    //</editor-fold>
    //<editor-fold desc="Lógica de vuelos diarios">  
    private static List<VueloDiario> lstVuelosDiarios = new ArrayList<VueloDiario>();

    public static List<VueloDiario> getAllVuelosDiarios() {
        // Define la ruta del archivo CSV
        String rutaArchivo = "ruta/del/archivo.csv"; // Reemplaza con la ruta correcta
        List<VueloDiario> vuelosDiarios = leerCsvVuelosDiarios();

        return vuelosDiarios;
    }

    public static VueloDiario getVueloDiarioByCodigoVueloBase(String codigo) {
        // Define la ruta del archivo CSV
        String rutaArchivo = "ruta/del/archivo.csv"; // Reemplaza con la ruta correcta

        // Llama a leerCSVVuelosDiarios para obtener la lista de vuelos diarios desde el archivo CSV
        List<VueloDiario> vuelosDiarios = leerCsvVuelosDiarios();

        // Busca el vuelo diario con el código de vuelo base especificado
        for (VueloDiario vueloDiario : vuelosDiarios) {
            if (vueloDiario.getCodigoVueloBase().equals(codigo)) {
                return vueloDiario;
            }
        }

        // Si no se encuentra, devuelve null o maneja la situación según tus necesidades
        return null;
    }

    public static VueloDiario getVueloDiarioByFecha(Date fecha) {
        // Define la ruta del archivo CSV
        String rutaArchivo = "ruta/del/archivo.csv"; // Reemplaza con la ruta correcta

        // Llama a leerCSVVuelosDiarios para obtener la lista de vuelos diarios desde el archivo CSV
        List<VueloDiario> vuelosDiarios = leerCsvVuelosDiarios();

        // Busca el vuelo diario con la fecha especificada
        for (VueloDiario vueloDiario : vuelosDiarios) {
            if (vueloDiario.getFechaVuelo().equals(fecha)) {
                return vueloDiario;
            }
        }

        // Si no se encuentra, devuelve null o maneja la situación según tus necesidades
        return null;
    }

    public static Date getFechaByHora(int horas, int minutos) {
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 1, 1, horas, minutos);
        Date fecha = cal.getTime();
        return fecha;
    }

    public static String getHoraFecha(Date fecha) {
        SimpleDateFormat adf = new SimpleDateFormat("HH:mm");
        return adf.format(fecha);
    }

    public static void generarCSVVueloDiario(List<VueloDiario> vuelosDiarios) {
        String rutaArchivoCSV = "src/main/resources/vuelos_diarios.csv";
        File file = new File(rutaArchivoCSV);

        try (FileWriter writer = new FileWriter(file)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            // Escribir la cabecera del CSV
            writer.append("Código Vuelo Base,Fecha Vuelo,Hora Salida,Hora Llegada,Num. Plazas Ocupadas,Precio Vuelo\n");

            // Escribir los datos de cada vuelo diario
            for (VueloDiario vueloDiario : vuelosDiarios) {
                Date horaSalida = vueloDiario.getHoraSalida();
                Date horaLlegada = vueloDiario.getHoraLlegada();

                // Validar los datos del vuelo diario
                if (!validarDatosVueloDiario(vueloDiario.getCodigoVueloBase(), horaSalida, horaLlegada)) {
                    continue;
                }

                writer.append(String.format("%s,%s,%s,%s,%d,%.2f\n",
                        vueloDiario.getCodigoVueloBase(),
                        dateFormat.format(vueloDiario.getFechaVuelo()),
                        dateFormat.format(horaSalida),
                        dateFormat.format(horaLlegada),
                        vueloDiario.getNumeroPlazasOcupadas(),
                        vueloDiario.getPrecioVuelo()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<VueloDiario> leerCsvVuelosDiarios() {
        List<VueloDiario> vuelosDiarios = new ArrayList<>();
        String rutaArchivoCSV = "src/main/resources/vuelos_diarios.csv";
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoCSV))) {
            String line;
            br.readLine(); // Salta la cabecera del CSV

            while ((line = br.readLine()) != null) {
                String[] valores = line.split(",");

                if (valores.length != 6) {
                    // Manejar error si el número de columnas es incorrecto
                    continue;
                }

                VueloDiario vueloDiario = new VueloDiario();
                vueloDiario.setCodigoVueloBase(valores[0]);
                vueloDiario.setFechaVuelo(dateFormat.parse(valores[1]));
                vueloDiario.setHoraSalida(dateFormat.parse(valores[2]));
                vueloDiario.setHoraLlegada(dateFormat.parse(valores[3]));
                vueloDiario.setNumeroPlazasOcupadas(Integer.parseInt(valores[4]));
                vueloDiario.setPrecioVuelo(Float.parseFloat(valores[5]));

                vuelosDiarios.add(vueloDiario);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return vuelosDiarios;
    }

    //</editor-fold>
    public static ValidationResult addVueloDiario(VueloDiario newVueloDiario) {
        ValidationResult retValue = new ValidationResult(true, "");

        // Validar que los datos del vuelo diario coinciden con los de vuelo base
        if (!validarDatosVueloDiario(newVueloDiario.getCodigoVueloBase(),
                newVueloDiario.getHoraSalida(),
                newVueloDiario.getHoraLlegada())) {
            return new ValidationResult(false, "Los datos del vuelo diario no coinciden con el vuelo base.");
        }

        // Validar si ya existe un vuelo diario con el mismo código de vuelo base y fecha
        boolean existe = lstVuelosDiarios.stream()
                .anyMatch(v -> v.getCodigoVueloBase().equals(newVueloDiario.getCodigoVueloBase())
                && v.getFechaVuelo().equals(newVueloDiario.getFechaVuelo()));

        if (!existe) {
            lstVuelosDiarios.add(newVueloDiario);
            generarCSVVueloDiario(lstVuelosDiarios);
        } else {
            retValue = new ValidationResult(false, "Ya existe un vuelo diario con este código de vuelo base y fecha. No se añadirá a la lista.");
        }

        return retValue;
    }

}
