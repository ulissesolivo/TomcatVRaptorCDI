/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulisses.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author uliss
 */
@Entity
@Table(name = "pessoa", uniqueConstraints = @UniqueConstraint(name = "codigo_key", columnNames = "codigo"))
public class Pessoa implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "pessoa_id_gen", sequenceName = "pessoa_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_gen")
  private Long id;

  @Column(nullable = false)
  @NotNull(message = "Código não informado, campo de preenchimento obrigatório.")
  private Integer codigo;

  @Column(length = 255, nullable = false)
  @NotNull(message = "Nome não informado, campo de preenchimento obrigatório.")
  private String nome;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Pessoa() {
  }

  public Pessoa(Integer codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 13 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Pessoa other = (Pessoa) obj;
    if (this.id != null && other.getId() != null) {
      return this.id.equals(other.getId());
    } else {
      return (this == other);
    }
  }

}
