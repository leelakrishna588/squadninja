package com.stackroute.repository;

import com.stackroute.domain.ServiceProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface ServiceProviderRepository extends MongoRepository<ServiceProvider,String> {

    public ServiceProvider findByEmail(String email);


}
