package fen.fen.model.dto;

import fen.fen.model.SysRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class UserEntity {
    /**
     * user uid
     */
    @Id
    @GeneratedValue
    private Long uid;

    /**
     * user account
     */
    @Column(unique = true)
    private String username;

    /**
     * display name
     */
    private String name;

    /**
     * password
     */
    private String password;
    /**
     * salt for encryption
     */
    private String salt;

    /**
     * account state,0: unproved, 1: active, 2: blocked.
     */
    private byte state;

    /**
     * FetchType.EAGER: load data immediately
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<SysRole> roleList;

    public UserEntity() {
        super();
    }

    /**
     * get encryption salt
     *
     * @return username + salt
     */
    public String getCredentialsSalt() {
        return this.username + this.salt;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", roleList=" + roleList +
                '}';
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
