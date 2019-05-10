package com.fabio.api.credit.proposal.engine.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.api.credit.proposal.engine.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends
		JpaRepository<CustomerEntity, String> {

}
