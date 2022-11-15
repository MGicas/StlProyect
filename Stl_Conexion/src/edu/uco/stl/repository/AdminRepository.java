package edu.uco.stl.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uco.stl.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, UUID> {

}
