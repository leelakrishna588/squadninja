package com.stackroute.squad.services;
import com.stackroute.squad.domain.IdeaHamster;
import com.stackroute.squad.dto.IdeaHamsterDto;
import com.stackroute.squad.repository.IHRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHServiceImpl implements IHService {
  private IHRepository ihRepository;

  @Autowired
  public IHServiceImpl(IHRepository ihRepository) {
    this.ihRepository = ihRepository;
  }

  @Override
  public IdeaHamster save(IdeaHamster ideaHamster) {
    return ihRepository.save(ideaHamster);

  }
  @RabbitListener(queues = "${ihProfile.rabbitmq.queue}")
  public void receive(IdeaHamsterDto ideaHamsterDto){
    IdeaHamster ideaHamster=new IdeaHamster();
    ideaHamster.setEmail(ideaHamsterDto.getEmail());
    ideaHamster.setMobile(ideaHamsterDto.getMobile());
    ideaHamster.setName(ideaHamsterDto.getName());
    ihRepository.save(ideaHamster);
    System.out.println(ideaHamsterDto);
  }

  @Override
  public List<IdeaHamster> getAllIdeaHamster() {
    List<IdeaHamster> allIdeasHamsters = (List<IdeaHamster>) ihRepository.findAll();
    return allIdeasHamsters;

  }

  @Override
  public IdeaHamster deleteIdeaHamster(int id) {
    IdeaHamster retrivedIH = ihRepository.findById(id);
    ihRepository.deleteById(id);
    return retrivedIH;
  }

  @Override
  public IdeaHamster updateIdeaHamster(IdeaHamster ideaHamster) {
    IdeaHamster updateIHById = ihRepository.save(ideaHamster);
    return updateIHById;
  }
}
