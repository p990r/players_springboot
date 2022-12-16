import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../player.service';
import { Player } from '../player';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent implements OnInit {

  id: number;
  player: Player = new Player();
  constructor(private playerService: PlayerService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.playerService.getPlayerById(this.id).subscribe(data => {
      this.player = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.playerService.updatePlayer(this.id, this.player).subscribe( data =>{
        this.goToPlayerList();
      }
      , error => console.log(error));
  }

  goToPlayerList(){
    this.router.navigate(['/players']);
  }
}
