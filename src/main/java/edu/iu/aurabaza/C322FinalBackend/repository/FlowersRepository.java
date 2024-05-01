package edu.iu.aurabaza.C322FinalBackend.repository;

import edu.iu.aurabaza.C322FinalBackend.model.Flower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowersRepository
        extends CrudRepository<Flower, Integer> {

}
