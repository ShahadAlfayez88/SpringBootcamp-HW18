package com.example.springday07.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int id;
    @NotEmpty(message = "Name field is required")
    @Size(min=5 , message = "please enter a name with more than 4 character")
    private String name;
    @NotEmpty(message = "Username field is required")
    @Size(min=5 , message = "please enter a username with more than 4 character")
//    @Column (columnDefinition = "unique")// لما ابي validation على مستوى DB
    private String username;

    @NotEmpty(message = "Password field is required")
    private String password;

    @NotEmpty(message = "email field is required")
    @Email(message = "please enter a valid email")
//    @Column (columnDefinition = "unique")
    private String email;

    @NotEmpty(message = "role field is required")
//    @Column (columnDefinition = "varchar(5) check (role='user' OR role='admin') ")
    @Pattern( regexp = "^admin|user$" ,message = "Role field only allow input: user or admin" )
    private String role;
    @NotNull(message = "age field is required")
    @Min(value = 1)
//    @Column (columnDefinition = "check (age>0) ")
    private int age ;


}
