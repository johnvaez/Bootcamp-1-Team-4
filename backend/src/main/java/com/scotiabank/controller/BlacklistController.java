package com.scotiabank.controller;

import com.scotiabank.response.MessageResponse;
import com.scotiabank.service.RestrictiveLists;
import com.scotiabank.service.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BlacklistController {

    private final RestrictiveLists restrictiveLists;

    public BlacklistController(RestrictiveLists restrictiveLists) {
        this.restrictiveLists = restrictiveLists;
    }

    @PostMapping("/blacklist")
    public ResponseEntity<MessageResponse> validateBlacklist(@RequestBody CustomerDTO customerDTO) {
        return restrictiveLists.validateCostumer(customerDTO);
    }
}
