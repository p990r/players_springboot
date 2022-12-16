import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlayerListComponent } from './player-list/player-list.component';
import { CreatePlayerComponent } from './create-player/create-player.component';
import { UpdatePlayerComponent } from './update-player/update-player.component';
import { PlayerDetailsComponent } from './player-details/player-details.component';

const routes: Routes = [
  {path: 'players', component: PlayerListComponent},
  {path: 'create-player', component: CreatePlayerComponent},
  {path: '', redirectTo: 'players', pathMatch: 'full'},
  {path: 'update-player/:id', component: UpdatePlayerComponent},
  {path: 'player-details/:id', component: PlayerDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
