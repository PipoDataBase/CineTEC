import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { Movie } from 'src/app/models/movie.module';
import { Projection } from 'src/app/models/projection.module';
import { MoviesService } from 'src/app/services/movies.service';
import { ProjectionsService } from 'src/app/services/projections.service';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-add-projection',
  templateUrl: './add-projection.component.html',
  styleUrls: ['./add-projection.component.css']
})
export class AddProjectionComponent {
  branchDetails: BranchOffice = {
    id: '00000000-0000-0000-0000-000000000000',
    location: '',
    name: '',
    restriction: '',
    n_Rooms: 0
  }
  addProjectionRequest: Projection = {
    id: '00000000-0000-0000-0000-000000000000',
    room_Id: '00000000-0000-0000-0000-000000000000',
    dateTime: '',
    movie_Id: '00000000-0000-0000-0000-000000000000',
    projectionType: '',
    language: ''
  }
  movies: Movie[] = [];
  selectedMovieId: string = '';
  minDate: Date = new Date();
  maxDate: Date = new Date();

  constructor(private roomsService: RoomsService, private moviesService: MoviesService, private movieProjectionsService: ProjectionsService, private router: Router, private route: ActivatedRoute, private datePipe: DatePipe) { }

  ngOnInit() {
    this.minDate.setHours(12, 0, 0, 0);
    this.maxDate.setDate(this.maxDate.getDate() + 7);
    this.maxDate.setHours(23, 30, 0, 0);

    this.moviesService.getAllMovies().subscribe({
      next: (movies) => {
        this.movies = movies;
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  addProjection() {
    this.addProjectionRequest.room_Id = this.movieProjectionsService.selectedRoomId;
    this.addProjectionRequest.movie_Id = this.selectedMovieId;
    var date = this.datePipe.transform(this.addProjectionRequest.dateTime, 'M/d/yyyy h:mm a');
    if (date) {
      this.addProjectionRequest.dateTime = date;
    }
    const isNotDefault = Object.values(this.addProjectionRequest).every(value => value !== '');
    if (isNotDefault) {
      this.movieProjectionsService.addProjection(this.addProjectionRequest).subscribe({
        next: (response) => {
          this.router.navigate(["cinetec/projections"]);
        }
      })
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  back() {
    this.router.navigate(['cinetec/projections']);
  }
}
