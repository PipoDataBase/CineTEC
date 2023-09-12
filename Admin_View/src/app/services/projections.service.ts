import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Projection } from '../models/projection.module';

@Injectable({
  providedIn: 'root'
})
export class ProjectionsService {
  selectedRoomId: string = '';
  roomChecked: boolean = false;
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllProjections(room_id: string): Observable<Projection[]> {
    return this.http.get<Projection[]>(this.baseApiUrl + '/api/projections/' + room_id);
  }

  addProjection(addProjectionRequest: Projection): Observable<Projection> {
    return this.http.post<Projection>(this.baseApiUrl + '/api/projections', addProjectionRequest);
  }

  getProjection(room_Id: string, id: string): Observable<Projection> {
    return this.http.get<Projection>(this.baseApiUrl + '/api/projections/' + room_Id + '/' + id);
  }

  updateProjection(room_Id: string, id: string, updateProjectionRequest: Projection): Observable<Projection> {
    return this.http.put<Projection>(this.baseApiUrl + '/api/projections/' + room_Id + '/' + id, updateProjectionRequest);
  }

  deleteProjection(id: string): Observable<Projection> {
    return this.http.delete<Projection>(this.baseApiUrl + '/api/projections/' + id);
  }
}
