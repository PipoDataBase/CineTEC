import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminUser } from 'src/app/models/admin-user.module';
import { AdminUsersService } from 'src/app/services/admin-users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  hide: boolean = true;
  adminUsers: AdminUser[] = [];

  constructor(private router: Router, private adminUsersService: AdminUsersService) { }

  ngOnInit(): void {
    this.adminUsersService.getAllAdminUsers().subscribe({
      next: (adminUsers) => {
        this.adminUsers = adminUsers;
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  login(): void {
    const adminFound = this.adminUsers.find((admin) => admin.username === this.username && admin.password === this.password);
    if (adminFound) {
      this.router.navigate(["cinetec"]);
    } else {
      alert("Invalid credentials");
    }
  }
}
