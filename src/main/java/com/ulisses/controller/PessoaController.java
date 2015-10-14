/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulisses.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import com.ulisses.dao.PessoaDAO;
import com.ulisses.entity.Pessoa;
import javax.inject.Inject;

/**
 *
 * @author UlissesO
 */
@Controller
@Path("/pessoa")
public class PessoaController {

  @Inject
  private Result result;
  @Inject
  private PessoaDAO dao;

  @Get({"editar", "editar/{id}"})
  public void editar(Long id) {
    Pessoa pessoa = null;
    if (id != null) {
      pessoa = dao.buscar(id);
    }
    if (pessoa == null) {
      pessoa = new Pessoa();
    }
    result.include("pessoa", pessoa);
  }

  @Post("salvar")
  public void salvar(Pessoa pessoa) {
    dao.salvarAndSetarCodigo(pessoa);
    result.forwardTo(this).listar();
  }

  @Get("excluir/{id}")
  public void excluir(Long id) {
    Pessoa pessoa = dao.buscar(id);
    dao.excluir(pessoa);
    result.forwardTo(this).listar();
  }

  @Get("listar")
  public void listar() {
    result.include("pessoas", dao.buscarTodos());
  }

}
