
package com.portfolio.SilBel.Repository;

import com.portfolio.SilBel.Entity.Info;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface RInfo extends JpaRepository<Info, Integer> {
    
    public Optional<Info> findByNombre (String nombre);
    
    public boolean existsByNombre(String nombre);
} 
