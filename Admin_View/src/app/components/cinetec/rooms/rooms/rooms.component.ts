import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BranchOffice } from 'src/app/models/branch-office.module';
import { Room } from 'src/app/models/room.module';
import { BranchOfficesService } from 'src/app/services/branch-offices.service';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent {
  branches: BranchOffice[] = [];
  rooms: Room[] = [];
  selectedBranchId: string = '';
  showRooms: boolean = false;

  constructor(private branchOfficesService: BranchOfficesService, private roomsService: RoomsService, private router: Router) { }

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

  ngOnInit(): void {
    this.selectedBranchId = '';

    if (this.roomsService.selectedBranchId) {
      this.selectedBranchId = this.roomsService.selectedBranchId;
      this.updateRooms();
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
  }

  onBranchSelectionChange(selectedBranchId: string) {
    this.updateRooms();
  }

  addRoom(): void {
    this.router.navigate(["cinetec/add-room", this.selectedBranchId]);
  }

  deleteRoom(id: string) {
    this.roomsService.deleteRoom(id).subscribe({
      next: (response) => {
        this.updateRooms();
      },
      error: (error) => {
        console.log(error);
      }
    })
  }
}
