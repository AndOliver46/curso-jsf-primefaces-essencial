package com.andoliver46.erp.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.andoliver46.erp.model.Empresa;
import com.andoliver46.erp.model.TipoEmpresa;

@Named
@ApplicationScoped
public class GestaoEmpresasBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void salvar() {
		System.out.println("Empresa: " + empresa.getRazaoSocial() + 
				empresa.getNomeFantasia() + " " + empresa.getTipo());
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public String ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
	
	
}
