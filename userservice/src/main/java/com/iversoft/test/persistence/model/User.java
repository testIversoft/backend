package com.iversoft.test.persistence.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_roles_id", columnDefinition = "int(11) unsigned DEFAULT NULL")
    private Integer userRoleId;

    @Column(name = "username", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userName;

    @Column(name = "NAME", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userEmail;

    @Column(name = "created_at", columnDefinition = "timestamp NULL DEFAULT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date userCreatedDate;

    @Column(name = "updated_at", columnDefinition = "timestamp NULL DEFAULT NULL")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date userUpdatedDate;

    @Override
    public String toString() {
        return String.format(
                "User[%d, %d, '%s', '%s', '%s', '%s']",
                id, userRoleId, userName, userEmail, userCreatedDate, userUpdatedDate);
    }
}