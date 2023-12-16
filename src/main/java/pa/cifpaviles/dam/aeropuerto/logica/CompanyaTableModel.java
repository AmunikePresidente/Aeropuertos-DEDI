/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa.cifpaviles.dam.aeropuerto.logica;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pa.cifpaviles.dam.aeropuerto.dto.Companya;

public class CompanyaTableModel extends AbstractTableModel {
    List<Companya> lstRegistros;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;

    public CompanyaTableModel(List<Companya> lstRegistros) {
        this.lstRegistros = lstRegistros;
        columnClasses = new ArrayList<>();
        columnNames = new ArrayList<>();
        columnNames.add("Prefijo");
        columnNames.add("Código");
        columnNames.add("Nombre");
        columnNames.add("Tel. Información");
        columnNames.add("Municipio");  // Añadir el nombre de la columna Municipio
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);  // Añadir la clase correspondiente para Municipio
    }
    

    @Override
    public int getRowCount() {
        return lstRegistros.size();
    }

    @Override
    public int getColumnCount() {
        return columnClasses.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Companya current = lstRegistros.get(rowIndex);
        if (current != null && columnIndex >= 0 && columnIndex < getColumnCount()) {
            switch (columnIndex) {
                case 0:
                    return current.getPrefijo();
                case 1:
                    return current.getCodigo();
                case 2:
                    return current.getNombre();
                case 3:
                    return current.getTelefonoInformacion();
                case 4:
                    return current.getMunicipio();  // Devolver el municipio
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
    
    
}
