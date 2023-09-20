import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Projection } from '../models/projection.module';

@Injectable({
  providedIn: 'root'
})
export class ProjectionsService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllProjections(room_id: string): Observable<Projection[]> {
    return this.http.get<Projection[]>(this.baseApiUrl + '/api/projections/' + room_id);
  }

  getProjection(room_Id: string, id: string): Observable<Projection> {
    return this.http.get<Projection>(this.baseApiUrl + '/api/projections/' + room_Id + '/' + id);
  }
}
