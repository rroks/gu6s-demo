package fen.fen.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_permission")
public class SysPermission {
    /**
     * permission id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * permission display name
     */
    private String name;

    /**
     * permission，[menu|button]
     */
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;

    /**
     * url path.
     */
    private String url;

    /**
     * permission sign, menu: role:*，button: role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * parent permission
     */
    private Long parentId;
    /**
     * ancestor ids, comma separated
     */
    private String parentIds;

    /**
     * availability status, default false
     */
    private Boolean available = Boolean.FALSE;

    /**
     * role - permission relation
     */
    @ManyToMany
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = {@JoinColumn(name = "permission_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<SysRole> roles;

    public SysPermission() {
        super();
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                ", roles=" + roles +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
