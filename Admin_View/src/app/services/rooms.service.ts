import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Room } from '../models/room.module';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {
  selectedBranchId: string = '';
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllRooms(branch_Id: string): Observable<Room[]> {
    return this.http.get<Room[]>(this.baseApiUrl + '/api/rooms/' + branch_Id);
  }

  addRoom(addRoomRequest: Room): Observable<Room> {
    return this.http.post<Room>(this.baseApiUrl + '/api/rooms', addRoomRequest);
  }

  getRoom(branch_Id: string, id: string): Observable<Room> {
    return this.http.get<Room>(this.baseApiUrl + '/api/rooms/' + branch_Id + '/' + id);
  }

  updateRoom(branch_Id: string, id: string, updateRoomRequest: Room): Observable<Room> {
    return this.http.put<Room>(this.baseApiUrl + '/api/rooms/' + branch_Id + '/' + id, updateRoomRequest);
  }

  deleteRoom(id: string): Observable<Room> {
    return this.http.delete<Room>(this.baseApiUrl + '/api/rooms/' + id);
  }
}
