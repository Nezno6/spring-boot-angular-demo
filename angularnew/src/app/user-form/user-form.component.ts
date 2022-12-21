import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../service/movie.service';
import { User } from '../model/movie';

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.css']
})
export class UserFormComponent {

  movie: User;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private userService: UserService) {
    this.movie = new User();
  }

  onSubmit() {
    this.userService.save(this.movie).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}
