package br.org.fiergs.groupservice.controllers;

import br.org.fiergs.groupservice.entities.Group;
import br.org.fiergs.groupservice.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> list(){
        return groupService.findAll();
    }

    @GetMapping("/description/{description}")
    public List<Group> listByDescription(@PathVariable("description") String description){
        return groupService.findByDescription(description);
    }

    @GetMapping("/code/{code}")
    public Group findByCode(@PathVariable("code") String code) {
        return groupService.findByCode(code);
    }

    @PostMapping
    public Group save(@RequestBody @Valid Group group){
        return groupService.save(group);
    }

    @PutMapping
    public Group update(@RequestBody @Valid Group group){
        return groupService.update(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        groupService.delete(id);
    }
}
