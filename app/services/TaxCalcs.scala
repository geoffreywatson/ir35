package services

import javax.inject.{Inject, Singleton}


@Singleton
class TaxCalcs @Inject() (taxRates: TaxRates) {

  def calculateTax (income:BigDecimal, deductions:BigDecimal):BigDecimal = {

    val basicRateBand = taxRates.BRB
    val higherRateBand = taxRates.HRB
    val basicRate = taxRates.basicRate
    val higherRate = taxRates.higherRate
    3.0

  }

  def incomeTax(deemedSalary:BigDecimal):BigDecimal={
    val personalAllowance = taxRates.PA
    val
  }


}
