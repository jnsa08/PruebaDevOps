import { Injectable } from '@angular/core';
import { Response, Headers, Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RazasService {

    private url: string;

    constructor(private _http: Http) {

    }


    getBreeds() {
        this.url = 'https://dog.ceo/api/breeds/list';
        let response = this._http.get(this.url);
        let responseAsObjet = response.map(res => res.json());
        return responseAsObjet;
    }

    getImagesByBreed(breed: string) {
        this.url = 'https://dog.ceo/api/breed/'+ breed+'/images';
        let response = this._http.get(this.url);
        let responseAsObjet = response.map(res => res.json());
        return responseAsObjet;
    }

}



