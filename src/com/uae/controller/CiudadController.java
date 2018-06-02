package com.uae.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import com.uae.model.Ciudad;
import com.uae.model.CiudadModel;



@SuppressWarnings("rawtypes")
public class CiudadController  extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables de la vista
	Listbox lstCiudades;
	Textbox txtNombre;
	Textbox txtPais;
	Textbox txtCont;

	
	//Variables globales
	Ciudad ciudad_seleccionada;
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		listarCiudades();
	}
	
	private void listarCiudades() {
		
		//if(lstCiudades.getItems() != null )lstCiudades.getItems().clear(); 

		CiudadModel model = new CiudadModel();
		ArrayList<Ciudad> listaCiudades = model.getAll();
		Iterator<Ciudad> iterator = listaCiudades.iterator();
		
		Listitem fila = null;
		
		while(iterator.hasNext()) {
			Ciudad ciudad = iterator.next();
			
			fila = new Listitem();
			
			Listcell cellID = new Listcell();
			cellID.setLabel(ciudad.getIdCiudad().toString());
			cellID.setParent(fila);
			
			Listcell cellNombre = new Listcell();
			cellNombre.setLabel(ciudad.getNombre());
			cellNombre.setParent(fila);
			
			Listcell cellPais = new Listcell();
			cellPais.setLabel(ciudad.getPais());
			cellPais.setParent(fila);
			
			Listcell cellCont = new Listcell();
			cellPais.setLabel(ciudad.getCont());
			cellPais.setParent(fila);
		
			
			fila.setValue(ciudad);
			fila.setParent(lstCiudades);
			
			
		}
		
	}
	
	//Eventos de la vista
	public void onClick$btnGuardar() {
		
		String nombre = txtNombre.getText();
		String pais = txtPais.getText();
		String cont = txtCont.getText();
		
		if(ciudad_seleccionada != null) {
			// UPDATE
		
			// si se ha seleccionado un registro se hara un UPDATE
		    Integer idCiudad = ciudad_seleccionada.getIdCiudad();
						
			Ciudad ciudad_editada = new Ciudad(idCiudad, nombre, pais, cont);
						
			CiudadModel modelo = new CiudadModel();
			modelo.update(ciudad_editada);
						
		   //lIMPIAMOS ALUMNO SELECCIONADO
		    ciudad_seleccionada = null;
			
		}else {
			// INSERT
						
			Ciudad ciudad_nueva = new Ciudad(null, nombre, pais, cont);
			CiudadModel modelo = new CiudadModel();
			modelo.insert(ciudad_nueva);
		}
		
		this.listarCiudades();
		this.limpiarCampos();
		
	}
	
	private void limpiarCampos () {
		txtNombre.setText("");
		txtPais.setText("");
	}
	
	//Click en la tabla
	public void onClick$lstAlumnos() {
		Listitem elemento_seleccionado = lstCiudades.getSelectedItem();
		
		
		 ciudad_seleccionada = elemento_seleccionado.getValue();
				
			
			//Elementos seleccionados
			txtNombre.setText(ciudad_seleccionada.getNombre());
			txtPais.setText(ciudad_seleccionada.getPais());
			
			

		
	}
	
	public void onClick$btnEliminar() {
		
		if(ciudad_seleccionada != null) {
			
			CiudadModel ciudad_eliminar = new CiudadModel();
			ciudad_eliminar.delete(ciudad_seleccionada);
			
			//LIMPIAR LOS CAMPOS 
			
			ciudad_seleccionada = null;
			txtNombre.setText("");
			txtPais.setText("");
			
			
			
			lstCiudades.getItems().clear();
			this.listarCiudades();
			
	
		}
		
	}

	
	
}
