import lt.techin.municipality.Person;
import lt.techin.municipality.PersonPredicate;

public class PersonPredicateImpl implements PersonPredicate {
    @Override
    public boolean test(Person person) {
        return false;
    }
}
