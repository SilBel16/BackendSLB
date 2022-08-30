
package com.portfolio.SilBel.Service;

import com.portfolio.SilBel.Entity.Info;
import com.portfolio.SilBel.Repository.RInfo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SInfo {
    @Autowired
    RInfo rInfo;
    
public List<Info> list() {
    return rInfo.findAll(); 
    }

public Optional <Info> getOne(int id){
    return rInfo.findById(id);
}

public Optional<Info> getByNombre (String nombre) {
    return rInfo.findByNombre(nombre);
}

public void save (Info info) {
    rInfo.save(info);
}

public void delete (int id) {
    rInfo.deleteById(id);
}

public boolean existsById (int id) {
    return rInfo.existsById(id);
}

public boolean existsByNombre (String nombre) {
    return rInfo.existsByNombre(nombre);
}

}

