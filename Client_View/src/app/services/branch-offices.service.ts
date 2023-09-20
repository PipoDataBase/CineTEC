import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';
import { BranchOffice } from '../models/branch-office.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BranchOfficesService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllBranches(): Observable<BranchOffice[]> {
    return this.http.get<BranchOffice[]>(this.baseApiUrl + '/api/branch-offices');
  }

  getBranch(id: string): Observable<BranchOffice> {
    return this.http.get<BranchOffice>(this.baseApiUrl + '/api/branch-offices/' + id);
  }
}
