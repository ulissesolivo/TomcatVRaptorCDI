/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulisses.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author uliss
 */
public abstract class BaseDAO<T> {

  //private final Class<T> type;
  private final Class<T> classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

  @Inject
  private EntityManager em;
  
  protected EntityManager getEntityManager() {
    return em;
  }
  
  protected CriteriaBuilder getCriteriaBuilder() {
    return em.getCriteriaBuilder();
  }

  public T buscar(Long id) {
    return em.find(classe, id);
  }

  public T salvar(T entity) {
    return em.merge(entity);
  }

  public T salvarAndFlush(T entity) {
    entity = em.merge(entity);
    em.flush();
    return entity;
  }

  public boolean excluir(T entity) {
    em.remove(entity);
    em.flush();
    return true;
  }

  public T buscarPrimeiro(CriteriaQuery<T> query) {
    List<T> result = buscarItens(query);
    if (result.size() > 0) {
      return result.get(0);
    }
    return null;
  }
  
  public T buscarUltimo(CriteriaQuery<T> query) {
    List<T> result = buscarItens(query);
    if (result.size() > 0) {
      return result.get(result.size() - 1);
    }
    return null;
  }

  public List<Object> buscarItens(String query) {
    return em.createQuery(query).getResultList();
  }
  
  public List<T> buscarItens(CriteriaQuery<T> query) {
    return em.createQuery(query).getResultList();
  }

  public List<T> buscarTodos() {
    return em.createQuery("from " + classe.getSimpleName(), classe).getResultList();
  }

}
