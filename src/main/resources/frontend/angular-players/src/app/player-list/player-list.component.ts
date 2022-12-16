/**
 * Created by PRahamim on 08-Sep-22
 **/

import { Component, OnInit } from '@angular/core';
import { Player } from '../player'
import { PlayerService } from '../player.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrls: ['./player-list.component.css']
})
export class PlayerListComponent implements OnInit {

  players: Player[];

  constructor(private playerService: PlayerService,
              private router: Router) { }

  ngOnInit(): void {
    this.getPlayers();
  }

  private getPlayers(){
    this.playerService.getPlayersList().subscribe(data => {
      this.players = data;
    });
  }

  playerDetails(id: number){
    this.router.navigate(['player-details', id]);
  }

  updatePlayer(id: number){
    this.router.navigate(['update-player', id]);
  }

  deletePlayer(id: number){
    this.playerService.deletePlayer(id).subscribe( data => {
      console.log(data);
      this.getPlayers();
    })
  }
}
