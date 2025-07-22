package br.com.enlace.group.repository;

import br.com.enlace.group.domain.Group;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroupRepository implements PanacheRepository<Group> {
}
