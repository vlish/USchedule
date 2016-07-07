package com.softserveinc.uschedule.security;


import com.softserveinc.uschedule.entity.ApplicationRole;
import com.softserveinc.uschedule.entity.UserToGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Boolean locked;
    private ApplicationRole applicationRole;
    private Set<UserToGroup> userToGroups;
    private Set<GrantedAuthority> authorities;

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Set<UserToGroup> getUserToGroups() {
        return userToGroups;
    }

    public void setUserToGroups(Set<UserToGroup> userToGroups) {
        this.userToGroups = userToGroups;
    }

    public ApplicationRole getApplicationRole() {
        return applicationRole;
    }

    public void setApplicationRole(ApplicationRole applicationRole) {
        this.applicationRole = applicationRole;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
        return !locked;
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
