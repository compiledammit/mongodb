/*
From the aggregation-examples docs: http://docs.mongodb.org/manual/tutorial/aggregation-examples/

{
  "_id": "10280",
  "city": "NEW YORK",
  "state": "NY",
  "pop": 5574,
  "loc": [
    -74.016323,
    40.710537
  ]
}
 */
package mongoplay

class ZipCode {

    static constraints = {
    }

    static mapping = {
        collection "zipcodes"
        loc geoIndex:true
    }

    String id
    long pop
    String state
    String city

    //of the form [long, lat]
    List loc
}
