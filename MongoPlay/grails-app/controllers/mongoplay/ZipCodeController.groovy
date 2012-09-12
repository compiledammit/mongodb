package mongoplay

class ZipCodeController {

    def zipCodeService

    def index() {

        def map = [
            totalRows : ZipCode.count()
            , statesWithPopulation : zipCodeService.statesWithPopulation()
            , avgCityPopulation : zipCodeService.populationByState()
            , minMaxCityPopulation : zipCodeService.minMaxCityPopulationByState()
        ]
        render(view: "/index", model: map)
    }
}
