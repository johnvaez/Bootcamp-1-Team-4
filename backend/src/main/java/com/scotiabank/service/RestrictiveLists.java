package com.scotiabank.service;

import com.scotiabank.repository.BlacklistRepository;
import com.scotiabank.response.MessageResponse;
import com.scotiabank.service.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class RestrictiveLists {

    private final BlacklistRepository blacklistRepository;

    public RestrictiveLists(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    public ResponseEntity<MessageResponse> validateCostumer(CustomerDTO customerDTO) {

        try {

            Boolean exitsDocumentNumber = blacklistRepository.existsBlacklistEntitiesByDocumentNumber(customerDTO.getDocumentNumber());

            if(exitsDocumentNumber) {
                return ResponseEntity.ok(new MessageResponse().status(false).message("The client is blacklisted"));
            }else {
                return ResponseEntity.ok(new MessageResponse().status(true).message("Client is not blacklisted"));
            }

        }catch (HttpClientErrorException e) {
            return ResponseEntity.ok(new MessageResponse().status(false).message(""+e+""));
        }
    }
}
