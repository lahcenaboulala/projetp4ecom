import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiTokenService {

  url: string = 'http://localhost:8080/api/authenticate';

  constructor(private httpClient: HttpClient) {
  }

  obtainAccessToken(username: string, password: string) {
    let body: HttpParams = new HttpParams();
    body = body.append('username', username);
    body = body.append('password', password);
    body = body.append('scope', 'read write');
    body = body.append('grant_type', 'password');
    body = body.append('client_id', 'client_id');


    return this.httpClient.post(this.url, body, {
      headers: {
        'Content-type': 'application/json'
      }
    });


  }

  saveToken(token): void {
    localStorage.setItem('usr', JSON.stringify(token));
  }


  removeToken() {
    localStorage.removeItem('usr');
  }

  getToken() {
    const storageToken = localStorage.getItem('usr');
    let token = '';
    if (storageToken != null || storageToken != undefined) {
      token = JSON.parse(storageToken).access_token;
    }
    return token;
  }

  getRefreshToken() {
    const storageRefreshToken = localStorage.getItem('usr');
    let refreshToken = '';
    if (storageRefreshToken != null || storageRefreshToken != undefined) {
      refreshToken = JSON.parse(storageRefreshToken).refresh_token;
    }
    return refreshToken;
  }

  checkIfTokenExists() {
    return localStorage.getItem('usr') != null || localStorage.getItem('usr') != undefined;
  }
}
