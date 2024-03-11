package com.user_department.model.authority;

import com.user_department.model.enums.Role;
import com.user_department.model.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITY")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ROLE", nullable = false)
    private Role role;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

}
