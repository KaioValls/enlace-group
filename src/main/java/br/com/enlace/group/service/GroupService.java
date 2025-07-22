package br.com.enlace.group.service;


import br.com.enlace.group.domain.Group;
import br.com.enlace.group.repository.GroupRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GroupService {

    @Inject
    private GroupRepository groupRepository;

    @WithSession
    public Uni<List<Group>> getGroups() {
        return groupRepository.listAll();
    }

    @WithTransaction
    public Uni<Void> createGroup(Group group) {


        return groupRepository.persist(group).replaceWithVoid();
    }
}
