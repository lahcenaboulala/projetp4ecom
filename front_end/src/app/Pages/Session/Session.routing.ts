import { Routes } from '@angular/router';

import { RegisterComponent } from './Register/Register.component';
import { SignInComponent } from './SignIn/SignIn.component';
import { ForgotPasswordComponent } from './ForgotPassword/ForgotPassword.component';

export const SessionRoutes: Routes = [
   {
      path: '',
      component: SignInComponent
   },
   {
      path: 'signin',
      component: SignInComponent
   },
   {
      path: 'signup',
      component: RegisterComponent
   },

   {
      path: 'forgot-password',
      component: ForgotPasswordComponent
   }
]