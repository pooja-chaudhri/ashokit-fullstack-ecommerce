import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  name:string = '';
  email: string = '';
  phno : number | null = null;
  errorMessage : string = '';
  successMessage: string = '';

  constructor(private authServices : AuthService, private router: Router){}

    
  register() {
    const body = { name: this.name, email: this.email, phno: this.phno };

    this.authServices.register(body).subscribe({
      next: (res) => {
        this.successMessage = "Registration successful! Check your email.";
        this.errorMessage = '';
        
      },
      error: () => {
        this.errorMessage = 'Registration failed. Try again!';
        this.successMessage = '';
      }
    });
  }

}
