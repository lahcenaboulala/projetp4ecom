import { Injectable } from '@angular/core';
import { Actions, Effect, ofType } from '@ngrx/effects';
import { Router } from '@angular/router';
import { ApiAccountService } from 'src/app/Services/api-account.service';
import { ApiTokenService } from 'src/app/Services/api-token.service';
import * as AuthActions from "./auth-actions";
import { map, switchMap, catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Injectable()
export class AuthEffects {

    constructor(private actions$: Actions, private tokenService: ApiTokenService,
        private router: Router, private accountService: ApiAccountService) {
    }


    @Effect()
    signIn = this.actions$
        .pipe(ofType(AuthActions.SIGN_IN),
            map((action: AuthActions.SignIn) => {
                return action.payload
            }),
            switchMap((credentials: { username: string, password: string }) => {
                return this.tokenService.obtainAccessToken(credentials.username, credentials.password)
                    .pipe(switchMap(res => {
                        this.tokenService.saveToken(res);
                        this.router.navigate(["/checkout/payment"]);
                        return [
                            { type: AuthActions.SIGN_IN_SUCCESS },
                            { type: AuthActions.FETCH_VERIFICATION_STATUS }
                        ]
                    }), catchError(error => {
                        return of(
                            new AuthActions.AuthError(
                                { error: error, errorEffect: AuthActions.SIGN_IN }));
                    }))

            }));

}
