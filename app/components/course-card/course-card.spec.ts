/// <reference types="jasmine" />

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { CourseCard } from './course-card';

describe('CourseCard', () => {
  let component: CourseCard;
  let fixture: ComponentFixture<CourseCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCard],
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCard);
    component = fixture.componentInstance;
    component.course = {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: true
    };
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render the course name', () => {
    const title = fixture.debugElement.query(By.css('h3'))?.nativeElement.textContent;
    expect(title).toContain('Angular');
  });

  it('should emit the course id on enroll', () => {
    spyOn(component.enroll, 'emit');
    component.onEnroll();
    expect(component.enroll.emit).toHaveBeenCalledWith(1);
  });
});
