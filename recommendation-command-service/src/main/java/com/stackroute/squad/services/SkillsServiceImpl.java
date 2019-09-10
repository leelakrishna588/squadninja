package com.stackroute.squad.services;

import com.stackroute.squad.domain.Skills;
import com.stackroute.squad.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsServiceImpl implements SkillService  {
  SkillsRepository skillsRepository;
  @Autowired
  public SkillsServiceImpl(SkillsRepository skillsRepository){
    this.skillsRepository=skillsRepository;
  }
  @Override
  public Skills save(Skills skills) {
    return skillsRepository.save(skills);
  }

  @Override
  public List<Skills> getAllSkills() {
    List<Skills> allSkills = (List<Skills>) skillsRepository.findAll();
    return allSkills;

  }

  @Override
  public Skills deleteSkills(int id) {
    Skills retrivedSkills=skillsRepository.findById(id);
    skillsRepository.deleteById(id);
    return retrivedSkills;

  }

  @Override
  public Skills updateSkills(Skills skills) {
    Skills updateSkills = skillsRepository.save(skills);
    return updateSkills;

  }
}
