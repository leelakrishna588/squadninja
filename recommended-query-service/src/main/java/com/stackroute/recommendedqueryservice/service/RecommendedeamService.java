package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.ServiceProvider;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface RecommendedeamService {
    Collection<ServiceProvider> getTeam(String name,String ex,String rname);
}
