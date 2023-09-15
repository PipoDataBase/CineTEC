import { Component } from '@angular/core';

@Component({
  selector: 'app-movie-listing',
  templateUrl: './movie-listing.component.html',
  styleUrls: ['./movie-listing.component.css']
})
export class MovieListingComponent {
  // Estructure: ImagePath-CommercialTitle-OriginalTitle-Duration-Clasification-Director-Protagonists
  moviesData: string[][] = [
    ["../../../../assets/Movies/Op.jpg", "CommercialTitle 1", "OriginalTitle 1", "D 1" ,"C 1", "Director 1", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 2", "OriginalTitle 2", "D 2", "C 2", "Director 2", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 3", "OriginalTitle 3", "D 3",  "C 3", "Director 3", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 1", "OriginalTitle 1", "D 1" ,"C 1", "Director 1", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 2", "OriginalTitle 2", "D 2", "C 2", "Director 2", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 3", "OriginalTitle 3", "D 3",  "C 3", "Director 3", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 1", "OriginalTitle 1", "D 1" ,"C 1", "Director 1", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 2", "OriginalTitle 2", "D 2", "C 2", "Director 2", "Protagonist 1, Protagonist 2, Protagonist 3"],
    ["../../../../assets/Movies/movieExample.png", "CommercialTitle 3", "OriginalTitle 3", "D 3",  "C 3", "Director 3", "Protagonist 1, Protagonist 2, Protagonist 3"]
  ];

  buyTicketsButton(index: number){
    const textoClickeado = this.moviesData[index][1];
    console.log(`Botón clickeado para el texto: ${textoClickeado}`);
  }
}
