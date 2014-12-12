package models

import scala.slick.driver.PostgresDriver.simple._

case class Author(id:Option[Int], name:String)

class AuthorTable(tag: Tag) extends Table[Author](tag, "Author") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def * = (id.?, name) <> ((Author.apply _).tupled, Author.unapply)
}

object Author extends TableQuery(new AuthorTable(_))

case class Book(id:Option[Int], name:String, authorId:Int)  
class BookTable(tag: Tag) extends Table[Book](tag, "Book") {  
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def authorId = column[Int]("authorId")
    def * = (id.?, name, authorId) <> ((Book.apply _).tupled, Book.unapply)

    def author = foreignKey("author_fk", authorId, Author)(_.id)
}

object Book extends TableQuery(new BookTable(_))
