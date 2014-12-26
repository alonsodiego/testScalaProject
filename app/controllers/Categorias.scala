package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick._
import play.api.Play.current

import views._
import models._

/**
 * Manage a database of computers
 */
object Categorias extends Controller { 
  
  /*
   *  Funciones
   */
  def index = Action {
    Ok(views.html.categorias.index())
  }

}
            
