package com.government.government.entity;

import com.government.government.Enum.GenericStatusConstant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class StatusEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;

    @Basic
    protected LocalDateTime dateDeactivated;
    @Basic
    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    protected GenericStatusConstant status  = GenericStatusConstant.ACTIVE;
    @ManyToOne
    private Users deactivatedBy;
    @ManyToOne
    private Users lastUpdatedBy;
    @ManyToOne
    private Users createdBy;

    @CreationTimestamp
    @Basic
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Basic
    private LocalDateTime lastUpdatedAt;

}