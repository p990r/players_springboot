import { Component, OnInit } from '@angular/core';
import { Player } from '../player';
import { ActivatedRoute } from '@angular/router';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-player-details',
  templateUrl: './player-details.component.html',
  styleUrls: ['./player-details.component.css']
})
export class PlayerDetailsComponent implements OnInit {

  id: number
  player: Player
  constructor(private route: ActivatedRoute, private PlayerService: PlayerService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.player = new Player();
    this.PlayerService.getPlayerById(this.id).subscribe( data => {
      this.player = data;
    });
  }

}
