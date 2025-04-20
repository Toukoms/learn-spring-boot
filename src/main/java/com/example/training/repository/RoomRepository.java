package com.example.training.repository;

import com.example.training.entity.EmployeeEntity;
import com.example.training.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    interface EmployeRepository extends JpaRepository<EmployeeEntity, UUID> {
    }
}
