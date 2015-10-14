/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulisses.dao;

import com.ulisses.entity.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author uliss
 */
public class PessoaDAO extends BaseDAO<Pessoa> implements Serializable {

  private static final long serialVersionUID = 1L;

  public PessoaDAO() {
  }

  public Pessoa buscar(Integer codigo) {
    CriteriaBuilder cb = getCriteriaBuilder();
    CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
    Root<Pessoa> root = cq.from(Pessoa.class);
    cq.where(cb.equal(root.get("codigo"), codigo)).orderBy(cb.asc(root.get("codigo")));
    return buscarPrimeiro(cq);
  }

  public Pessoa salvarAndSetarCodigo(Pessoa pessoa) {
    if (pessoa.getCodigo() == null) {
      pessoa.setCodigo(proximoCodigo());
    }
    return salvar(pessoa);
  }

  private Integer proximoCodigo() {
    TypedQuery<Integer> query = getEntityManager().createQuery("select p.codigo from Pessoa p order by p.codigo asc", Integer.class);
    List<Integer> codigos = query.getResultList();
    Integer result = 1;
    for (Integer codigo : codigos) {
      if (codigo > result) {
        break;
      }
      result++;
    }
    return result;
  }

}
