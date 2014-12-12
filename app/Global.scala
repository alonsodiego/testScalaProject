
import play.api.GlobalSettings
import play.api.Application
import play.api.Play.current
import com.typesafe.config._
import scala.slick.driver.PostgresDriver.simple._
import models._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    
    globals.database.withSession { implicit session =>
      try {
        (Author.ddl ++ Book.ddl).create  

        val author = Author += Author(None, "Martin Odersky")
        Book += Book(None, "Programming in Scala", author)
      } catch {
        case _: Throwable => println("Tables already created")
      }
    }
  }
}

package object globals {
  val dbUrl = ConfigFactory.load().getString("db.default.url")
  val driver = ConfigFactory.load().getString("db.default.driver")
  val user = ConfigFactory.load().getString("db.default.user")
  val password = ConfigFactory.load().getString("db.default.password")
  
  lazy val database = Database.forURL(dbUrl, driver = driver, user = user, password = password)
}
