package br.com.enlace.group.controller;

import br.com.enlace.group.domain.Group;
import br.com.enlace.group.service.GroupService;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/group")
public class GroupController {

    @Inject
    private GroupService groupService;

    @GET
    public Uni<RestResponse<List<Group>>> getGroups(){
        return groupService.getGroups().onItem().transform(RestResponse::ok);
    }

    @POST
    @Transactional
    public Uni<RestResponse<Void>> createGroup(Group group, @Context UriInfo uriInfo){
        return groupService.createGroup(group)
                .replaceWith(RestResponse.created(uriInfo.getAbsolutePath()));
    }
}
