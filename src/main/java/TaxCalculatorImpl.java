import lt.techin.municipality.Person;
import lt.techin.municipality.TaxCalculator;
import lt.techin.municipality.TaxRateProvider;

public class TaxCalculatorImpl implements TaxCalculator {

    TaxRateProvider taxRateProvider = new TaxRateProvider();
    @Override
    public double calculateTax(Person person) {

        return person.getYearlyIncome() * (taxRateProvider.getTaxRate(person.getYearlyIncome()))/100.0;

    }
}
