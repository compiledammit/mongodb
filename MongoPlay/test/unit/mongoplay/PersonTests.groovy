package mongoplay



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonTests {

    void testPersonConstructor() {
       def p = new Person(firstName: "Marc", lastName: "Esher", pets: [dog:"Max"], friends: ["Dan","Steve"], age: 38)
       assert p.friends == ["Dan", "Steve"]
       assert p.pets == [dog: "Max"]
    }

    void testMongoPersonConstructor() {
       def p = new MongoPerson(firstName: "Marc", lastName: "Esher", pets: [dog:"Max"], friends: ["Dan","Steve"], age: 38)
       assert p.friends == ["Dan", "Steve"]
       assert p.pets == [dog: "Max"]
    }
}
