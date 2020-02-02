import * as AuthActions from './auth-actions';
import { HttpError } from "../app-reduces";


export interface User {
    updatedAt: any,
    id: any,
    username: any,
    password: any,
    email: any
    roles: [],
    firstName: any,
    lastName: any,
    city: any,
    state: any,
    zip: any,
    emaiVerified: any,
    phone: any,
    country: any,
    address: any,
    reviews: any,
    ordrDetails: any,
    createdAt: any
}


export interface State {
    authenticated: boolean;
    isActive: boolean;
    errors: HttpError[];
    loading: boolean;
}

const initialState: State = {
    authenticated: false,
    isActive: null,
    errors: [],
    loading: false
};

export function authReducer(state = initialState, action: AuthActions.AuthActions) {
    switch (action.type) {
        case (AuthActions.SIGN_IN):
        case (AuthActions.SIGN_OUT):
            return {
                ...state,
                loading: true
            };

        case (AuthActions.SIGN_IN_SUCCESS):
            let signInErrorClear = state.errors;
            for (let i = 0; i < signInErrorClear.length; i++) {
                if (signInErrorClear[i].errorEffect === AuthActions.SIGN_IN) {
                    signInErrorClear = signInErrorClear.splice(i, 1);
                }
            }
            return {
                ...state,
                authenticated: true,
                errors: signInErrorClear,
                loading: false
            };
        case (AuthActions.AUTH_ERROR):
            let authErrorPush = state.errors;
            for (let i = 0; i < authErrorPush.length; i++) {
                if (authErrorPush[i].errorEffect === action.payload.errorEffect) {
                    authErrorPush[i] = action.payload;
                    return {
                        ...state,
                        errors: authErrorPush,
                        loading: false
                    };
                }
            }
            authErrorPush.push(action.payload);
            return {
                ...state,
                errors: authErrorPush,
                loading: false
            };

        case (AuthActions.SIGN_OUT_SUCCESS):
            return {
                authenticated: false,
                isActive: null,
                errors: [],
                loading: false
            };
        default:
            return state;
    }
}

