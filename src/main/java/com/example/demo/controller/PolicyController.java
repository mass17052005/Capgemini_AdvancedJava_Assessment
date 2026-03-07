package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyResponseDTO createPolicy(@Valid @RequestBody PolicyRequestDTO dto) {
        return service.createPolicy(dto);
    }

    @GetMapping
    public Page<PolicyResponseDTO> getAllPolicies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return service.getPoliciesWithPagination(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicyById(@PathVariable Long id) {
        return service.getPolicyById(id);
    }

    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(@PathVariable Long id,
            @Valid @RequestBody PolicyRequestDTO dto) {
        return service.updatePolicy(id, dto);
    }

    @DeleteMapping("/{id}")
    public PolicyResponseDTO cancelPolicy(@PathVariable Long id) {
        return service.cancelPolicy(id);
    }

    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getPoliciesByType(@PathVariable String type) {
        return service.getPoliciesByType(type);
    }

    @GetMapping("/premium")
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(
            @RequestParam double min,
            @RequestParam double max) {
        return service.getPoliciesByPremiumRange(min, max);
    }
}
