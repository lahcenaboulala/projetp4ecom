import { HttpErrorResponse } from '@angular/common/http';
import { ActionReducerMap } from '@ngrx/store';
import * as fromAuth from '../store/auth/auth-reducer';


export interface HttpError {
    error: HttpErrorResponse,
    errorEffect: string
}

export interface AppState {
    auth: fromAuth.State,
}

export const reducers: ActionReducerMap<AppState> = {
    auth: fromAuth.authReducer,
};