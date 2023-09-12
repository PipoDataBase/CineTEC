import { Component } from '@angular/core';
import { AngularFireStorage } from '@angular/fire/compat/storage';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/models/movie.module';
import { MoviesService } from 'src/app/services/movies.service';

@Component({
  selector: 'app-edit-movie',
  templateUrl: './edit-movie.component.html',
  styleUrls: ['./edit-movie.component.css']
})
export class EditMovieComponent {
  movieDetails: Movie = {
    id: '00000000-0000-0000-0000-000000000000',
    originalName: '',
    director: '',
    commercialName: '',
    classification: '',
    imagePath: '',
    protagonists: '',
    duration: 0,
  }

  constructor(private route: ActivatedRoute, private moviesService: MoviesService, private router: Router, private storage: AngularFireStorage) { }

  ngOnInit() {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');
        if (id) {
          this.moviesService.getMovie(id).subscribe({
            next: (response) => {
              this.movieDetails = response;
            }
          })
        }
      }
    })
  }

  onImageSelected(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    const file = inputElement.files?.[0];
    if (file) {
      const filePath = `images/${new Date().getTime()}_${file.name}`;
      const task = this.storage.upload(filePath, file);
      task.then(uploadTask => {
        uploadTask.ref.getDownloadURL().then(downloadURL => {
          this.movieDetails.imagePath = downloadURL;
        });
      });
    }
  }

  updateMovie() {
    const isNotDefault = Object.values(this.movieDetails).every(value => value !== '' && value !== 0);
    if (isNotDefault) {
      this.moviesService.updateMovie(this.movieDetails.id, this.movieDetails).subscribe({
        next: (response) => {
          this.router.navigate(["cinetec/movies"]);
        }
      });
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  back() {
    this.router.navigate(["cinetec/movies"]);
  }
}
