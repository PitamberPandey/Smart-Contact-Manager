package com.src.enitities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String about;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "profile_pic")
    private String profilePic;

    @Column(name = "email_verified", nullable = false)
    private boolean emailVerified = false;

    @Column(name = "phone_verified", nullable = false)
    private boolean phoneVerified = false;

    @Column( name="enabled" ,nullable = false)
    private boolean enabled = true;

    private String provider;
    private String providerUserId;

    @Builder
    public User(String userId, String name, String email, String password, String about, String phoneNumber, 
                String profilePic, boolean emailVerified, boolean phoneVerified, boolean enabled, 
                String provider, String providerUserId) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.phoneNumber = phoneNumber;
        this.profilePic = profilePic;
        this.emailVerified = emailVerified;
        this.phoneVerified = phoneVerified;
        this.enabled = enabled;
        this.provider = provider;
        this.providerUserId = providerUserId;
    }
}
