package com.scotiabank.repository;

import com.scotiabank.model.BlacklistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<BlacklistEntity, Long> {

    Boolean existsBlacklistEntitiesByDocumentNumber(String documentNumber);
}
