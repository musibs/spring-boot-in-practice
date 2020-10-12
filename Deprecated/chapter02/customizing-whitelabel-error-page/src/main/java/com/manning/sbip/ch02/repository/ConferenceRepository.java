package com.manning.sbip.ch02.repository;

import com.manning.sbip.ch02.model.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
}
