package com.kidwai.FamilyTree.service;

import com.kidwai.FamilyTree.model.FamilyMember;
import com.kidwai.FamilyTree.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {
    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    // Get all family members
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }

    // Add new family member
    public FamilyMember addFamilyMember(FamilyMember member) {
        return familyMemberRepository.save(member);
    }

    // Update family member
    public FamilyMember updateFamilyMember(Long id, FamilyMember memberDetails) {
        Optional<FamilyMember> familyMember = familyMemberRepository.findById(id);
        if (familyMember.isPresent()) {
            FamilyMember existingMember = familyMember.get();
            existingMember.setName(memberDetails.getName());
            existingMember.setSpouse(memberDetails.getSpouse());
            existingMember.setParent(memberDetails.getParent());
            existingMember.setChildren(memberDetails.getChildren());
            return familyMemberRepository.save(existingMember);
        }
        return null;
    }

    // Delete family member
    public boolean deleteFamilyMember(Long id) {
        Optional<FamilyMember> familyMember = familyMemberRepository.findById(id);
        if (familyMember.isPresent()) {
            familyMemberRepository.delete(familyMember.get());
            return true;
        }
        return false;
    }

    // Get family member by ID
    public Optional<FamilyMember> getFamilyMemberById(Long id) {
        return familyMemberRepository.findById(id);
    }

}
