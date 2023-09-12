import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie.module';
import { MoviesService } from 'src/app/services/movies.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent {
  movies: Movie[] = [];

  constructor(private moviesService: MoviesService, private router: Router) { }

  updateMovies(): void {
    this.moviesService.getAllMovies().subscribe({
      next: (movies) => {
        this.movies = movies;
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  ngOnInit(): void {
    this.updateMovies();
  }

  addMovie(): void {
    this.router.navigate(["cinetec/add-movie"]);
  }

  deleteMovie(id: string) {
    this.moviesService.deleteMovie(id).subscribe({
      next: (response) => {
        this.updateMovies();
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
