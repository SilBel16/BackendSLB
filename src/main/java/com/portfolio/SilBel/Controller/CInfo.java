
package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Dto.dtoInfo;
import com.portfolio.SilBel.Entity.Info;
import com.portfolio.SilBel.Security.Controller.Mensaje;
import com.portfolio.SilBel.Service.SInfo;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "http://localhost:4200")
public class CInfo {
   @Autowired
    SInfo sInfo;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Info>> list() {
        List<Info> list = sInfo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Info> getById(@PathVariable("id") int id){
        if(!sInfo.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Info info = sInfo.getOne(id).get();
        return new ResponseEntity(info, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoInfo dtoinfo) {
        
        if (StringUtils.isBlank(dtoinfo.getNombre())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sInfo.existsByNombre(dtoinfo.getNombre()))
            return new ResponseEntity(new Mensaje("Ya existe esa información"), HttpStatus.BAD_REQUEST);
        
        //Si pasa las validaciones anteriores, crea el objeto Experiencia
        Info info = new Info(dtoinfo.getNombre(), dtoinfo.getApellido(), dtoinfo.getProfileImg(), dtoinfo.getPosition(), dtoinfo.getAboutMe(), dtoinfo.getCvFile(), dtoinfo.getMail(), dtoinfo.getPhone(), dtoinfo.getCity(), dtoinfo.getCountry());
        sInfo.save(info);
        
        return new ResponseEntity(new Mensaje("Información agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoInfo dtoinfo) {
      // Existe el ID?
        if (!sInfo.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
      
        // Compara nombre de experiencia nueva con antiguas, si existen, da error
        if(sInfo.existsByNombre(dtoinfo.getNombre()) && sInfo.getByNombre(dtoinfo.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa información ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar en blanco nombre experiencia
        if(StringUtils.isBlank(dtoinfo.getNombre()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Info info = sInfo.getOne(id).get();
        info.setNombre(dtoinfo.getNombre());
        info.setApellido(dtoinfo.getApellido());
        info.setProfileImg(dtoinfo.getProfileImg());
        info.setPosition(dtoinfo.getPosition());
        info.setAboutMe((dtoinfo.getAboutMe()));
        info.setCvFile(dtoinfo.getCvFile());
        info.setMail(dtoinfo.getMail());
        info.setPhone(dtoinfo.getPhone());
        info.setCity((dtoinfo.getCity()));
        info.setCountry(dtoinfo.getCountry());
        
        sInfo.save(info);
        return new ResponseEntity(new Mensaje("información actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Existe el ID?
        if (!sInfo.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sInfo.delete(id);
        
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    } 
}

