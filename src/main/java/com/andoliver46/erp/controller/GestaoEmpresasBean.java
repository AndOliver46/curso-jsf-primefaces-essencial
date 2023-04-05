package com.andoliver46.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andoliver46.erp.model.Empresa;
import com.andoliver46.erp.repository.EmpresaRepository;

@Named
@ApplicationScoped
public class GestaoEmpresasBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	private List<Empresa> listaEmpresas;
	
	public void todasEmpresas() {
		listaEmpresas = empresaRepository.findAll();
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
}
