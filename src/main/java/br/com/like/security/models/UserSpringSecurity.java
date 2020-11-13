package br.com.like.security.models;

import br.com.like.domains.enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserSpringSecurity implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private  Collection<? extends GrantedAuthority> authorities;

    public UserSpringSecurity(final Long id, final String username, final String password, final Set<Profile> profiles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = getProfileList(profiles);
    }

    private List<SimpleGrantedAuthority> getProfileList(final Set<Profile> profiles) {
        return profiles
                .stream()
                .map(profile -> new SimpleGrantedAuthority(profile.getDescription()))
                .collect(Collectors.toList());
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
}
