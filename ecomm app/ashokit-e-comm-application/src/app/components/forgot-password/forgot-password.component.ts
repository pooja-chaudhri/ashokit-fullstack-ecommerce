import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-forgot-password',
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './forgot-password.component.html',
  styleUrl: './forgot-password.component.css'
})
export class ForgotPasswordComponent {

  email: string = '';
  message: string='';
  errorMessage:string='';

  constructor(private authServices: AuthService,private router: Router){}

  onSubmit(){
    this.authServices.sendForgottLink(this.email).subscribe({
      next:(res)=>{
        this.message="Email sent to update password" ;
        this.errorMessage= "";
      },
      error:(err) =>{
        this.errorMessage = "Record not Found";
        this.message= "";
      }
    })
  }
}
