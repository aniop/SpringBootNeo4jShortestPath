package com.springshortpath.app.repository;

import com.springshortpath.app.model.Route;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface RouteRepository extends Neo4jRepository<Route,Long> {

    @Query("MATCH (routes:Route) WHERE routes.id=$cityId RETURN routes")
    List<Route> listAllByCityId(Long cityId);

    @Query("MATCH (route:Route {id: $routeId}) RETURN route")
    Route getById(Long routeId);

    @Query("CREATE (city:City {id: $cityId})-[:ROUTES]->(route:Route {from: $from, destination: $destination, departureTime: $departureTime," +
            "arriveTime: $arriveTime, duration: $duration}) " +
            "RETURN route")
    Route saveRoute(Long cityId,String from,String destination,String departureTime,
                    String arriveTime,Long duration);

    @Query("MATCH (city:City {id: $cityId})-[:ROUTES]->(route:Route {id: $routeId}) " +
            "SET route.from = $from, route.destination = $destination,route.departureTime = $departureTime," +
            "route.arriveTime = $arriveTime, route.duration = $duration RETURN route")
    Route updateRoute(Long cityId, Long routeId, String from, String destination,String departureTime,
                      String arriveTime,Long duration);

    @Query("MATCH (city:City {id: $cityId})-[:ROUTES]->(route:Route {id: $routeId}) DELETE route")
    void deleteRoute(Long cityId, Long routeId);
}