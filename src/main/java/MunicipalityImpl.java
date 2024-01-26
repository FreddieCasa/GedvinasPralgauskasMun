import lt.techin.municipality.IllegalCitizenException;
import lt.techin.municipality.Municipality;
import lt.techin.municipality.Person;
import lt.techin.municipality.PersonPredicate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

public class MunicipalityImpl implements Municipality {

    ArrayList<Person> municipality = new ArrayList<>();

    @Override
    public void registerCitizen(Person person) throws IllegalCitizenException {

        if (person.getFirstName() == null) {
            throw new IllegalCitizenException(person);
        }

        if (person.getLastName() == null) {
            throw new IllegalCitizenException(person);
        }
        if (person.getDateOfBirth() == null) {
            throw new IllegalCitizenException(person);
        }
        if (person.getDateOfBirth().isAfter(LocalDate.now())) {
            throw new IllegalCitizenException(person);
        }
        if (person.getYearlyIncome() < 0) {
            throw new IllegalCitizenException(person);
        }

        if (municipality.contains(person)) {

        } else {
            municipality.add(person);
        }

    }

    @Override
    public int getCitizenCount() {

        return municipality.size();
    }

    @Override
    public double getAverageCitizenIncome() {


        return municipality.stream()
                .mapToDouble(Person::getYearlyIncome)
                .average()
                .getAsDouble();
    }

    @Override
    public boolean isRegisteredCitizen(Person val1) {
        for (Person person : municipality) {
            if (person.equals(val1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Person findOldestPerson() {

        LocalDate oldestDate = municipality.stream()
                .map(Person::getDateOfBirth)
                .min(Comparator.naturalOrder())
                .get();
        for (Person person : municipality) {
            if (person.getDateOfBirth().equals(oldestDate)) {
                return person;
            }
        }

        return null;
    }

    @Override
    public int countAdultCitizens() {
        int count = 0;

        for (Person person : municipality) {

            if (person.getDateOfBirth().isBefore(LocalDate.parse("2006-01-26"))); {
                count++;

            }

        }
        return count;
    }

    @Override
    public double totalIncomeInTaxes() {
        double tax = 0;
        TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();
        for (Person person : municipality) {
            tax = tax + taxCalculator.calculateTax(person);

            return tax;
        }
        return 0;
    }

    @Override
    public Collection<Person> findCitizensBy(PersonPredicate var1) {
        return municipality.stream().filter((Predicate<? super Person>) var1).toList();

    }

    @Override
    public Collection<Person> getOrderedCitizens() {
        return null;
    }

    @Override
    public Map<Integer, List<Person>> groupByYearOfBirth() {
        return null;
    }

}
