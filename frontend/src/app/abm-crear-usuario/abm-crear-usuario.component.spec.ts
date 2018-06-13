import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmCrearUsuarioComponent } from './abm-crear-usuario.component';

describe('AbmCrearUsuarioComponent', () => {
  let component: AbmCrearUsuarioComponent;
  let fixture: ComponentFixture<AbmCrearUsuarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbmCrearUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmCrearUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
