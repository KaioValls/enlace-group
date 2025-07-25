package br.com.enlace.group.service;


import br.com.enlace.group.domain.Group;
import br.com.enlace.group.repository.GroupRepository;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GroupService {

    @Inject
    private GroupRepository groupRepository;

    @WithTransaction
    public Uni<List<Group>> getGroups() {
        return groupRepository.listAll();
    }

    @WithTransaction
    public Uni<Void> createGroup(Group group) {
        System.out.println(group.getGroupCode()); // deve imprimir "CEL01"
        return groupRepository.persist(group).replaceWithVoid();
    }

    @WithTransaction
    public Uni<Group> getGroupById(Long groupId) {
        return groupRepository.findById(groupId)
                .onItem().ifNotNull().transformToUni(group -> {
                    // Explicitly fetch the membersIdList
                    if (group.getMembersIdList() != null) {
                        return Uni.createFrom().item(group.getMembersIdList().size())
                                .onItem().transform(size -> group);
                    }
                    return Uni.createFrom().item(group);
                });
    }
}
