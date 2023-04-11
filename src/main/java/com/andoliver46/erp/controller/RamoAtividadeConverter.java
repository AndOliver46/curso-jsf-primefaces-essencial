package com.andoliver46.erp.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.andoliver46.erp.model.RamoAtividade;

public class RamoAtividadeConverter implements Converter {

	private List<RamoAtividade> listaRamoAtividades;

	public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividades) {
		this.listaRamoAtividades = listaRamoAtividades;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		
		Long id = Long.valueOf(value);

		for (RamoAtividade ramo : listaRamoAtividades) {
			if (ramo.getId().equals(id)) {
				return ramo;
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}

		RamoAtividade ramoAtividade = (RamoAtividade) value;
		return ramoAtividade.getId().toString();
	}

}
