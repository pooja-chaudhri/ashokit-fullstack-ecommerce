import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';

export const checkoutGuard: CanActivateFn = (route, state) => {
  
  const authService = inject(AuthService);
  const router = inject(Router);
            
    const token = authService.getToken(); // ✅ get token here

  console.log('guard check - token ; ' , token, 'is logged in :', authService.isLoggedIn());

  if (authService.isLoggedIn()){
    return true;
  }
  else{
    localStorage.setItem('redirectUrl',state.url);
    router.navigate(['/login']);
    return false;
  }
};
