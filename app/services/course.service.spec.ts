/// <reference types="jasmine" />

import { TestBed } from '@angular/core/testing';
import { CourseService } from './course.service';

describe('CourseService', () => {
  let service: CourseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CourseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return courses', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBeGreaterThan(0);
    });
  });
});
