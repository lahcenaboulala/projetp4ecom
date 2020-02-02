import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../store/auth/auth-reducer';
import { CookieService } from 'ngx-cookie-service';
import { JwtResponse } from '../Models/jwt-response';
import { Observable, Subject, BehaviorSubject, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { subscribeToObservable } from 'rxjs/internal-compatibility';
import { ApiTokenService } from './api-token.service';

@Injectable({
  providedIn: 'root'
})
export class ApiAccountService {

  private currentUserSubject: BehaviorSubject<JwtResponse>;
  public currentUser: Observable<JwtResponse>;
  public nameTerms = new Subject<string>();
  public name$ = this.nameTerms.asObservable();

  url: string = 'http://localhost:8080/api/authenticate';
  securedUrl: string = 'http://localhost:8080/api/secured/account';


  constructor(private http: HttpClient, private cookieService: CookieService, private apiCookie: ApiTokenService) {

    const memo = localStorage.getItem('currentUser');
    this.currentUserSubject = new BehaviorSubject<JwtResponse>(JSON.parse(memo));
    this.currentUser = this.currentUserSubject.asObservable();
    cookieService.set('currentUser', memo);
  }

  login(loginForm: any): Observable<JwtResponse> {
    const url = 'http://localhost:8080/api/authenticate';

    return this.http.post<JwtResponse>(url, loginForm).pipe(
      tap(user => {
        if (user && user.jwttoken) {
          this.cookieService.set('currentUser', JSON.stringify(user));
          if (loginForm.remembered) {
            this.apiCookie.saveToken(user.jwttoken);
          }
          console.log((user.jwttoken));
          this.nameTerms.next(user.jwttoken);
          this.currentUserSubject.next(user);
          return user;
        }
      }),
      catchError(this.handleError('Login Failed', null))
    );
  }



  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      console.log(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
