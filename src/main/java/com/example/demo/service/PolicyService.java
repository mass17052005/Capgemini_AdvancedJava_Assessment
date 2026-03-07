package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Policy;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.PolicyNotFoundException;
import com.example.demo.mapper.PolicyMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PolicyRepository;

@Service
public class PolicyService {

    private PolicyRepository policyRepository;
    private CustomerRepository customerRepository;

    public PolicyService(PolicyRepository policyRepository,
            CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }

    // ── Pagination + Sorting ──────────────────────────────────────────
    public Page<PolicyResponseDTO> getPoliciesWithPagination(int page, int size,
            String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return policyRepository.findAll(pageable)
                .map(PolicyMapper::toResponseDTO);
    }

    // ── Create ────────────────────────────────────────────────────────
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + dto.getCustomerId()));

        Policy policy = PolicyMapper.toEntity(dto);
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);

        Policy saved = policyRepository.save(policy);
        return PolicyMapper.toResponseDTO(saved);
    }

    // ── Read (all, no pagination) ─────────────────────────────────────
    public List<PolicyResponseDTO> getAllPolicies() {
        return policyRepository.findAll().stream()
                .map(PolicyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // ── Read (by ID) ──────────────────────────────────────────────────
    public PolicyResponseDTO getPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        return PolicyMapper.toResponseDTO(policy);
    }

    // ── Update ────────────────────────────────────────────────────────
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        if (dto.getCustomerId() != null) {
            Customer customer = customerRepository.findById(dto.getCustomerId())
                    .orElseThrow(
                            () -> new CustomerNotFoundException("Customer not found with id: " + dto.getCustomerId()));
            policy.setCustomer(customer);
        }

        Policy updated = policyRepository.save(policy);
        return PolicyMapper.toResponseDTO(updated);
    }

    // ── Cancel (soft-delete) ──────────────────────────────────────────
    public PolicyResponseDTO cancelPolicy(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found with id: " + id));
        policy.setStatus("CANCELLED");
        Policy saved = policyRepository.save(policy);
        return PolicyMapper.toResponseDTO(saved);
    }

    // ── Filter by type ────────────────────────────────────────────────
    public List<PolicyResponseDTO> getPoliciesByType(String policyType) {
        return policyRepository.findByPolicyType(policyType).stream()
                .map(PolicyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // ── Filter by premium range ───────────────────────────────────────
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {
        return policyRepository.findByPremiumAmountBetween(min, max).stream()
                .map(PolicyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}