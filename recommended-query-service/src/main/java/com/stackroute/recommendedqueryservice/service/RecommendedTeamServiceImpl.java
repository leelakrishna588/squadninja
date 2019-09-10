package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.ServiceProvider;
import com.stackroute.recommendedqueryservice.repository.TeamRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class RecommendedTeamServiceImpl implements RecommendedeamService{
    private TeamRecommendationService teamRecommendationService;
@Autowired
    public RecommendedTeamServiceImpl(TeamRecommendationService teamRecommendationService) {
        this.teamRecommendationService = teamRecommendationService;
    }


    @Override
    public Collection<ServiceProvider> getTeam(String name, String ex, String rname) {
        Collection<ServiceProvider> serviceProviders=teamRecommendationService.getTeam(name,ex,rname);
        return serviceProviders;
    }
}
