import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Tweet } from '../model/tweet';
import { TimelineService } from '../services/timeline.service';
import { Observable } from "rxjs/Observable";
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../model/usuario';


@Component({
  selector: 'app-twittear',
  templateUrl: './twittear.component.html',
  styleUrls: ['./twittear.component.css']
})
export class TwittearComponent implements OnInit {
  tweet: Tweet;
  @Output() tweetCreado= new EventEmitter<Tweet>();
  usuario: Usuario;

  constructor(public timelineService: TimelineService, 
              public usuarioService: UsuarioService) { 
  }

  ngOnInit() {
   this.usuarioService.usuarioLogueado().subscribe((usuario)=> {
      this.usuario = usuario;
      this.tweet = new Tweet(usuario,"",new Date())
      
    })
  }

  public twittear():void{
   this.timelineService.twittear(this.tweet).subscribe();
   this.tweetCreado.emit(this.tweet);
   this.tweet = new Tweet(this.usuario,"",new Date());
  }




}
