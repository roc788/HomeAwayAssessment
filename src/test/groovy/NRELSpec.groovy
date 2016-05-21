import groovyx.net.http.RESTClient
import spock.lang.Specification

class NRELSpec extends Specification {

    static String API_KEY="Qu6bb23zdMHjykmi2I5STTfZBhi730IqL8FZytdP"

    def "Verify that HYATT AUSTIN appears in the nearest station query"(){

        when:
        def client = new RESTClient('https://api.data.gov/')
        client.ignoreSSLIssues()
        def resp = client.get(path : '/nrel/alt-fuel-stations/v1/nearest.json', query: [api_key: API_KEY,location: 'Austin TX',ev_network: 'ChargePoint Network'])

        then:
        assert resp.status == 200
        assert resp.getData().fuel_stations*.station_name.any{ it == 'HYATT AUSTIN'}
    }

    def "Verify the station address"(){

        def resp

        when:
        def client = new RESTClient('https://api.data.gov/')
        client.ignoreSSLIssues()
        resp = client.get(path : '/nrel/alt-fuel-stations/v1/nearest.json', query: [api_key: API_KEY,location: 'Austin TX',ev_network: 'ChargePoint Network'])

        then:
        assert resp.status == 200

        when:
        def nearestStationData = resp.getData()
        Integer index = nearestStationData.fuel_stations.findIndexOf{it.station_name == 'HYATT AUSTIN'}
        String id = nearestStationData.fuel_stations[index].id
        resp = client.get(path : "/nrel/alt-fuel-stations/v1/${id}.json", query: [api_key: API_KEY])

        then:
        assert resp.status == 200
        //No country key in json to validate country
        assert resp.getData().alt_fuel_station.street_address == '208 Barton Springs Rd'
        assert resp.getData().alt_fuel_station.city == 'Austin'
        assert resp.getData().alt_fuel_station.state == 'TX'
        assert resp.getData().alt_fuel_station.zip == '78704'
    }
}
