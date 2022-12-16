import { Component, OnInit } from '@angular/core';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-player',
  templateUrl: './create-player.component.html',
  styleUrls: ['./create-player.component.css']
})
export class CreatePlayerComponent implements OnInit {
  hasErrors = false;
  errorMsg = "";

  player: Player = new Player();
  constructor(private playerService: PlayerService,
              private router: Router) { }

  ngOnInit(): void {
  }

  savePlayer(){
    this.playerService.createPlayer(this.player).subscribe( data =>{
        console.log(data);
        this.goToPlayerList();
      },
      error => console.log(error));
    this.hasErrors = true;
    this.errorMsg = "NOOOOOOOOO different name!";
  }

  goToPlayerList(){
    this.router.navigate(['/players']);
  }

  onSubmit(){
    console.log(this.player);
    this.savePlayer();
  }
}
