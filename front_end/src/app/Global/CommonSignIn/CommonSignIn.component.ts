import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Store } from "@ngrx/store";
import { Observable } from 'rxjs';
import { HttpError } from 'src/app/Store/app-reduces';

import * as fromApp from "../../store/app-reduces";
import * as AuthActions from '../../store/auth/auth-actions';
import { ApiAccountService } from 'src/app/Services/api-account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'embryo-SignIn',
  templateUrl: './CommonSignIn.component.html',
  styleUrls: ['./CommonSignIn.component.scss']
})
export class CommonSignInComponent implements OnInit {

  returnUrl = '/';
  isInvalid: boolean;
  isLogout: boolean;

  signInForm: FormGroup;
  authState: Observable<{ errors: HttpError[], loading: boolean }>;

  constructor(private store: Store<fromApp.AppState>, private test: ApiAccountService, private router: Router) { }

  ngOnInit() {
    this.signInForm = new FormGroup({
      'username': new FormControl(null, Validators.required),
      'password': new FormControl(null, Validators.required),
    });

  }


  onSubmitted() {
    console.log(this.signInForm.value.username + " " + this.signInForm.value.password);

    this.test.login(this.signInForm)


    // this.store.dispatch(new AuthActions.SignIn({
    //   username: this.signInForm.value.username,
    //   password: this.signInForm.value.password
    // }));
  }

}
