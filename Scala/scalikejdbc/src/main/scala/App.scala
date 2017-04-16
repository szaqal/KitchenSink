package com.szaqal.scalikejdbc

import java.util.Date

import scalikejdbc._
import scalikejdbc.config._

object DbApplication extends App {

  DBs.setupAll()

  val messages: List[IncomingMessage] = DB readOnly { implicit session ⇒
    sql"select * from IncomingMessage order by id desc limit 1000".map(rs ⇒ IncomingMessage(
      rs.int("id"),
      rs.date("created"),
      rs.string("message")
    )).list.apply()
  }

  messages.foreach(x ⇒ println(x.message))
}

case class IncomingMessage(id: Integer, created: Date, message: String)
