package mongoplay

import static org.junit.Assert.*
import org.junit.*

class MongoPersonTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSomething() {
        def p = new MongoPerson(firstName: "Marc", lastName: "Esher", pets: [dog:"Max"], friends: ["Dan","Steve"], age: 38)
        assert p.friends == ["Dan", "Steve"]
        p.save(flush: true)
        println p.dump()
        def people = MongoPerson.list()
        println people
    }
    @Test
    void testPersonSave() {
        def p = new Person(firstName: "Marc", lastName: "Esher", pets: [dog:"Max"], friends: ["Dan","Steve"], age: 38)
        assert p.friends == ["Dan", "Steve"]
        p.save(flush: true)
        println p.dump()
        def people = Person.list()
        println people
    }
}
