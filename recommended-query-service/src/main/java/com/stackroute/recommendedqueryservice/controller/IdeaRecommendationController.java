package com.stackroute.recommendedqueryservice.controller;

import com.stackroute.recommendedqueryservice.domain.*;
import com.stackroute.recommendedqueryservice.service.RecommendedIdeaService;
import com.stackroute.recommendedqueryservice.service.RecommendedeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class IdeaRecommendationController {
    private RecommendedIdeaService recommendedIdeaService;
    private RecommendedeamService recommendedeamService;
@Autowired
    public IdeaRecommendationController(RecommendedIdeaService recommendedIdeaService, RecommendedeamService recommendedeamService) {
        this.recommendedIdeaService = recommendedIdeaService;
        this.recommendedeamService = recommendedeamService;
    }


    @GetMapping("skill/{name}")
    public ResponseEntity<Collection<Idea>> getIdeasBySkill(@PathVariable("name") String name) {
        System.out.println(name);
        List<Idea> Ideas = recommendedIdeaService.findBySkill(name);
        System.out.println(Ideas);
        return new ResponseEntity<>(Ideas, HttpStatus.OK);
    }

    @GetMapping("role/{name}")
    public ResponseEntity<Iterable<Idea>> getIdeasByRole(@PathVariable("name") String name) {
        System.out.println(name);
        Iterable<Idea> ideas = recommendedIdeaService.findByRole(name);
        System.out.println("controller");
        return new ResponseEntity<>(ideas, HttpStatus.OK);
    }
    @GetMapping("sp/{name}")
    public ResponseEntity<Collection<ServiceProvider>> getTeam(@PathVariable("name") String name,@PathVariable("experience") String ex,@PathVariable("roleName") String rname){
        Collection<ServiceProvider> serviceProviders=recommendedeamService.getTeam(name,ex,rname);
        return new ResponseEntity<>(serviceProviders,HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<Collection<Idea>> getidea() {
        if (recommendedIdeaService.getall() == null) {
            System.out.println("NULL****");
        } else {
            System.out.println("Data found***");
        }
        Collection<Idea> ideaIterator = recommendedIdeaService.getall();
        System.out.println(ideaIterator + "*************************");
        return new ResponseEntity<Collection<Idea>>(ideaIterator, HttpStatus.ACCEPTED);
    }

    @GetMapping("domain")
    public ResponseEntity<Collection<Domain>> getDomain() {
        Collection<Domain> domains = recommendedIdeaService.getalld();
        System.out.println("domain list*******"+ domains);
        return new ResponseEntity<Collection<Domain>>(domains, HttpStatus.ACCEPTED);
    }
    @GetMapping("subdomain")
    public ResponseEntity<Collection<SubDomain>> getDomainq() {
        Collection<SubDomain> subdomains = recommendedIdeaService.getsubDomaind();
        System.out.println("domain list*******"+ subdomains);
        return new ResponseEntity<Collection<SubDomain>>(subdomains, HttpStatus.ACCEPTED);
    }
    @GetMapping("ih")
    public ResponseEntity<Collection<IdeaHamster>> getih() {
        Collection<IdeaHamster> ih = recommendedIdeaService.getih();
        System.out.println("domain list*******"+ ih);
        return new ResponseEntity<Collection<IdeaHamster>>(ih, HttpStatus.ACCEPTED);
    }
    @GetMapping("sub/{domainName}")
    public ResponseEntity<Collection<SubDomain>> getsub(@PathVariable("domainName") String name) {
        Collection<SubDomain> ih = recommendedIdeaService.findByDomain(name);
        System.out.println("domain list*******"+ ih);
        return new ResponseEntity<>(ih, HttpStatus.ACCEPTED);
    }
}


