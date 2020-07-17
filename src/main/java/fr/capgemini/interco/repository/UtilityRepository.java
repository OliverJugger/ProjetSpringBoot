package fr.capgemini.interco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface UtilityRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
}
