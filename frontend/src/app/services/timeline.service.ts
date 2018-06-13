import { Tweet } from "../model/tweet";
import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http';
import { Observable } from "rxjs/Observable";

@Injectable()
export class TimelineService{


    tweets: Array<Tweet>;

    constructor(public httpClient: HttpClient){  
        
    }

    public conseguirTweets(): Observable<Array<Tweet>>{
       return this.httpClient
        .get<Array<Tweet>>('/api/rest/timeline')
    }
                 
    public twittear(tweet: Tweet): Observable<void>{
          return this.httpClient.post<void>('/api/rest/tweets', tweet);
      
    }
    
}