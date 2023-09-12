import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BranchOffice } from '../models/branch-office.module';

@Injectable({
  providedIn: 'root'
})
export class BranchOfficesService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllBranches(): Observable<BranchOffice[]> {
    return this.http.get<BranchOffice[]>(this.baseApiUrl + '/api/branch-offices');
  }

  addBranch(addBranchRequest: BranchOffice): Observable<BranchOffice> {
    return this.http.post<BranchOffice>(this.baseApiUrl + '/api/branch-offices', addBranchRequest);
  }

  getBranch(id: string): Observable<BranchOffice> {
    return this.http.get<BranchOffice>(this.baseApiUrl + '/api/branch-offices/' + id);
  }

  updateBranch(id: string, updateBranchRequest: BranchOffice): Observable<BranchOffice> {
    return this.http.put<BranchOffice>(this.baseApiUrl + '/api/branch-offices/' + id, updateBranchRequest);
  }

  deleteBranch(id: string): Observable<BranchOffice> {
    return this.http.delete<BranchOffice>(this.baseApiUrl + '/api/branch-offices/' + id);
  }
}
