import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TwittearComponent } from './twittear.component';

describe('TwittearComponent', () => {
  let component: TwittearComponent;
  let fixture: ComponentFixture<TwittearComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TwittearComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TwittearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
