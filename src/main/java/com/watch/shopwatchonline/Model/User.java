package com.watch.shopwatchonline.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class User {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;


  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  private String avatar;
  @NotNull
  private Short gender;

  @NotBlank 
//   @Size(max = 10)
  private String phone;

  @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<Raiting> raitings;

  @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<wishlist> wishlists;

  @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
private Set<ChatBox> chatBox;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles", 
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User(String username, @Email String email,
        String password,Short gender, String phone) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.gender = gender;
      this.phone = phone;
    }
}
