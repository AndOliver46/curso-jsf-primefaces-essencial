package com.andoliver46.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.andoliver46.erp.model.Empresa;
import com.andoliver46.erp.repository.EmpresaRepository;
import com.andoliver46.erp.util.Transacional;



public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresaRepository;

	@Transacional
	public void salvar(Empresa empresa) {
		empresaRepository.save(empresa);
	}

	@Transacional
	public void excluir(Empresa empresa) {
		empresaRepository.delete(empresa);
	}

}