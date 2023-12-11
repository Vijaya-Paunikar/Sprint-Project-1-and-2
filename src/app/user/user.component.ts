import { Component, OnInit } from '@angular/core';
import { User } from '../user.model';
import { UserService } from '../user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: User[] = [];
  selectedUser: User = new User();
  isNewUser: boolean = false;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.userService.getAllUsers().subscribe((users) => {
      this.users = users;
    });
  }

  editUser(user: User): void {
    this.selectedUser = { ...user };
    this.isNewUser = true;
    this.openModal();
  }

  createUser(): void {
    this.isNewUser = true;
    this.selectedUser = new User();
    this.openModal();
  }

  saveUser(): void {
    if (this.isNewUser) {
      this.userService.createUser(this.selectedUser).subscribe(() => {
        this.loadUsers();
        this.cancelEdit();
        this.showSuccessAlert('User created successfully!');
      });
    } else {
      this.userService.updateUser(this.selectedUser.userId, this.selectedUser).subscribe(() => {
        this.loadUsers();
        this.cancelEdit();
        this.showSuccessAlert('User updated successfully!');
      });
    }
  }
  
  showSuccessAlert(message: string): void {
    Swal.fire({
      icon: 'success',
      title: 'Success',
      text: message,
    });
  }

  deleteUser(id: number): void {
    this.userService.deleteUser(id).subscribe(() => {
      this.loadUsers();
      this.cancelEdit();
      this.showSuccessAlert('User deleted successfully!');
    });
  }

  cancelEdit(): void {
    this.selectedUser = new User();
    this.isNewUser = false;
    this.closeModal();
  }

  // Additional methods for modal handling
  openModal(): void {
    const modal = document.getElementById('userModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal(): void {
    const modal = document.getElementById('userModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }
}
