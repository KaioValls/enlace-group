package br.com.enlace.group.domain.util;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractAuditable extends PanacheEntityBase {

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_by", updatable = false, length = 100)
    private String createdBy;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @PrePersist
    protected void onPrePersist(){
        this.createdBy = this.createdBy != null ? this.createdBy : getCurrentUser();
        this.updatedBy = getCurrentUser();
    }

    @PreUpdate
    protected void onPreUpdate(){
        this.updatedBy = getCurrentUser();
    }

    protected String getCurrentUser(){
        return "TO IMPLEMENT CURRENT USER";
    }
}
