package com.kidwai.FamilyTree.repository;

import com.kidwai.FamilyTree.model.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface FamilyMemberRepository extends JpaRepository<FamilyMember,Long> {
    List<FamilyMember> findByParentIsNull();

    List<FamilyMember> findAll();

    List<FamilyMember> findByParent_Id(Long parentId);
}
