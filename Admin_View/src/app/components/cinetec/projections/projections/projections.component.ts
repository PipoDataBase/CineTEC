import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { Movie } from 'src/app/models/movie.module';
import { Projection } from 'src/app/models/projection.module';
import { Room } from 'src/app/models/room.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';
import { MoviesService } from 'src/app/services/movies.service';
import { ProjectionsService } from 'src/app/services/projections.service';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-projections',
  templateUrl: './projections.component.html',
  styleUrls: ['./projections.component.css']
})
export class ProjectionsComponent {
  branches: BranchOffice[] = [];
  rooms: Room[] = [];
  movies: Movie[] = [];
  projections: Projection[] = [];
  selectedBranchId: string = '';
  selectedRoomId: string = '';
  roomChecked: boolean = false;

  constructor(private branchOfficesService: BranchOfficesService, private roomsService: RoomsService, private moviesService: MoviesService, private projectionsService: ProjectionsService, private router: Router) { }

  updateRooms(): void {
    this.roomsService.getAllRooms(this.selectedBranchId).subscribe({
      next: (rooms) => {
        this.rooms = rooms;
      },
      error: (response) => {
        this.rooms = [];
      }
    })
  }

  updateProjections(): void {
    this.projectionsService.getAllProjections(this.selectedRoomId).subscribe({
      next: (projections) => {
        this.projections = projections;
      },
      error: (response) => {
        this.projections = [];
      }
    })
  }

  ngOnInit(): void {
    this.selectedBranchId = '';
    this.selectedRoomId = '';
    this.roomChecked = false;

    this.moviesService.getAllMovies().subscribe({
      next: (movies) => {
        this.movies = movies;
      },
      error: (response) => {
        console.log(response);
      }
    })

    if (this.roomsService.selectedBranchId) {
      this.selectedBranchId = this.roomsService.selectedBranchId;
      this.updateRooms();
    }

    if (this.roomsService.selectedBranchId && this.projectionsService.selectedRoomId && this.projectionsService.roomChecked) {
      this.selectedBranchId = this.roomsService.selectedBranchId;
      this.selectedRoomId = this.projectionsService.selectedRoomId;
      this.roomChecked = this.projectionsService.roomChecked;
      this.updateProjections();
    }

    this.branchOfficesService.getAllBranches().subscribe({
      next: (branches) => {
        this.branches = branches;
      },
      error: (response) => {
        console.log(response);
      }
    })

    this.roomsService.selectedBranchId = '';
    this.projectionsService.selectedRoomId = '';
    this.projectionsService.roomChecked = false;
  }

  putMovie(id: string): any {
    const movie = this.movies.find(movie => movie.id === id);
    return movie?.originalName;
  }

  onBranchSelectionChange(selectedBranchId: string) {
    this.updateRooms();
  }

  onSelectRoom(roomId: string, event: any) {
    this.selectedRoomId = roomId;
    this.roomChecked = event.checked;
    this.updateProjections();
  }

  addProjection(): void {
    this.roomsService.selectedBranchId = this.selectedBranchId;
    this.projectionsService.selectedRoomId = this.selectedRoomId;
    this.projectionsService.roomChecked = this.roomChecked;
    this.router.navigate(["cinetec/add-projection", this.selectedRoomId]);
  }

  editProjection(roomId: string, id: string): void {
    this.roomsService.selectedBranchId = this.selectedBranchId;
    this.projectionsService.selectedRoomId = this.selectedRoomId;
    this.projectionsService.roomChecked = this.roomChecked;
    this.router.navigate(["cinetec/edit-projection", roomId, id]);
  }

  deleteProjection(id: string) {
    this.projectionsService.deleteProjection(id).subscribe({
      next: (response) => {
        this.updateProjections();
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
