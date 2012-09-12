package mongoplay

import org.bson.types.ObjectId

class MongoPerson {

    static constraints = {
    }

    ObjectId id
    String firstName
    String lastName
    int age
    List<String> friends
    Map pets
}
