import { Component, OnInit } from '@angular/core';
import { User } from '../model/movie';
import { UserService } from '../service/movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] | undefined;

  constructor(private userService: UserService) {

  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }
}
