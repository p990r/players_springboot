import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AppService {

  constructor(private httpClient: HttpClient) { }

  getRawData(): Observable<any> {
    const api = 'https://www.w3.org/TR/PNG/iso_8859-1.txt';
    return this.httpClient.get(api,{ responseType: 'text' });
  }

}
