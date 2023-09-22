import { Injectable } from '@angular/core';
import { MovieProjection } from '../models/movie-projection.module';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  sharedSelectedBranchId: string = '';
  sharedMoviesData: MovieProjection = {
    ImagePath: '',
    CommercialTitle: '',
    OriginalTitle: '',
    Duration: 0,
    Clasification: '',
    Director: '',
    Protagonists: '',
    ProjectionType: '',
    Language: '',
    DateTime: '',
    RoomId: '',
  };

  constructor() { }
}
