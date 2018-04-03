import { Component, OnInit, Input } from '@angular/core';
import { Breed } from '../breed';
import { Breeds } from '../response';


@Component({
  selector: 'app-image-detail-breed',
  templateUrl: './image-detail-breed.component.html',
  styleUrls: ['./image-detail-breed.component.css']
})
export class ImageDetailBreedComponent implements OnInit {

  @Input() breed: Breed;

 // @Input() breedImg: Breeds;

  constructor() { }

  ngOnInit() {
  }

}
