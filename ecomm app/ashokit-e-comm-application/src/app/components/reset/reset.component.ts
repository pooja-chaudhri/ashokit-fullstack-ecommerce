import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-reset',
  imports: [CommonModule,FormsModule, RouterModule],
  templateUrl: './reset.component.html',
  styleUrl: './reset.component.css'
})
export class ResetComponent {

  email: string = '';
  oldPwd: string = '';
  newPwd: string = '';
  confirmPwd: string = '';
  message: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  resetPassword() {
    if (this.newPwd !== this.confirmPwd) {
      this.errorMessage = "New Password and Confirm Password do not match!";
      this.message = '';
      return;
    }

    const body = {
      email: this.email,
      oldPwd: this.oldPwd,
      newPwd: this.newPwd,
      confirmPwd: this.confirmPwd
    };

    this.authService.resetPassword(body).subscribe({
      next: (res: any) => {
        this.message = res.data; // e.g. "password updated successfully"
        this.errorMessage = '';
        setTimeout(() => this.router.navigate(['/login']), 2000); // redirect after success
      },
      error: (err) => {
        this.errorMessage = err.error.data || "Password reset failed!";
        this.message = '';
      }
    });
  }
}
