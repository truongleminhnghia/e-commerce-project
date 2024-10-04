package org.project.ecommerce.entities;


import jakarta.persistence.*;
import lombok.*;
import org.project.ecommerce.enums.EnumRoleName;

import java.awt.datatransfer.ClipboardOwner;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private EnumRoleName roleName;

    @OneToMany(mappedBy = "role")
    private Set<Account> accounts;
}
