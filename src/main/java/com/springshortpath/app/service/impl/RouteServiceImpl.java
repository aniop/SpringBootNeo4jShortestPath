package com.springshortpath.app.service.impl;

import com.springshortpath.app.dto.RouteDTO;
import com.springshortpath.app.model.Route;
import com.springshortpath.app.repository.RouteRepository;
import com.springshortpath.app.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public List<Route> listAllByCityId(Long cityId) {
        return routeRepository.listAllByCityId(cityId);
    }

    @Override
    public Route getById(Long routeId) {
        return routeRepository.getById(routeId);
    }

    @Override
    public Route save(Long cityId, RouteDTO routeDTO) {

        String from = routeDTO.getFrom();
        String destination = routeDTO.getDestination();
        String departureTime = routeDTO.getDepartureTime();
        String arriveTime = routeDTO.getArriveTime();
        Long duration = routeDTO.getDuration();

        return routeRepository.saveRoute(cityId,from,destination,departureTime,
                arriveTime,duration);
    }

    @Override
    public Route update(Long cityId, Long routeId, RouteDTO routeDTO) {

        String from = routeDTO.getFrom();
        String destination = routeDTO.getDestination();
        String departureTime = routeDTO.getDepartureTime();
        String arriveTime = routeDTO.getArriveTime();
        Long duration = routeDTO.getDuration();


        return routeRepository.updateRoute(cityId,routeId,from, destination,departureTime,
                arriveTime,duration);
    }

    @Override
    public void delete(Long cityId, Long routeId) {
        routeRepository.deleteRoute(cityId,routeId);
    }
}