package com.andoliver46.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.andoliver46.erp.model.RamoAtividade;

public class RamoAtividadeRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;
	
	public RamoAtividadeRepository() {
	}
	
	public RamoAtividadeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<RamoAtividade> search(String descricao){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), "%" + descricao + "%"));
		
		TypedQuery<RamoAtividade> query = entityManager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
}
