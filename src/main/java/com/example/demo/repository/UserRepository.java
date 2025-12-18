
package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<UserRepository, Long> {
    List<UserRepository> findByShipmentId(Long shipmentId);
}
