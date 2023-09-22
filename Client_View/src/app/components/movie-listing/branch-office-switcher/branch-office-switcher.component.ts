import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, forkJoin, of } from 'rxjs';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { MovieProjection } from 'src/app/models/movie-projection.module';
import { Movie } from 'src/app/models/movie.module';
import { Projection } from 'src/app/models/projection.module';
import { Room } from 'src/app/models/room.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';
import { MoviesService } from 'src/app/services/movies.service';
import { ProjectionsService } from 'src/app/services/projections.service';
import { RoomsService } from 'src/app/services/rooms.service';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-branch-office-switcher',
  templateUrl: './branch-office-switcher.component.html',
  styleUrls: ['./branch-office-switcher.component.css']
})
export class BranchOfficeSwitcherComponent {
  branches: BranchOffice[] = [];
  rooms: Room[] = [];
  projectionDictionary: { [roomId: string]: Projection[] } = {};
  locations: string[] = [];
  names: string[] = [];
  currentLocation: string = '';
  currentName: string = '';
  selectedBranchId: string = '';
  reload: boolean = false;

  branchDetails: BranchOffice = {
    id: '00000000-0000-0000-0000-000000000000',
    location: '',
    name: '',
    restriction: '',
    n_Rooms: 0
  }
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

  moviesData: MovieProjection[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private branchOfficesService: BranchOfficesService, private roomsService: RoomsService, private projectionsService: ProjectionsService, private moviesService: MoviesService, private sharedService: SharedService) { }

  ngOnInit() {
    this.route.paramMap.subscribe({
      next: (params) => {
        const id = params.get('id');
        if (id) {
          this.selectedBranchId = id;
          this.sharedService.sharedSelectedBranchId = id;
          this.update();
        }
      }
    })

    this.branchOfficesService.getAllBranches().subscribe({
      next: (branches) => {
        this.branches = branches;
        this.locations = [...new Set(branches.map(branch => branch.location))];
      },
      error: (response) => {
        console.log(response);
      }
    })
  }

  goToMovieListing() {
    this.router.navigate(["branchOfficeSwitcher", this.sharedService.sharedSelectedBranchId]);
    this.selectedBranchId = this.sharedService.sharedSelectedBranchId;
    this.update();
  }

  onLocationSelectionChange(location: string) {
    this.currentLocation = location;

    // Filter names based on selected location
    this.names = this.branches
      .filter(branch => branch.location === this.currentLocation)
      .map(branch => branch.name);
  }

  onNameSelectionChange(name: string) {
    this.currentName = name;

    // Find branch based on selected location and name
    const selectedBranch = this.branches.find(branch =>
      branch.location === this.currentLocation && branch.name === this.currentName
    );

    if (selectedBranch) {
      this.selectedBranchId = selectedBranch.id;
      this.router.navigate(["branchOfficeSwitcher", this.selectedBranchId]);
    }
  }

  update(): void {
    this.moviesData = [];
    this.projectionDictionary = {};
    this.branchOfficesService.getBranch(this.selectedBranchId).subscribe({
      next: (response) => {
        this.branchDetails = response;

        this.roomsService.getAllRooms(this.branchDetails.id).subscribe({
          next: (rooms) => {
            this.rooms = rooms;

            const projectionObservables = this.rooms.map(room =>
              this.projectionsService.getAllProjections(room.id)
                .pipe(
                  catchError(error => of([]))
                )
            );

            forkJoin(projectionObservables).subscribe(projectionArrays => {
              projectionArrays.forEach((projections, index) => {
                const room = this.rooms[index];
                this.projectionDictionary[room.id] = projections;
              });

              // Luego de cargar las proyecciones, aquí es donde empezamos a llenar moviesData
              this.fillMoviesData();
            });
          },
          error: (response) => {
            this.rooms = [];
          }
        });
      }
    });
  }

  fillMoviesData() {
    for (let key of Object.keys(this.projectionDictionary)) {
      const projections = this.projectionDictionary[key];
      for (const projection of projections) {
        this.moviesService.getMovie(projection.movie_Id).subscribe({
          next: (response) => {
            const movie = response;

            const movieProjection: MovieProjection = {
              ImagePath: movie.imagePath,
              CommercialTitle: movie.commercialName,
              OriginalTitle: movie.originalName,
              Duration: movie.duration,
              Clasification: movie.classification,
              Director: movie.director,
              Protagonists: movie.protagonists,
              ProjectionType: projection.projectionType,
              Language: projection.language,
              DateTime: projection.dateTime,
              RoomId: projection.room_Id
            };

            this.moviesData.push(movieProjection);
          }
        });
      }
    }
  }

  buyTicketsButton(index: number) {
    this.sharedService.sharedMoviesData = this.moviesData[index];
    const id = this.selectedBranchId;
    this.sharedService.sharedSelectedBranchId = id;
    this.selectedBranchId = '';
    this.router.navigate(["branchOfficeSwitcher", id, "billingTicketInformation"]);
  }
}
