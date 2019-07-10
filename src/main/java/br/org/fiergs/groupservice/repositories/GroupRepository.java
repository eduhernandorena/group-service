package br.org.fiergs.groupservice.repositories;

import br.org.fiergs.groupservice.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

        Optional<Group> findByCode(String code);

        Optional<Group> findByCodeOrDescription(String code, String description);

        Optional<List<Group>> findByDescriptionContainingIgnoreCase(String description);

@Query("select o from Group o where (upper(description) = upper(?1) or code = ?2) and id <> ?3")
    Optional<Group> findOneByDescriptionIgnoreCaseOrCodeAndIdNot(String description, String code, Long id);

        }
