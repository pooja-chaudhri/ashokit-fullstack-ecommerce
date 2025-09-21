import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { AppConstant } from '../app-constant';

@Injectable({ providedIn: 'root' })
export class AuthService {

  private isLoggedInSubject = new BehaviorSubject<boolean>(!!this.getToken());
  private lastActionSubject = new BehaviorSubject<'signin' | 'signup'> ('signin');

  constructor(private http: HttpClient) {
    this.loadLastAction();
  }

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${AppConstant.login_endpoint}`, { email, password });
  }

  register(data: any): Observable<any> {
    return this.http.post<any>(`${AppConstant.register_endpoint}`, data);
  }

  resetPassword(body: any) {
    return this.http.post(`${AppConstant.reset_endpoint}`, body);
  }

  sendForgottLink(email: string): Observable<any> {
    return this.http.get(`${AppConstant.forgot_endpoint}/${email}`);
  }

  setToken(token: string) {
    if (token) localStorage.setItem('authToken', token);
    this.isLoggedInSubject.next(!!token); // update observable
  }

  getToken(): string | null {
    const token = localStorage.getItem('authToken');
    return token && token !== "" ? token : null;
  }

  setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  getUser(): any | null {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
  }

  loadLastAction(){
    const action = localStorage.getItem('lastAction') as 'signin' | 'signup';
    if (action){
      this.lastActionSubject.next(action);
    }
  }
  isLoggedIn(): boolean {
    const token = this.getToken();
    if (!token) return false;

    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      const exp = payload.exp * 1000;
      return Date.now() < exp;
    } catch (e) {
      return false;
    }
  }

  // Observable for reactive components
  get isLoggedIn$(): Observable<boolean> {
    return this.isLoggedInSubject.asObservable();
  }

  logout() {
    localStorage.removeItem('authToken');
    localStorage.removeItem('user');
      this.isLoggedInSubject.next(false); 

  }

  setLastAction(action: 'signin' | 'signup') {
    this.lastActionSubject.next(action);
    localStorage.setItem('lastAction', action);
  }

  getLastAction(): Observable<'signin' | 'signup'> {
    return this.lastActionSubject.asObservable();
  }
}
