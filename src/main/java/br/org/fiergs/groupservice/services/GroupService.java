package br.org.fiergs.groupservice.services;

import br.org.fiergs.groupservice.entities.Group;
import br.org.fiergs.groupservice.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public List<Group> findByDescription(String description) {
        Optional<List<Group>> optGroup = groupRepository.findByDescriptionContainingIgnoreCase(description);
        return optGroup.orElseGet(ArrayList::new);
    }

    public Group findByCode(String code) {
        Optional<Group> optGroup = groupRepository.findByCode(code);
        return optGroup.orElseGet(null);
    }

    public Group save(Group group) {
        Optional<Group> optGroup = groupRepository.findByCodeOrDescription(group.getCode(), group.getDescription());
        if (optGroup.isEmpty()) {
            return groupRepository.save(group);
        } else {
            throw new RuntimeException("Group já cadastrado!");
        }

    }

    public Group update(Group group) {
        Optional<Group> optGroup = groupRepository.findOneByDescriptionIgnoreCaseOrCodeAndIdNot(group.getDescription(), group.getCode(), group.getId());
        if (optGroup.isEmpty()) {
            return groupRepository.save(group);
        } else {
            throw new RuntimeException("Group já cadastrado!");
        }
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
