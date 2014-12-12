package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  
  def index = Action {
	  Ok(views.html.index("Your new applikjkjkcation is ready."))
  }

  def acerca = Action {    
    var variable : String = "Hola Diego"
	  Ok(views.html.acerca(variable))
  }
}