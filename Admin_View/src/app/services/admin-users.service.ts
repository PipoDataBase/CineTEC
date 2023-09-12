import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { AdminUser } from '../models/admin-user.module';

@Injectable({
  providedIn: 'root'
})
export class AdminUsersService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllAdminUsers(): Observable<AdminUser[]> {
    return this.http.get<AdminUser[]>(this.baseApiUrl + '/api/admin-users');
  }
}
