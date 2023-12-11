import { Component, OnInit } from '@angular/core';
import { Role } from '../role.model';
import { RoleService } from '../role.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {
  roles: Role[] = [];
  selectedRole: Role = new Role();
  isNewRole: boolean = false;

  constructor(private roleService: RoleService) {}

  ngOnInit(): void {
    this.loadRoles();
  }

  loadRoles(): void {
    this.roleService.getAllRoles().subscribe((roles) => {
      this.roles = roles;
    });
  }

  editRole(role: Role): void {
    this.selectedRole = { ...role };
    this.isNewRole = true;
    this.openModal();
  }

  createRole(): void {
    this.isNewRole = true;
    this.selectedRole = new Role();
    this.openModal();
  }

  saveRole(): void {
    if (this.isNewRole) {
      this.roleService.createRole(this.selectedRole).subscribe(() => {
        this.loadRoles();
        this.cancelEdit();
      });
    } else {
      this.roleService.updateRole(this.selectedRole.roleID, this.selectedRole).subscribe(() => {
        this.loadRoles();
        this.cancelEdit();
      });
    }
  }

  deleteRole(id: number): void {
    this.roleService.deleteRole(id).subscribe(() => {
      this.loadRoles();
      this.cancelEdit();
    });
  }

  cancelEdit(): void {
    this.selectedRole = new Role();
    this.isNewRole = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('roleModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('roleModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}