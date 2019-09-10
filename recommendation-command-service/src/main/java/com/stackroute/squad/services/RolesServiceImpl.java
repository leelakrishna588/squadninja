package com.stackroute.squad.services;

import com.stackroute.squad.domain.Roles;
import com.stackroute.squad.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService{
  RolesRepository rolesRepository;
  @Autowired
  public RolesServiceImpl(RolesRepository rolesRepository){
    this.rolesRepository=rolesRepository;
  }
  @Override
  public Roles save(Roles roles) {
    return rolesRepository.save(roles);
  }


  @Override
  public List<Roles> getAllRoles() {
    List<Roles> allRoles = (List<Roles>) rolesRepository.findAll();
    return allRoles;

  }

  @Override
  public Roles deleteRoles(int id) {
    Roles retrivedRoles = rolesRepository.findById(id);
    rolesRepository.deleteById(id);
    return retrivedRoles;
  }

  @Override
  public Roles updateRoles(Roles roles) {
    Roles updateRoles = rolesRepository.save(roles);
    return updateRoles;
  }
}
