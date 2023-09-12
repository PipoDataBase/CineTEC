import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie.module';
import { MoviesService } from 'src/app/services/movies.service';
import { AngularFireStorage } from '@angular/fire/compat/storage';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent {
  addMovieRequest: Movie = {
    id: '00000000-0000-0000-0000-000000000000',
    originalName: '',
    director: '',
    commercialName: '',
    classification: '',
    imagePath: '',
    protagonists: '',
    duration: 0,
  }

  constructor(private moviesService: MoviesService, private router: Router, private storage: AngularFireStorage) { }

  onImageSelected(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    const file = inputElement.files?.[0];
    if (file) {
      const filePath = `images/${new Date().getTime()}_${file.name}`;
      const task = this.storage.upload(filePath, file);
      task.then(uploadTask => {
        uploadTask.ref.getDownloadURL().then(downloadURL => {
          this.addMovieRequest.imagePath = downloadURL;
        });
      });
    }
  }

  addMovie() {
    const isNotDefault = Object.values(this.addMovieRequest).every(value => value !== '' && value !== 0);
    if (isNotDefault) {
      this.moviesService.addMovie(this.addMovieRequest).subscribe({
        next: (response) => {
          this.router.navigate(["cinetec/movies"]);
        }
      })
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  back() {
    this.router.navigate(["cinetec/movies"]);
  }
}
