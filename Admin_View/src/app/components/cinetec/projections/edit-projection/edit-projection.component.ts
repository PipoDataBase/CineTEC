import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/models/movie.module';
import { Projection } from 'src/app/models/projection.module';
import { MoviesService } from 'src/app/services/movies.service';
import { ProjectionsService } from 'src/app/services/projections.service';

@Component({
  selector: 'app-edit-projection',
  templateUrl: './edit-projection.component.html',
  styleUrls: ['./edit-projection.component.css']
})
export class EditProjectionComponent {
  projectionDetails: Projection = {
    id: '00000000-0000-0000-0000-000000000000',
    room_Id: '00000000-0000-0000-0000-000000000000',
    dateTime: '',
    movie_Id: '00000000-0000-0000-0000-000000000000',
    projectionType: '',
    language: ''
  }
  movies: Movie[] = [];
  minDate: Date = new Date();
  maxDate: Date = new Date();

  constructor(private route: ActivatedRoute, private projectionsService: ProjectionsService, private moviesService: MoviesService, private router: Router, private datePipe: DatePipe) { }

  ngOnInit() {
    this.minDate.setHours(12, 0, 0, 0);
    this.maxDate.setDate(this.maxDate.getDate() + 7);
    this.maxDate.setHours(23, 30, 0, 0);

    this.route.paramMap.subscribe({
      next: (params) => {
        const room_Id = params.get('room_Id');
        const id = params.get('id');

        if (room_Id && id) {
          this.projectionsService.getProjection(room_Id, id).subscribe({
            next: (response) => {
              this.projectionDetails = response;
            }
          })
        }
      }
    })

    this.moviesService.getAllMovies().subscribe({
      next: (movies) => {
        this.movies = movies;
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  updateProjection() {
    this.projectionDetails.room_Id = this.projectionsService.selectedRoomId;
    var date = this.datePipe.transform(this.projectionDetails.dateTime, 'M/d/yyyy h:mm a');
    if (date) {
      this.projectionDetails.dateTime = date;
    }
    const isNotDefault = Object.values(this.projectionDetails).every(value => value !== '');
    if (isNotDefault) {
      this.projectionsService.updateProjection(this.projectionDetails.room_Id, this.projectionDetails.id, this.projectionDetails).subscribe({
        next: (response) => {
          this.router.navigate(["cinetec/projections"]);
        }
      });
    }
    else {
      alert("Debe indicar los valores solicitados y de forma correcta");
    }
  }

  back() {
    this.router.navigate(['cinetec/projections']);
  }
}
