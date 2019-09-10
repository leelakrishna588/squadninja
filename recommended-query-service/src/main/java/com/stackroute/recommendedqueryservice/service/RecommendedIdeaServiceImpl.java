package com.stackroute.recommendedqueryservice.service;

import com.stackroute.recommendedqueryservice.domain.Domain;
import com.stackroute.recommendedqueryservice.domain.Idea;
import com.stackroute.recommendedqueryservice.domain.IdeaHamster;
import com.stackroute.recommendedqueryservice.domain.SubDomain;
import com.stackroute.recommendedqueryservice.repository.IdeaRecommendationRepository;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RecommendedIdeaServiceImpl implements RecommendedIdeaService {
    private IdeaRecommendationRepository ideaRecommendationRepository;

    @Autowired
    public RecommendedIdeaServiceImpl(IdeaRecommendationRepository ideaRecommendationRepository) {
        this.ideaRecommendationRepository = ideaRecommendationRepository;
    }


//    @Override
//    public List<Idea> findBySkill(String skillName)
//    {
//      List<Idea> Ideas = ideaRecommendationRepository.findBySkill(skillName);
//        System.out.println(skillName);
//        System.out.println(Ideas);
//        return Ideas;
//    }

    @Override
    public List<Idea> findBySkill(String name) {
        List<Idea> ideas = ideaRecommendationRepository.findByRole(name);
        System.out.println(name);
        System.out.println(ideas);
        return ideas;
    }

    @Override
    public List<Idea> findByRole(String ideaName) {
        return ideaRecommendationRepository.findByRole(ideaName);
    }

    @Override
    public List<Idea> findByWorkedOnIdea(String ideaName) {
        return ideaRecommendationRepository.findByWorkedOnIdea(ideaName);
    }

    @Override
    public List<Idea> findByAppliedOnIdea(String ideaName) {
        return ideaRecommendationRepository.findByAppliedOnIdea(ideaName);
    }

    @Override
    public Collection<Idea> getall() {
        System.out.println("*********** in service" + ideaRecommendationRepository.getall());
        return ideaRecommendationRepository.getall();
    }

    @Override
    public Collection<Domain> getalld() {
        Collection<Domain> domainList = ideaRecommendationRepository.getDomaind();
        System.out.println("+-+-+-+-+-+-" + domainList);
        return domainList;
    }

    @Override
    public Collection<SubDomain> getsubDomaind() {
        Collection<SubDomain> sub=ideaRecommendationRepository.getsubDomaind();
        return sub;
    }

    @Override
    public Collection<IdeaHamster> getih() {
        Collection<IdeaHamster> ideaHamsters=ideaRecommendationRepository.getih();
        return ideaHamsters;
    }

    @Override
    public Collection<SubDomain> findByDomain(String name) {
        Collection<SubDomain> subDomains=ideaRecommendationRepository.findByDomain(name);
        return  subDomains;
    }

//    @Override
//    public String saveSkill(String name) {
//        return ideaRecommendationRepository.saveSkill(name);
//    }


}
