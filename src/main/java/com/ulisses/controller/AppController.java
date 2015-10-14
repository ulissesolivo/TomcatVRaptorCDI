package com.ulisses.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.environment.Environment;
import org.slf4j.Logger;

@Controller
public class AppController {

  @Inject
  private Logger log;
  @Inject
  private Environment environment;
  @Inject
  private Result result;

  @Path("/")
  public void index() {
    result.include("mensagem", "Tomcat, VRaptor 4 and CDI Project");
    log.info("Configuração: " + environment.getName());
  }

}
