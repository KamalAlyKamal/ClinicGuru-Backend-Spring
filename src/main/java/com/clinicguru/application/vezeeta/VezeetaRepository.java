package com.clinicguru.application.vezeeta;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vezeeta", path = "vezeeta")
public interface VezeetaRepository extends PagingAndSortingRepository<Vezeeta, Long> {
}
