package com.fsse2406.project.data.user.entity;

import com.fsse2406.project.data.cart.entity.CartItemEntity;
import com.fsse2406.project.data.user.domainObject.FirebaseUserData;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(unique = true, nullable = false)
    private String firebaseUid;

    @Column(unique = true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<CartItemEntity> cartItems;

    public UserEntity() {
    }

    public UserEntity(FirebaseUserData firebaseUserData){
        this.firebaseUid = firebaseUserData.getFirebaseUid();
        this.email = firebaseUserData.getEmail();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer pid) {
        this.uid = pid;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
