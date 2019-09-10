package com.stackroute.squad.services;

import com.stackroute.squad.domain.Roles;
import com.stackroute.squad.dto.IdeaDto;
import com.stackroute.squad.domain.Idea;
import com.stackroute.squad.dto.RolesDto;
import com.stackroute.squad.dto.ServiceProviderDto;
import com.stackroute.squad.repository.IdeaRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.neo4j.ogm.session.Utils.map;

@Service
public class IdeaServiceImpl implements IdeaService {

  private IdeaRepository ideaRepository;
  private Object Idea;

  @Autowired
  public IdeaServiceImpl(IdeaRepository ideaRepository) {
    this.ideaRepository = ideaRepository;
  }


  @Override
  public Idea save(Idea idea) {
    System.out.println(ideaRepository.save(idea));
    return ideaRepository.save(idea);
  }

  @RabbitListener(queues = "${idea.rabbitmq.queue}")
  public void receive(IdeaDto ideaDTO) {
    Idea idea = new Idea();
    idea.setId(ideaDTO.getId());
    idea.setTitle(ideaDTO.getTitle());
    idea.setDescription(ideaDTO.getDescription());
    idea.setDuration(ideaDTO.getDuration());
    idea.setCost(ideaDTO.getCost());
    idea.setStatus(ideaDTO.getStatus());
    idea.setPostedOn(ideaDTO.getPostedOn());
    ideaRepository.save(idea);
    ideaRepository.setBelongsToRelation(ideaDTO.getTitle(), ideaDTO.getSubDomainName());

    for (int i = 0; i < ideaDTO.getRole().size(); i++) {
      ideaRepository.setRequiresRelation(ideaDTO.getTitle(), ideaDTO.getRole().get(i).getRoleName());
    }

    for (int i = 0; i < ideaDTO.getRole().size(); i++) {
      RolesDto rolesDto = new RolesDto();
      rolesDto = ideaDTO.getRole().get(i);
      for (int j = 0; j < rolesDto.getSkills().size(); j++) {
        ideaRepository.setNeedsRelation(ideaDTO.getTitle(), rolesDto.getSkills().get(j));
      }
    }
    System.out.println(ideaDTO);


  }

  @Override
  public List<Idea> getAllIdea() {
    List<Idea> allIdeas = (List<Idea>) ideaRepository.findAll();
    return allIdeas;
  }


  @Override
  public Idea deleteIdea(int id) {
    Idea retrivedIdea = ideaRepository.findById(id);
    ideaRepository.deleteById(id);
    return retrivedIdea;

  }

  @Override
  public Idea updateIdea(Idea idea) {
    Idea updateIdeaById = ideaRepository.save(idea);
    return updateIdeaById;
  }

/*
  @Override
  public Idea createRelation(String title, String roleName) {
   Idea relation= ideaRepository.createRelation(title,roleName);
    return relation;
  }
*/
}

