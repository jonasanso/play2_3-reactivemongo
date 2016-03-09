package controllers

import play.api.libs.json.{JsObject, JsValue, OWrites}
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection._

import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller with MongoController {
  def jsinfocollection: JSONCollection = db.collection[JSONCollection]("mycollection")

  implicit val jsvalueWrites = new OWrites[JsValue] {
    override def writes(o: JsValue): JsObject = o match {
      case o : JsObject => o
      case _ => throw new IllegalArgumentException("Only JsObjects can be stored")
    }
  }

  def createJson = Action.async(parse.json) {
    request =>
      jsinfocollection.insert(request.body).map{
        r => Created(s"JsonInfo is Saved with result $r")
      }
  }
}
