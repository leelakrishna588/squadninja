package com.stackroute.squad.services;

import com.stackroute.squad.domain.SubDomain;
import com.stackroute.squad.repository.SubDomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubDomainServiceImpl implements SubDomainService {
  SubDomainRepository subDomainRepository;
  public SubDomainServiceImpl(SubDomainRepository subDomainRepository){
    this.subDomainRepository=subDomainRepository;
  }
  @Override
  public SubDomain save(SubDomain subDomain) {
  return subDomainRepository.save(subDomain);
  }

  @Override
  public List<SubDomain> getAllSubDomains() {
    List<SubDomain> allSubDomain = (List<SubDomain>) subDomainRepository.findAll();
    return allSubDomain;
  }

  @Override
  public SubDomain deleteSubDomain(int id) {
    SubDomain retrivedSubDomain=subDomainRepository.findById(id);
    subDomainRepository.deleteById(id);
    return retrivedSubDomain;

  }

  @Override
  public SubDomain updateSubDomain(SubDomain subDomain) {
    SubDomain updateSubDomain =subDomainRepository.save(subDomain);
    return updateSubDomain;
  }
}
