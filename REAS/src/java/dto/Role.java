
package dto;

public class Role {
    private String roleID;
    private String role;

    public Role() {
    }

    public Role(String roleID, String role) {
        this.roleID = roleID;
        this.role = role;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" + "roleID=" + roleID + ", role=" + role + '}';
    }
}
