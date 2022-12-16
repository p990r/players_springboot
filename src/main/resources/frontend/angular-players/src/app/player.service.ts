import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Player } from './player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private baseURL = "http://localhost:8080/api/players";

  constructor(private httpClient: HttpClient) { }

  getPlayersList(): Observable<Player[]>{
    return this.httpClient.get<Player[]>(`${this.baseURL}`);
  }

  createPlayer(player: Player): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, player);
  }

  getPlayerById(id: number): Observable<Player>{
    return this.httpClient.get<Player>(`${this.baseURL}/${id}`);
  }

  updatePlayer(id: number, player: Player): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, player);
  }

  deletePlayer(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
