package controllers

import javax.inject._

import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.I18nSupport
import play.api.mvc._
import services.TaxCalcs

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(taxCalcs: TaxCalcs, cc: ControllerComponents) extends AbstractController(cc) with I18nSupport {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */


  val form:Form[(BigDecimal,BigDecimal)] = Form(
    tuple(
      "income" -> bigDecimal,
      "deductions" -> bigDecimal(2,2)
    )
  )

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(form))
  }

  def post() = Action { implicit request =>
    form.bindFromRequest.fold(
      hasErrors => {
        Redirect(routes.HomeController.index())
      },
      data => {
        val grossEarnings = data._1
        val deductions = data._2
        val tax = taxCalcs.calculateTax(grossEarnings,deductions)
        Redirect(routes.HomeController.index())
      }
    )
  }


}
