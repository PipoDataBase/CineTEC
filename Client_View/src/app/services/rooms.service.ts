import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Room } from '../models/room.module';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllRooms(branch_Id: string): Observable<Room[]> {
    return this.http.get<Room[]>(this.baseApiUrl + '/api/rooms/' + branch_Id);
  }

  getRoom(branch_Id: string, id: string): Observable<Room> {
    return this.http.get<Room>(this.baseApiUrl + '/api/rooms/' + branch_Id + '/' + id);
  }
}
