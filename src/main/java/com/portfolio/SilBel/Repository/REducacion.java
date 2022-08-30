package com.portfolio.SilBel.Repository;

import com.portfolio.SilBel.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
    
    public Optional<Educacion> findByNombreEdu (String nombreEdu);
    
    public boolean existsByNombreEdu (String nombreEdu);
}
