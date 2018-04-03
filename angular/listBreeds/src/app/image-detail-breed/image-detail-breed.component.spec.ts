import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageDetailBreedComponent } from './image-detail-breed.component';

describe('ImageDetailBreedComponent', () => {
  let component: ImageDetailBreedComponent;
  let fixture: ComponentFixture<ImageDetailBreedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageDetailBreedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageDetailBreedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
