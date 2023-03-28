package com.andoliver46.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.andoliver46.erp.model.Empresa;

public class EmpresaRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;
	
	public EmpresaRepository() {
		
	}
	
	public EmpresaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Empresa findById(Long id) {
		return entityManager.find(Empresa.class, id);
	}
	
	public List<Empresa> search(String nome){
		TypedQuery<Empresa> query = entityManager.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
		query.setParameter("nomeFantasia", "%" + nome + "%");
		return query.getResultList();
	}
	
	public Empresa save(Empresa empresa) {
		return entityManager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = findById(empresa.getId());
		entityManager.remove(empresa);
	}
	
}
