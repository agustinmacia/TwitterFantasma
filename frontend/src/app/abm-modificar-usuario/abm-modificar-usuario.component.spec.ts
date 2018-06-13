import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmModificarUsuarioComponent } from './abm-modificar-usuario.component';

describe('AbmModificarUsuarioComponent', () => {
  let component: AbmModificarUsuarioComponent;
  let fixture: ComponentFixture<AbmModificarUsuarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbmModificarUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmModificarUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
