import { Component, OnInit } from '@angular/core';
import { Breed } from '../breed';
import { BREEDS } from '../mock-breeds';

@Component({
  selector: 'app-local',
  templateUrl: './local.component.html',
  styleUrls: ['./local.component.css']
})
export class LocalComponent implements OnInit {

  selectedBreed: Breed;
  breeds = BREEDS;

  constructor() { }

  ngOnInit() {
  }


onSelect(breed: Breed): void {
  this.selectedBreed = breed;
}

}
