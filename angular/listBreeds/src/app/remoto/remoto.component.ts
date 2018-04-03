import { Component, OnInit } from '@angular/core';
import { RazasService} from '../razas.service';
import { Breed } from '../breed';
import { Breeds} from '../response';
//import { BREEDS } from '../mock-breeds';

@Component({
  selector: 'app-remoto',
  templateUrl: './remoto.component.html',
  styleUrls: ['./remoto.component.css'],
  providers: [RazasService]
})
export class RemotoComponent implements OnInit {


  selectedBreed: Breed;
  selectedString: string;
  breeds = Breeds;
  breedsImages = Breeds;

  response

  constructor(private _request:RazasService) { }


  ngOnInit() {
    this._request.getBreeds().subscribe(
      result => {
        this.breeds = result;

        if (!this.breeds) {
          console.log('Server error');
        }
      },
      error => {
        var errorMessage = <any>error;
        console.log(errorMessage);
      }

    );
  }


onSelect(breed: string): void {
  this.selectedString = breed;

  this._request.getImagesByBreed(breed).subscribe(
    result => {
      this.breedsImages = result;

      if (!this.breedsImages) {
        console.log('Server error');
      }
      

    },
    error => {
      var errorMessage = <any>error;
      console.log(errorMessage);
    }

  );
}

}
