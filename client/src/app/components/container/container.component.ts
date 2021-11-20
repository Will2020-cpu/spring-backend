import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
  numbers:number[] = [];

  constructor() { 
    this.numbers = Array(100).fill(1).map((x,i)=>i); // [0,1,2,3,4]
  }

  ngOnInit(): void {
  }

}
