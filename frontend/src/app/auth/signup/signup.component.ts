import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from '../shared/auth.service';
import { SignupRequestPayload } from './signup-request.payload';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupRequestPayload!: SignupRequestPayload
  signUpForm!: FormGroup;

  //Constructor
  constructor(private authService: AuthService, private toastr: ToastrService, private router: Router){
    this.signupRequestPayload={
      username:'',
      email:'',
      password:''
    }
  }

  ngOnInit(): void {
    this.signUpForm = new FormGroup({
      username: new FormControl('', Validators.required),
      email: new FormControl('',[Validators.required, Validators.email]),
      password: new FormControl('',Validators.required) 
    })
  }

  signup(){
    this.signupRequestPayload.email = this.signUpForm.get('email')?.value;
    this.signupRequestPayload.username = this.signUpForm.get('username')?.value;
    this.signupRequestPayload.password = this.signUpForm.get('password')?.value;
    this.authService.signup(this.signupRequestPayload)
      .subscribe( (data) => {
        this.router.navigate(['/login'],
        {queryParams:{registered:'true'}});
      }, (error) => {
        this.toastr.error('Registration Failed!, please try again');
      });
  }
  

}
