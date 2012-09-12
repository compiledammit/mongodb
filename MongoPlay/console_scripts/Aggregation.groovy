

def mongo = ctx.mongo
def db = mongo.getDB("MongoPlay")

db.zipcodes.count()

 def aggrOutput = db.zipcodes.aggregate(
      [ $group : [_id : '$state', totalPop : [$sum : '$pop']] ],
      [ $match : [ totalPop: [ $gte : 10 * 1000 * 1000 ] ] ]
    )
    
   aggrOutput.results()