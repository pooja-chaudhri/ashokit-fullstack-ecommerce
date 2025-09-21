import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-login',
    imports: [CommonModule, FormsModule, RouterModule],
    templateUrl: './login.component.html', styleUrl: './login.component.css'
})

export class LoginComponent {
    email: string = '';
    password: string = '';
    errorMessage: string = '';
    successMessage: string = '';

    constructor(private authServices: AuthService, private router: Router) { }

    login() {
        this.errorMessage = '';
        this.successMessage = '';
        this.authServices.login(this.email, this.password).subscribe({
            next: (res) => {
                console.log('Login response:', res);
                this.successMessage = res?.message || 'Login successful';

                const token = res?.data?.jwtToken; console.log('Token from backend:',
                    res?.data?.jwtToken); if (token) { this.authServices.setToken(token); }

                const redirectUrl = localStorage.getItem('redirectUrl');
                if (redirectUrl) {
                    this.router.navigateByUrl(redirectUrl);
                    localStorage.removeItem('redirectUrl');
                }
                else {
                    this.router.navigate(['/products']);
                }
            },

            error: (err) => {
                this.errorMessage = err?.error?.message || 'invalid email or password';
            }
        });
    }

}