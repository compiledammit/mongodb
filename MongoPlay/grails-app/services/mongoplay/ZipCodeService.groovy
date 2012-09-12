package mongoplay

/*
* The aggregation queries are from http://docs.mongodb.org/manual/tutorial/aggregation-examples/
*
* */

class ZipCodeService {

    def mongo

    def getDB(){
        return mongo.getDB("MongoPlay")
    }

    def zipcodes(){
        return getDB().zipcodes
    }

    def statesWithPopulation(minPopulation = 1000000) {
        return zipcodes().aggregate(
                [ $group : [_id : '$state', totalPop : [$sum : '$pop']] ],
                [ $match : [ totalPop: [ $gte : 10 * 1000 * 1000 ] ] ],
                [ $sort : ['totalPop' : -1] ]
        ).results()
    }

    def populationByState(){
        return zipcodes().aggregate(
                [ $group :
                        [ _id : [ state : '$state', city : '$city' ], pop : [ $sum : '$pop' ] ]
                ],
                [ $group :
                        [ _id : '$_id.state', avgCityPop : [ $avg : '$pop' ] ]
                ],
                [ $sort: ['avgCityPop' : -1] ]
        ).results()
    }

    def minMaxCityPopulationByState(){
        return zipcodes().aggregate( [ $group:
                [ _id: [ state: '$state', city: '$city' ], pop: [ $sum: '$pop' ] ] ],
                [ $sort: [ pop: 1 ] ],
                [ $group:
                        [ _id : '$_id.state',
                                biggestCity:  [ $last: '$_id.city' ],
                                biggestPop:   [ $last: '$pop' ],
                                smallestCity: [ $first: '$_id.city' ],
                                smallestPop:  [ $first: '$pop' ] ] ],
                [ $sort : ['biggestPop' : -1] ],
                // the following $project is optional, and
                // modifies the output format.

                [ $project:
                        [ _id: 0,
                                state: '$_id',
                                biggestCity:  [ name: '$biggestCity',  pop: '$biggestPop' ],
                                smallestCity: [ name: '$smallestCity', pop: '$smallestPop' ] ] ]
        ).results()
    }
}
