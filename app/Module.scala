import com.google.inject.AbstractModule
import services.{TaxRates, TaxRates2017_18}

class Module extends AbstractModule {

  override def configure() ={
    bind(classOf[TaxRates]).to(classOf[TaxRates2017_18])
  }


}
