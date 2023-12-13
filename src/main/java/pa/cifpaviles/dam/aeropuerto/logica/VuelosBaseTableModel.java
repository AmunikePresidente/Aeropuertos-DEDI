/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.cifpaviles.dam.aeropuerto.logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pa.cifpaviles.dam.aeropuerto.dto.VueloBase;

/**
 *
 * @author ismap
 */
public class VuelosBaseTableModel extends AbstractTableModel {
    List<VueloBase> lstVuelosBase;
    ArrayList<String> columnNames;
    ArrayList<Class<?>> columnClasses;

    public VuelosBaseTableModel(List<VueloBase> lstVuelosBase) {
        this.lstVuelosBase = lstVuelosBase;
        columnClasses = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("Código Vuelo");
        columnNames.add("Número de Plazas");
        columnNames.add("Hora Salida");
        columnNames.add("Hora Llegada");
        columnNames.add("Días de Operación");
        columnNames.add("Código Aeropuerto Origen");
        columnNames.add("Código Aeropuerto Destino");
        columnClasses.add(String.class);
        columnClasses.add(Integer.class);
        columnClasses.add(String.class); // O Date.class si usas un formato específico para la hora
        columnClasses.add(String.class); // O Date.class
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
    }
    

    @Override
    public int getRowCount() {
        return lstVuelosBase.size();
    }

    @Override
    public int getColumnCount() {
        return columnClasses.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VueloBase current = lstVuelosBase.get(rowIndex);
        if (current != null
                && columnIndex >= 0
                && columnIndex < getColumnCount()) {
            switch (columnIndex) {
                case 0:
                    return current.getCodigoVuelo();
                case 1:
                    return current.getNumeroPlazas();
                case 2:
                    return current.getHoraSalida(); // Formatear si es necesario
                case 3:
                    return current.getHoraLlegada(); // Formatear si es necesario
                case 4:
                    return current.getDiasOperacion();
                case 5:
                    return current.getCodigoAeropuertoOrigen();
                case 6:
                    return current.getCodigoAeropuertoDestino();
                default:
                    return "";
            }

        }
        else
            return "";
        
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