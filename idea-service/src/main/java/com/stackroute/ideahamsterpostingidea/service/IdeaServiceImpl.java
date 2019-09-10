package com.stackroute.ideahamsterpostingidea.service;

import com.stackroute.ideahamsterpostingidea.domain.Idea;
import com.stackroute.ideahamsterpostingidea.exception.IdeaAlreadyExistException;
import com.stackroute.ideahamsterpostingidea.exception.IdeaNotFoundException;
import com.stackroute.ideahamsterpostingidea.repository.IdeaRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


/*
  @Service indicates annotated class is a service which hold business logic in the Service layer
 */
@Service
public class IdeaServiceImpl implements IdeaService {
    private IdeaRepository ideaRepository;
    private RabbitTemplate rabbitTemplate;

    /*
      Constructor based Dependency injection to inject IdeaRepository here
     */
    @Autowired
    public IdeaServiceImpl(IdeaRepository ideaRepository, RabbitTemplate amqpTemplate) {
        this.ideaRepository = ideaRepository;
        this.rabbitTemplate = amqpTemplate;
    }

    /*@Value annotation is found on a method, Spring context will invoke
      it when all the spring configurations and beans are getting loaded. */
    @Value("${idea.rabbitmq.exchange}")
    public String exchange;

    @Value("${idea.rabbitmq.routingkey}")
    public String routingkey;


    /*
      Implementation of saveTrack method
     */
    @Override
    public Idea save(Idea idea) throws IdeaAlreadyExistException {
        if (ideaRepository.findByTitle(idea.getTitle()) != null) {

            throw new IdeaAlreadyExistException("idea already exist");
        }
        Idea savedIdea = ideaRepository.save(idea);
        rabbitTemplate.convertAndSend(exchange, routingkey, idea);
        if (savedIdea == null) {
            throw new IdeaAlreadyExistException("idea is null");
        }
        return savedIdea;
    }
    /*
     * Implementation of getIdea by id method
    */
    @Override
    public Idea getIdeaById(String id) throws IdeaNotFoundException {
        if (!ideaRepository.existsById(id)) {
            throw new IdeaNotFoundException("idea not found");
        }
        Idea retriveIdea = ideaRepository.findById(id).get();
        return retriveIdea;
    }

    /*
     * Implementation of getIdea by title method
     */
    @Override
    public Idea getIdeaByTitle(String title) throws IdeaNotFoundException {
        Idea retriveIdeaByTitle = ideaRepository.findByTitle(title);
        return retriveIdeaByTitle;
    }

    /*
     * Implementation of getIdea by location method
     */

    @Override
    public Idea getIdeaByLocation(String location) throws IdeaNotFoundException {
        Idea retriveIdeaByLocation = ideaRepository.findByLocation(location);
        return retriveIdeaByLocation;
    }

    /*
     * Implementation of getAll ideas method
     */
    @Override
    public List<Idea> getAllIdeas() throws Exception {
        List<Idea> allIdeas = ideaRepository.findAll();
        return allIdeas;
    }

    /*
     * Implementation of update idea method
     */
    @Override
    public Idea updateIdea(Idea idea) throws IdeaNotFoundException {
        /**Throw ideaNotFoundException if idea we want to update is not found*/
        if (ideaRepository.existsById(idea.getTitle())) {
            Idea getidea = ideaRepository.findByTitle(idea.getTitle());
            getidea.setTitle(idea.getTitle());
            return ideaRepository.save(getidea);
        } else {
            throw new IdeaNotFoundException("Idea you want to update is not found");
        }
    }

    /*
     * Implementation of deleteIdea by id method

     * @return
     */
    @Override
    public Idea deleteIdeaById(String id) throws IdeaNotFoundException {
        if (ideaRepository.existsById(id)) {
            Idea retrivedTrack = ideaRepository.findById(id).get();
            ideaRepository.deleteById(id);
            return retrivedTrack;
        } else {
            throw new IdeaNotFoundException("Track not found");
        }
    }

    /*
     * Implementation of delete idea by title method
     */
    @Override
    public Idea deleteIdeaByTitle(String title) throws IdeaNotFoundException {
        Idea deleteIdeaByTitle = ideaRepository.findByTitle(title);
        return deleteIdeaByTitle;
    }


    /**
     * Implementation of get recent ideas method
     */

    @Override
    public List<Idea> getRecentIdeas() {
        List<Idea> getRecentIdea = ideaRepository.findAll(Sort.by(Sort.Direction.DESC, "postedOn"));
        return getRecentIdea;
    }
}
