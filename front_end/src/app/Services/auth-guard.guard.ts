import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Store } from "@ngrx/store";
import * as fromApp from "../store/app-reduces";
import * as fromAuth from "../store/auth/auth-reducer";
import { map, take } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {

  constructor(private store: Store<fromApp.AppState>, private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    return this.store.select('auth')
      .pipe(take(1), map((authState: fromAuth.State) => {
        if (!authState.authenticated) {
          this.router.navigate(["/signup"]);
        }
        return authState.authenticated;

      }));
  }

}
