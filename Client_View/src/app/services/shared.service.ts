import { Injectable } from '@angular/core';
import { MovieProjection } from '../models/movie-projection.module';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  //moviesData: MovieProjection[] = [];

  constructor() { }

  private selectedBranchIdSubject = new BehaviorSubject<string>('');
  selectedBranchId$ = this.selectedBranchIdSubject.asObservable();

  setSelectedBranchId(branchId: string) {
    this.selectedBranchIdSubject.next(branchId);
  }

}
