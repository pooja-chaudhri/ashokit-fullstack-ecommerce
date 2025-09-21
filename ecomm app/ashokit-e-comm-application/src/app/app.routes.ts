import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { OrderConfirmationComponent } from './components/order-confirmation/order-confirmation.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ResetComponent } from './components/reset/reset.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { checkoutGuard } from './guards/checkout.guard';





export const routes: Routes = [
    
    {path: 'product/:id', component: ProductListComponent },
    {path: 'products', component: ProductListComponent},
    {path: '', redirectTo: '/products', pathMatch: 'full'},
    {path: 'search/:keyword', component: ProductListComponent},
    {path: 'cart-details', component:CartDetailsComponent},  
    {path: 'checkout', component:CheckoutComponent, canActivate: [checkoutGuard]},
    {path: 'order-confirm', component:OrderConfirmationComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: "resetPwd",component: ResetComponent},
    {path: "forgotpwd", component:ForgotPasswordComponent},
   
   
    


];    
