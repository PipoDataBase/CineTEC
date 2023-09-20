import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Movie } from '../models/movie.module';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.baseApiUrl + '/api/movies');
  }

  getMovie(id: string): Observable<Movie> {
    return this.http.get<Movie>(this.baseApiUrl + '/api/movies/' + id);
  }
}
