package com.laura.seguros_vehiculares.repository;

import com.laura.seguros_vehiculares.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, String> {
    Optional<Seguro> findByIdSeguro(String idSeguro);
}
