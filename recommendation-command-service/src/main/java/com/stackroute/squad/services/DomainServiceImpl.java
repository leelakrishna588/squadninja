package com.stackroute.squad.services;

import com.stackroute.squad.domain.Domain;
import com.stackroute.squad.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceImpl implements DomainService {
  DomainRepository domainRepository;
  @Autowired
  public DomainServiceImpl(DomainRepository domainRepository) {
    this.domainRepository = domainRepository;
  }

  @Override
  public Domain save(Domain domain) {
   Domain savedomain=domainRepository.save(domain);
    return savedomain;
  }

  @Override
  public List<Domain> getAllDomains() {
    List<Domain> allDomains = (List<Domain>) domainRepository.findAll();
    return allDomains;

  }

  @Override
  public Domain deleteDomain(int id) {
    Domain retrivedDomain = domainRepository.findById(id);
    domainRepository.deleteById(id);
    return retrivedDomain;

  }

  @Override
  public Domain updateDomain(Domain domain) {
    Domain updateDomain = domainRepository.save(domain);
    return updateDomain;

  }
}
