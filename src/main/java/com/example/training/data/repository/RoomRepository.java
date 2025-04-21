package com.example.training.data.repository;

import com.example.training.data.entity.EmployeeEntity;
import com.example.training.data.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
    interface EmployeRepository extends JpaRepository<EmployeeEntity, UUID> {
    }
}
