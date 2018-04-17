package com.iversoft.test.persistence.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserAddresses implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", columnDefinition = "int(11) unsigned DEFAULT NULL")
    private Integer userId;

    @Column(name = "address", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userAddress;

    @Column(name = "province", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userProvice;

    @Column(name = "city", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userCity;

    @Column(name = "country", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userCountry;

    @Column(name = "postal_code", columnDefinition = "varchar(255) DEFAULT NULL")
    private String userPostalCode;

    @Override
    public String toString() {
        return String.format(
                "User[%d, %d, '%s', '%s', '%s', '%s', '%s', '%s']",
                id, userId, userAddress, userProvice, userCity, userCountry, userPostalCode);
    }

}
