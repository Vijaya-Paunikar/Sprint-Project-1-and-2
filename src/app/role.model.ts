export class Role {
    roleID: number;
    roleName: string;
    description: string;
  
    constructor(roleID?: number, roleName?: string, description?: string) {
      this.roleID = roleID || 0;
      this.roleName = roleName || '';
      this.description = description || '';
    }
}