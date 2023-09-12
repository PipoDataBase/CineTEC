import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Movie } from '../models/movie.module';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  baseApiUrl: string = environment.baseApiUrl;

  constructor(private http: HttpClient) { }

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.baseApiUrl + '/api/movies');
  }

  addMovie(addMovieRequest: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.baseApiUrl + '/api/movies', addMovieRequest);
  }

  getMovie(id: string): Observable<Movie> {
    return this.http.get<Movie>(this.baseApiUrl + '/api/movies/' + id);
  }

  updateMovie(id: string, updateBranchRequest: Movie): Observable<Movie> {
    return this.http.put<Movie>(this.baseApiUrl + '/api/movies/' + id, updateBranchRequest);
  }

  deleteMovie(id: string): Observable<Movie> {
    return this.http.delete<Movie>(this.baseApiUrl + '/api/movies/' + id);
  }
}
