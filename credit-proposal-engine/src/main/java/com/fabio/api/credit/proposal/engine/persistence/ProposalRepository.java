package com.fabio.api.credit.proposal.engine.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabio.api.credit.proposal.engine.entity.ProposalEntity;

@Repository
public interface ProposalRepository extends JpaRepository<ProposalEntity, Long> {

	public List<ProposalEntity> findByCustomerCpf(String cpf);
}
