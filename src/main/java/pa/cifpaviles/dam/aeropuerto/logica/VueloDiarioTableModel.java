/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.cifpaviles.dam.aeropuerto.logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pa.cifpaviles.dam.aeropuerto.dto.VueloDiario;

/**
 *
 * @author ismap
 */
public class VueloDiarioTableModel extends AbstractTableModel {

    List<VueloDiario> lstVuelosDiarios;
    ArrayList<String> columnNames;
    ArrayList<Class<?>> columnClasses;

    public VueloDiarioTableModel(List<VueloDiario> lstVuelosDiarios) {
        this.lstVuelosDiarios = lstVuelosDiarios;
        columnClasses = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("Código Vuelo Base");
        columnNames.add("Fecha Vuelo");
        columnNames.add("Hora Salida");
        columnNames.add("Hora Llegada");
        columnNames.add("Número de Plazas Ocupadas");
        columnNames.add("Precio Vuelo");
        columnClasses.add(String.class);
        columnClasses.add(String.class); 
        columnClasses.add(String.class); 
        columnClasses.add(String.class); 
        columnClasses.add(Integer.class);
        columnClasses.add(Float.class);
    }

    @Override
    public int getRowCount() {
        return lstVuelosDiarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnClasses.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VueloDiario current = lstVuelosDiarios.get(rowIndex);
        if (current != null && columnIndex >= 0 && columnIndex < getColumnCount()) {
            switch (columnIndex) {
                case 0:
                    return current.getCodigoVueloBase();
                case 1:
                    return current.getFechaVuelo(); // Formatear si es necesario
                case 2:
                    return current.getHoraSalida(); // Formatear si es necesario
                case 3:
                    return current.getHoraLlegada(); // Formatear si es necesario
                case 4:
                    return current.getNumeroPlazasOcupadas();
                case 5:
                    return current.getPrecioVuelo();
                default:
                    return "";
            }
        } else {
            return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses.get(columnIndex);
    }

}
