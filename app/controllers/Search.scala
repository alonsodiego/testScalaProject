package controllers

import play.api._
import play.api.mvc._

object Search extends Controller {

  
  def responseSearch = Action {
	  Ok(views.html.search.responseSearch())
  }

}