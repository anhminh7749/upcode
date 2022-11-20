package com.watch.shopwatchonline.Domain;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.watch.shopwatchonline.Model.User;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails{
    private static final long serialVersionUID = 1L;

    private int id;
  
    private String username;
  
    private String email;
  
    @JsonIgnore
    private String password;

    private Short gender;

  private String phone;
  
  
    private Collection<? extends GrantedAuthority> authorities;
    
    public static UserDto build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
            .collect(Collectors.toList());
    
        return new UserDto(
            user.getId(), 
            user.getUsername(), 
            user.getEmail(),
            user.getPassword(), 
            user.getGender(),
            user.getPhone(),
            authorities);
      }

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
      }
      @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
      UserDto user = (UserDto) o;
    return Objects.equals(id, user.id);
  }

}
