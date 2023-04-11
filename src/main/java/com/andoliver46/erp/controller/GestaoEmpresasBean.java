package com.andoliver46.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.andoliver46.erp.model.Empresa;
import com.andoliver46.erp.model.RamoAtividade;
import com.andoliver46.erp.model.TipoEmpresa;
import com.andoliver46.erp.repository.EmpresaRepository;
import com.andoliver46.erp.repository.RamoAtividadeRepository;
import com.andoliver46.erp.service.CadastroEmpresaService;
import com.andoliver46.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EmpresaRepository empresaRepository;

	@Inject
	private RamoAtividadeRepository ramoAtividadeRepository;

	@Inject
	private FacesMessages facesMessages;

	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	private Converter ramoAtividadeConverter;

	private Empresa empresa;

	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}

	public void salvar() {
		cadastroEmpresaService.salvar(empresa);

		facesMessages.info("Empresa salva com sucesso");
		
		todasEmpresas();
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().addAll(Arrays.asList("frm:tabelaEmpresas","frm:messages"));
	}

	public void pesquisar() {
		listaEmpresas = empresaRepository.search(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			facesMessages.info("Sua consulta não retornou registros");
		}
	}

	public void todasEmpresas() {
		listaEmpresas = empresaRepository.findAll();
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividades = ramoAtividadeRepository.search(termo);

		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);

		return listaRamoAtividades;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}

	public Empresa getEmpresa() {
		return empresa;
	}
}
