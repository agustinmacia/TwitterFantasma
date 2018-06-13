import { Component, OnInit } from '@angular/core';
import { Tweet } from '../model/tweet';
import { TimelineService } from '../services/timeline.service';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent {
  
  tweets:Array<Tweet>;
  
  constructor(timelineService: TimelineService) {
    timelineService.conseguirTweets()
    .subscribe((tweets) =>{
      this.tweets = tweets
  })
  }

  public agregarTweet(tweet: Tweet){
    this.tweets = [tweet].concat(this.tweets)
  }

  public favear(tweet: Tweet){
    //faver twit, fijarse en el backend
  }

  


}
